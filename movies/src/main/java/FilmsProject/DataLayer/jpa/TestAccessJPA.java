package FilmsProject.DataLayer.jpa;

import FilmsProject.Model.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

@Component
public class TestAccessJPA{

    private EntityManager manager;

    public TestAccessJPA() {
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("movies");
       manager = factory.createEntityManager();
    }

    public boolean getAllFilms()
    { 
        Film film = new Film();

        film.setImdbIdentifier("326");
        film.setRating(8.9);
        film.setDescription("description");
        film.setFilmType(FilmType.FILM);
        film.setTitle("The Shawshank Redemption");
        film.setReleaseDate(LocalDate.parse("1994-10-03"));

        Film film1 = new Film();

        film1.setImdbIdentifier("258687");
        film1.setRating(8.6);
        film1.setDescription("description");
        film1.setFilmType(FilmType.FILM);
        film1.setTitle("Interstellar");
        film1.setReleaseDate(LocalDate.parse("2014-10-03"));

        Film film2 = new Film();

        film2.setImdbIdentifier("464963");
        film2.setRating(9.4);
        film2.setDescription("description");
        film2.setFilmType(FilmType.SERIES);
        film2.setTitle("Game of Thrones");
        film2.setReleaseDate(LocalDate.parse("2011-10-03"));

        Film film3 = new Film();

        film3.setImdbIdentifier("502838");
        film3.setRating(9.1);
        film3.setDescription("description");
        film3.setFilmType(FilmType.SERIES);
        film3.setTitle("Sherlock");
        film3.setReleaseDate(LocalDate.parse("2012-10-03"));

        Film film4 = new Film();

        film4.setImdbIdentifier("77164");
        film4.setRating(8.7);
        film4.setDescription("description");
        film4.setFilmType(FilmType.CARTOON);
        film4.setTitle("The Simpsons");
        film4.setReleaseDate(LocalDate.parse("1999-10-03"));

        Film film5 = new Film();

        film5.setImdbIdentifier("46483");
        film5.setRating(8.6);
        film5.setDescription("description");
        film5.setFilmType(FilmType.SERIES);
        film5.setTitle("Nu, pogodi!");
        film5.setReleaseDate(LocalDate.parse("1965-10-03"));


        Review review = new Review(LocalDate.parse("2014-10-03"),"user123","description",8.9);
        Review review1 = new Review(LocalDate.parse("2014-10-03"),"user133","description",7.4);
        Review review2 = new Review(LocalDate.parse("2014-10-03"),"user223","description",5.9);
        Review review3 = new Review(LocalDate.parse("2014-10-03"),"user1023","description",9.1);
        Review review4 = new Review(LocalDate.parse("2014-10-03"),"user723","description",5.5);

        review.setFilmIdentifier("326");
        review1.setFilmIdentifier("258687");
        review2.setFilmIdentifier("464963");
        review3.setFilmIdentifier("502838");
        review4.setFilmIdentifier("77164");

        Genre genre = new Genre();
        genre.setGenreName("Comedy");

        Genre genre1 = new Genre();
        genre.setGenreName("Drama");

        Genre genre2 = new Genre();
        genre.setGenreName("Fantastic");

        Genre genre3 = new Genre();
        genre.setGenreName("Fantasy");

        Genre genre4 = new Genre();
        genre.setGenreName("Detective");

        manager.getTransaction().begin();
        manager.persist(review);
        manager.persist(review1);
        manager.persist(review2);
        manager.persist(review3);
        manager.persist(review4);

        manager.persist(genre);
        manager.persist(genre1);
        manager.persist(genre2);
        manager.persist(genre3);
        manager.persist(genre4);

        film.addGenre(genre1);
        film1.addGenre(genre2);
        film2.addGenre(genre3);
        film3.addGenre(genre4);
        film4.addGenre(genre);
        film5.addGenre(genre);

        manager.persist(film);
        manager.persist(film1);
        manager.persist(film2);
        manager.persist(film3);
        manager.persist(film4);
        manager.persist(film5);

        manager.getTransaction().commit();
        manager.close();

        return true;
    }

}
