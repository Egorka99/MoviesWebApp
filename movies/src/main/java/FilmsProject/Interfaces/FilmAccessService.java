package FilmsProject.Interfaces;

import FilmsProject.Model.Film;
import FilmsProject.Model.Review;

import java.time.LocalDate;
import java.util.List;

public interface FilmAccessService {
    List<Film> getFilmsByProperty(String property, String value);
    List<Review> getFilmReviews(String filmIdentifier);
    boolean addNewReview(String filmIdentifier,Review review);
    boolean deleteReview(Long reviewId);
    boolean updateReview(Long reviewId, LocalDate date, String reviewText, double rating);
}
