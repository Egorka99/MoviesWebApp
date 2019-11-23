package FilmsProject.Interfaces;

import FilmsProject.Model.Film;
import FilmsProject.Model.Genre;
import FilmsProject.Model.Review;

import java.time.LocalDate;
import java.util.List;

public interface FilmAccessService {
    Film getFilmByIdentifier(String identifier);
    List<Film> getFilmsByTitle(String title);
    List<Film> getFilmsByReleaseDate(LocalDate date);
    List<Film> getFilmsInRange(Double fromRating, Double toRating);
    List<Film> getFilmsInRange(LocalDate fromYear, LocalDate toYear);
    List<Genre> getAllGenres();
    List<Review> getFilmReviews(String filmIdentifier);
    boolean addNewReview(String filmIdentifier,Review review);
    boolean deleteReview(Long reviewId);
    boolean updateReview(Long reviewId, LocalDate date, String reviewText, double rating);
}
