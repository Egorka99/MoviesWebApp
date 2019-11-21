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

//TODO Протестить данный класс
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
    public List<Film> getFilmsByField(String field, String value) {
       return null;
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
