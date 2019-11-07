package FilmsProject.Interfaces;

import FilmsProject.Model.Film;
import FilmsProject.Model.Review;

import java.util.List;

public interface FilmService {
    List<Film> searchFilmByField(String field, String value);
    List<Review> getReviews(String filmIdentifier);
    Object[] getFilmDetails(String filmIdentifier);
}
