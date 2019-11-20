package FilmsProject.BusinessLayer;

import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Interfaces.FilmService;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmOperations implements FilmService {

    @Autowired
    @Qualifier("filmAccessJPA")
    private FilmAccessService filmAccessService;

    //TODO сделать енамом
    @Override
    public List<Film> searchFilmsByProperty(String property, String value) {
        return filmAccessService.getFilmsByField(property,value);
    }

    @Override
    public List<Review> getReviews(String filmIdentifier) {
        return filmAccessService.getFilmReviews(filmIdentifier);
    }

    @Override
    public Object[] getFilmDetails(String filmIdentifier) {
        List<Object> filmInfoAndReviews = new ArrayList<>();

        filmInfoAndReviews.add(searchFilmsByProperty("IMDBIdentifier",filmIdentifier));
        filmInfoAndReviews.add(getReviews(filmIdentifier));

        return filmInfoAndReviews.toArray();
    }




}
