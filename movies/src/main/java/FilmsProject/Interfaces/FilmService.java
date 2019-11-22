package FilmsProject.Interfaces;

import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import FilmsProject.Model.SearchInRangeProperty;
import FilmsProject.Model.SearchProperty;

import java.util.List;

public interface FilmService {
    //TODO Доработать поиск учитывая предпоследнюю презу
    List<Film> searchFilmsByProperty(SearchProperty property, String value);
    List<Film> searchFilmsInRange(SearchInRangeProperty property, String from, String to);
    List<Review> getReviews(String filmIdentifier);
    Object[] getFilmDetails(String filmIdentifier);
}
