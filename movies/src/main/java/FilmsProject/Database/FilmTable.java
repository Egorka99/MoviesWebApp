package FilmsProject.Database;

import FilmsProject.Model.Film;
import FilmsProject.Model.FilmType;
import FilmsProject.Model.Review;
import FilmsProject.Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmTable extends BaseTable {

    MoviesDB DBconnection = MoviesDB.getInstance();

    public FilmTable() {
        super("Film");
    }

    public boolean createTable() throws SQLException{
        return execute("CREATE TABLE IF NOT EXISTS "+tableName+"(\n" +
                "                IMDBidentifier VARCHAR(20) PRIMARY KEY, \n" +
                "                title VARCHAR(50) NOT NULL, \n" +
                "                filmtype INTEGER NOT NULL,\n" +
                "                genre VARCHAR(20) NOT NULL,\n" +
                "                releasedate DATE NOT NULL,\n" +
                "                rating DOUBLE NOT NULL,\n" +
                "                description VARCHAR(1000) NOT NULL)");
    }

    public boolean createReviewTable() throws SQLException {
        return execute("CREATE TABLE IF NOT EXISTS Review(\n" +
                "                reviewId INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "                filmIdentifier VARCHAR(50) NOT NULL, \n" +
                "                createDate DATE NOT NULL, \n" +
                "                authorLogin VARCHAR(50),\n" +
                "                rating DOUBLE NOT NULL,\n" +
                "                reviewText VARCHAR(500) NOT NULL)");
    }

    public void addTestData() throws SQLException {
        execute("INSERT INTO Film VALUES ('326', 'The Shawshank Redemption', 0, 'Drama', '1994-10-03', 8.9, 'description');");
        execute("INSERT INTO Film VALUES ('258687', 'Interstellar', 0,'Fantastic', '2014-10-03', 8.6, 'description');");
        execute("INSERT INTO Film VALUES ('464963', 'Game of Thrones', 1,'Fantasy', '2011-10-03', 9.4, 'description');");
        execute("INSERT INTO Film VALUES ('502838', 'Sherlock', 1,'Detective', '2012-10-03', 9.1, 'description');");
        execute("INSERT INTO Film VALUES ('77164', 'The Simpsons', 2,'Comedy', '1999-10-03', 8.7, 'description');");
        execute("INSERT INTO Film VALUES ('46483', 'Nu, pogodi!', 2,'Comedy', '1965-10-03', 8.6, 'description');");
    }

    public void addReviewTestData() throws SQLException {
        execute("INSERT INTO Review VALUES (NULL, '326', '2014-10-03', 'user123', 8.9, 'description');");
        execute("INSERT INTO Review VALUES (NULL, '258687', '2011-10-03', 'user133', 7.4, 'description');");
        execute("INSERT INTO Review VALUES (NULL, '464963', '2013-10-03', 'user223', 5.9, 'description');");
        execute("INSERT INTO Review VALUES (NULL, '502838', '2015-10-03', 'user1023', 9.1, 'description');");
        execute("INSERT INTO Review VALUES (NULL, '77164', '2017-10-03', 'user723', 5.5, 'description');");
    }

    public List<Review> getReviews(String filmIdentifier) throws SQLException {
        List<Review> filmReviews = new ArrayList<>();
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM Review WHERE filmIdentifier = ?");
        preparedStatement.setString(1,filmIdentifier);
        User user = new User(); //TODO pizdec
        ResultSet queryResult = preparedStatement.executeQuery();
        while (queryResult.next()) {
            Review review = new Review(
                    queryResult.getDate("createDate").toLocalDate(),
                    user,
                    queryResult.getString("reviewText"),
                    queryResult.getDouble("rating")
            );
            filmReviews.add(review);
        }
        return filmReviews;
    }

    public boolean addReview(String imdbIdentifier, User user, String reviewText, double rating) throws SQLException {
        LocalDate currentDate = LocalDate.now();
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("INSERT INTO Review VALUES (NULL, ?, '"+currentDate+"', ?, ?, ?);");
        preparedStatement.setString(1,imdbIdentifier);
        preparedStatement.setString(2,user.getLogin());
        preparedStatement.setDouble(3,rating);
        preparedStatement.setString(4,reviewText);
        return preparedStatement.execute();
    }

    public List<Film> searchFilmByField(String field,String value) throws SQLException {
        List<Film> foundFilms = new ArrayList<>();
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM FILM WHERE "+field+" = ?");
        preparedStatement.setString(1,value);
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
        return foundFilms;
    }
}

