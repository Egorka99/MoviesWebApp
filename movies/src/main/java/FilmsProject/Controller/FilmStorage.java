package FilmsProject.Controller;

import FilmsProject.Model.Film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FilmStorage {

    private static List<Film> listOfFilms = new ArrayList<>();

    private static FilmStorage instance;

    private FilmStorage(){
    }

    public static FilmStorage getInstance() {
        if (instance == null)
            instance = new FilmStorage();
        return instance;
    }

    private boolean isUniqueIdentifier(Film film) {
        for (Film currentFilm : listOfFilms) {
            if ( currentFilm.getImdbIdentifier().equals(film.getImdbIdentifier())) {
                return false;
            }
        }
        return true;
    }

    public boolean addNewFilm(Film film) {
        if (isUniqueIdentifier(film)) {
            listOfFilms.add(film);
            return true;
        }
        return false;
    }

//    public boolean addFilmsFromJSON(String response) {
//    }

    public List<Film> getSortFilms() {
        Collections.sort(listOfFilms,new FilmRatingComparator());
        return listOfFilms;
    }

    public List<Film> getFilms() {
        return listOfFilms;
    }

}
