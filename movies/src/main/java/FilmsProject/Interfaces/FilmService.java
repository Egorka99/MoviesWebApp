package FilmsProject.Interfaces;

import FilmsProject.Model.*;

import java.util.List;

public interface FilmService {
    List<Film> searchFilmsByProperty(SearchProperty property, String value);
    List<Film> searchFilmsInRange(SearchInRangeProperty property, String from, String to);
    List<Genre> searchAllGenres();
    List<Review> getReviews(String filmIdentifier);
    Object[] getFilmDetails(String filmIdentifier);
}
