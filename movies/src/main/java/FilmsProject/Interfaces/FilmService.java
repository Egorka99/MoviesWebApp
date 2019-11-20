package FilmsProject.Interfaces;

import FilmsProject.Model.Film;
import FilmsProject.Model.Review;

import java.util.List;

public interface FilmService {
    //TODO Доработать поиск учитывая предпоследнюю презу
    List<Film> searchFilmsByProperty(String property, String value);
    List<Review> getReviews(String filmIdentifier);
    Object[] getFilmDetails(String filmIdentifier);
}
