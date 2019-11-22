package FilmsProject.DataLayer.jpa;

import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

@Component
public class FilmAccessJPA implements FilmAccessService {

    private EntityManager manager;

    @Autowired
    private ReviewRepository reviewRepository;

    public FilmAccessJPA() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("movies");
        manager = factory.createEntityManager();
    }

    @Override
    public Film getFilmByIdentifier(String identifier) {
       return manager.find(Film.class, identifier);
    }

    @Override
    public List<Film> getFilmsByTitle(String title) {
        TypedQuery<Film> q = manager.createQuery(
                "Select c from Film c Where c.title = ?1", Film.class);
        q.setParameter(1,title);
        return  q.getResultList();
    }

    @Override
    public List<Film> getFilmsByReleaseDate(LocalDate date) {
        TypedQuery<Film> q = manager.createQuery(
                "Select c from Film c Where c.releaseDate = ?1", Film.class);
        q.setParameter(1,date);
        return  q.getResultList();
    }
 
    @Override
    public List<Film> getFilmsInRange(Double fromRating, Double toRating) {
        TypedQuery<Film> typedQuery = manager.createQuery("Select m from Movie m WHERE m.rating BETWEEN ?1 AND ?2",Film.class);
        typedQuery.setParameter(1,fromRating);
        typedQuery.setParameter(2,toRating);
        return  typedQuery.getResultList();
    }

    @Override
    public List<Film> getFilmsInRange(LocalDate fromYear, LocalDate toYear) {
        TypedQuery<Film> typedQuery = manager.createQuery("Select m from Movie m WHERE m.releaseDate BETWEEN ?1 AND ?2",Film.class);
        typedQuery.setParameter(1,fromYear);
        typedQuery.setParameter(2,toYear);
        return  typedQuery.getResultList();
    }

    @Override
    public List<Review> getFilmReviews(String filmIdentifier) {
        TypedQuery<Review> q = manager.createQuery(
                "Select c from Review c Where c.filmIdentifier = ?1", Review.class);
        q.setParameter(1,filmIdentifier);
        return  q.getResultList();
    }

    @Override
    public boolean addNewReview(String filmIdentifier, Review review) {
        review.setFilmIdentifier(filmIdentifier);
        manager.getTransaction().begin();
        manager.persist(review);
        manager.getTransaction().commit();
        return manager.find(Review.class,review.getReviewId()).getReviewId() != null;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        Review review = manager.find(Review.class, reviewId);

        if (review.getReviewId() != null) {
            manager.getTransaction().begin();
            manager.remove(review);
            manager.getTransaction().commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, LocalDate date, String reviewText, double rating){
        Review review = manager.find(Review.class, reviewId);

        if (review.getReviewId() != null) {
            manager.getTransaction().begin();
            review.setCreateDate(date);
            review.setReviewText(reviewText);
            review.setRating(rating);
            manager.getTransaction().commit();
            return true;
        }

        return false;

    }
}
