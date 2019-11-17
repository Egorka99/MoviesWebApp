package FilmsProject.DataLayer.jpa;

import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;

import java.time.LocalDate;
import java.util.List;

public class FilmAccessJPA implements FilmAccessService{

    @Override
    public List<Film> getFilmsByField(String field, String value) {
        return null;
    }

    @Override
    public List<Review> getFilmReviews(String filmIdentifier) {
        return null;
    }

    @Override
    public boolean addNewReview(String filmIdentifier, Review review) {
        return false;
    }

    @Override
    public boolean deleteReview(Long reviewId) {
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, LocalDate date, String reviewText, double rating) {
        return false;
    }
}
