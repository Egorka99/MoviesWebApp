package FilmsProject.DataLayer.jpa;

import FilmsProject.Model.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Component
public class TestAccessJPA {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("movies");
    private EntityManager manager = factory.createEntityManager();

    public TestAccessJPA() {
    }

    public List<User> getAll()
    {
        TypedQuery<User> q = manager.createQuery(
                "Select c from User c", User.class);
        return  q.getResultList();
    }

    public List<Film> getAllFilms()
    {
        Film film = new Film();

        film.setImdbIdentifier("345");
        film.setRating(7.8);
        film.setDescription("bla bla");
        film.setFilmType(FilmType.FILM);
        film.setTitle("The Best Film");
        film.setReleaseDate(LocalDate.now());

        Genre genre = new Genre();
        genre.setGenreName("Comedy");
        manager.getTransaction().begin();
        System.err.println(genre.getGenreId());
        System.err.println(genre.getGenreName());
        manager.persist(genre);
        film.addGenre(genre);
        manager.persist(film);
        manager.getTransaction().commit();
        manager.close();

        TypedQuery<Film> q = manager.createQuery(
                "Select c from Film c", Film.class);
        return  q.getResultList();
    }

    public List<Review> getAllReviews()
    {
        TypedQuery<Review> q = manager.createQuery(
                "Select c from Review c", Review.class);
        return  q.getResultList();
    }

    public List<Genre> getAllGenres()
    {
        TypedQuery<Genre> q = manager.createQuery(
                "Select c from Genre c", Genre.class);
        return  q.getResultList();
    }

}
