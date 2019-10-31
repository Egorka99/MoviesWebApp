package FilmsProject.Controller;

import FilmsProject.Model.Film;

import java.util.Comparator;

public class FilmRatingComparator implements Comparator<Film> {
    public int compare(Film film1,Film film2) {
        return Double.compare(film1.getRating(), film2.getRating());
    }
}
