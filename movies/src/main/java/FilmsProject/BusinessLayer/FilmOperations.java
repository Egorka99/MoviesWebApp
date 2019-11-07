package FilmsProject.BusinessLayer;

import FilmsProject.DataLayer.FilmAccessDB;
import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Interfaces.FilmService;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmOperations implements FilmService {

    @Autowired
    private FilmAccessService filmAccessService;

    @Override
    public List<Film> searchFilmByField(String field, String value) {
       return filmAccessService.getFilmsByProperty(field,value);
    }

    @Override
    public List<Review> getReviews(String filmIdentifier) {
        return filmAccessService.getFilmReviews(filmIdentifier);
    }

    @Override
    public Object[] getFilmDetails(String filmIdentifier) {
        List<Object> filmInfoAndReviews = new ArrayList<>();

        filmInfoAndReviews.add(searchFilmByField("IMDBIdentifier",filmIdentifier));
        filmInfoAndReviews.add(getReviews(filmIdentifier));

        return filmInfoAndReviews.toArray();
    }




}
