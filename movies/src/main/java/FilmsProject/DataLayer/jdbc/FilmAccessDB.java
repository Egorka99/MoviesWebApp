package FilmsProject.DataLayer.jdbc;

import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Interfaces.UserAccessService;
import FilmsProject.Model.Film;
import FilmsProject.Model.FilmType;
import FilmsProject.Model.Review;
import FilmsProject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FilmAccessDB implements FilmAccessService {

    @Autowired
    private MoviesDB DBconnection;

    @Autowired
    private UserAccessService userAccessService;

    public boolean createFilmTable() throws SQLException {
        return DBconnection.getPreparedStatement("CREATE TABLE IF NOT EXISTS Film(\n" +
                "                IMDBidentifier VARCHAR(20) PRIMARY KEY, \n" +
                "                title VARCHAR(50) NOT NULL, \n" +
                "                filmtype INTEGER NOT NULL,\n" +
                "                genre VARCHAR(20) NOT NULL,\n" +
                "                releasedate DATE NOT NULL,\n" +
                "                rating DOUBLE NOT NULL,\n" +
                "                description VARCHAR(1000) NOT NULL)").execute();
    }

    public boolean createReviewTable() throws SQLException {
        return DBconnection.getPreparedStatement("CREATE TABLE IF NOT EXISTS Review(\n" +
                "                reviewId INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "                filmIdentifier VARCHAR(50) NOT NULL, \n" +
                "                createDate DATE NOT NULL, \n" +
                "                authorLogin VARCHAR(50),\n" +
                "                rating DOUBLE NOT NULL,\n" +
                "                reviewText VARCHAR(500) NOT NULL)").execute();
    }

    public void addTestData() throws SQLException {
        DBconnection.getPreparedStatement("INSERT INTO Film VALUES ('326', 'The Shawshank Redemption', 0, 'Drama', '1994-10-03', 8.9, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Film VALUES ('258687', 'Interstellar', 0,'Fantastic', '2014-10-03', 8.6, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Film VALUES ('464963', 'Game of Thrones', 1,'Fantasy', '2011-10-03', 9.4, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Film VALUES ('502838', 'Sherlock', 1,'Detective', '2012-10-03', 9.1, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Film VALUES ('77164', 'The Simpsons', 2,'Comedy', '1999-10-03', 8.7, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Film VALUES ('46483', 'Nu, pogodi!', 2,'Comedy', '1965-10-03', 8.6, 'description');").execute();
    }

    public void addReviewTestData() throws SQLException {
        DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, '326', '2014-10-03', 'user123', 8.9, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, '258687', '2011-10-03', 'user133', 7.4, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, '464963', '2013-10-03', 'user223', 5.9, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, '502838', '2015-10-03', 'user1023', 9.1, 'description');").execute();
        DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, '77164', '2017-10-03', 'user723', 5.5, 'description');").execute();
    }


    @Override
    public List<Film> getFilmsByField(String field, String value) {
        List<Film> foundFilms = new ArrayList<>();
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM FILM WHERE " + field + " = ?");
        try {
            preparedStatement.setString(1, value);
            ResultSet queryResult = preparedStatement.executeQuery();
            queryResult.first();
            Film film = new Film(
                    queryResult.getString("title"),
                    queryResult.getString("IMDBidentifier"),
                    FilmType.values()[queryResult.getInt("filmtype")],
                    queryResult.getString("genre"),
                    queryResult.getDate("releasedate").toLocalDate(),
                    queryResult.getDouble("rating"),
                    queryResult.getString("description"));

            foundFilms.add(film);
        } catch (SQLException ex) {
            System.err.println("Не удалось получить фильм по свойству");
        }

        return foundFilms;
    }

    @Override
    public List<Review> getFilmReviews(String filmIdentifier) {
        List<Review> filmReviews = new ArrayList<>();
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM Review WHERE filmIdentifier = ?");
        try {
            preparedStatement.setString(1, filmIdentifier);

            //TODO Исправть данную затычку, подгоняя юзера из БД по логину (В таблице Юзер есть поле userLogin)
            ResultSet queryResult = preparedStatement.executeQuery();
             User user = userAccessService.getUserByLogin(queryResult.getString("authorLogin"));
           // User user = new User();
            while (queryResult.next()) {
                Review review = new Review(
                        queryResult.getLong("reviewId"),
                        queryResult.getDate("createDate").toLocalDate(),
                        user,
                        queryResult.getString("reviewText"),
                        queryResult.getDouble("rating")
                );
                filmReviews.add(review);
            }
        } catch (SQLException ex) {
            System.err.println("Не удалось получить список отзывов.");
            ex.printStackTrace();
        }
        return filmReviews;
    }

    @Override
    public boolean addNewReview(String filmIdentifier, Review review) {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, ?, ?, ?, ?, ?);");
        try {
            preparedStatement.setString(1, filmIdentifier);
            preparedStatement.setDate(2, Date.valueOf(review.getCreateDate()));
            preparedStatement.setString(3, review.getAuthor().getLogin());
            preparedStatement.setDouble(4, review.getRating());
            preparedStatement.setString(5, review.getReviewText());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Не удалось добавить отзыв");
            return false;
        }

    }

    @Override
    public boolean deleteReview(Long reviewId) {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("DELETE FROM Review WHERE reviewId = ?");
        try {
            preparedStatement.setLong(1, reviewId);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Не удалось удалить отзыв");
            return false;
        }
    }

    @Override
    public boolean updateReview(Long reviewId, LocalDate date, String reviewText, double rating) {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("UPDATE Review SET " +
                "createDate = ?, " +
                "reviewText = ?, " +
                "rating = ? " +
                "WHERE reviewId = ?");
        try {
            preparedStatement.setDate(1,Date.valueOf(date));
            preparedStatement.setString(2,reviewText);
            preparedStatement.setDouble(3,rating);
            preparedStatement.setLong(4,reviewId);
            preparedStatement.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println("Не удалось изменить отзыв");
            ex.printStackTrace();
            return false;
        }
    }

}
