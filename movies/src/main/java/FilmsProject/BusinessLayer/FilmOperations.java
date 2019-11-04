package FilmsProject.BusinessLayer;

import FilmsProject.DataLayer.FilmAccessDB;
import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Interfaces.FilmService;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilmOperations implements FilmService {

    private FilmAccessService filmAccessService = new FilmAccessDB();

    @Override
    public List<Film> searchFilmByField(String field, String value) {
       return filmAccessService.getFilmsByProperty(field,value);
    }

    @Override
    public List<Review> getReviews(String filmIdentifier) {
        return filmAccessService.getFilmReviews(filmIdentifier);
    }
}
