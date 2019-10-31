package FilmsProject.Controller;

import FilmsProject.Model.Admin;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import FilmsProject.Model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilmOperationImpl {

    private static FilmOperationImpl instance = null;

    private FilmOperationImpl() {
    }

    public static FilmOperationImpl getInstance() {
        if (instance == null)
            instance = new FilmOperationImpl();
        return instance;
    }

    private FilmStorage filmStorage = FilmStorage.getInstance();

    public boolean addReview(String imdbIdentifier, User user, String reviewText, double rating) {
        LocalDate currentDate = LocalDate.now();
        Review review = new Review(currentDate,user,reviewText,rating);

        for (Film currentFilm: filmStorage.getFilms()) {
            if (currentFilm.getImdbIdentifier().equals(imdbIdentifier)) {
                currentFilm.addReviewInList(review);
                return true;
            }
        }
        return false;
    }

    public boolean updateReview(String imdbIdentifier, Admin author, int oldReviewId, String reviewText, double rating) {
        LocalDate currentDate = LocalDate.now();
        Review review = new Review(currentDate,author,reviewText,rating);

        for (Film currentFilm: filmStorage.getFilms()) {
        if (currentFilm.getImdbIdentifier().equals(imdbIdentifier)) {
            for (int i = 0; i < currentFilm.getReviewList().size(); i++) {
                if (currentFilm.getReviewFromListByIndex(i).getReviewId() == oldReviewId) {
                    currentFilm.replaceReview(i,review);
                    return true;
                }
            }
                currentFilm.addReviewInList(review);
            }
        }
        return false;
    }

    public boolean deleteReview(String imdbIdentifier, Admin author, int reviewId) {

        if (author != null) {
            for (Film currentFilm: filmStorage.getFilms()) {
                if (currentFilm.getImdbIdentifier().equals(imdbIdentifier)) {
                    for (int i = 0; i < currentFilm.getReviewList().size(); i++) {
                        if (currentFilm.getReviewFromListByIndex(i).getReviewId() == reviewId) {
                            currentFilm.removeReviewFromList(i);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public List<Film> searchFilmByIdentifier(String imdbIdentifier) {
        List<Film> foundFilmsList = new ArrayList<>();
        for (Film currentFilm : filmStorage.getSortFilms()) {
            if (currentFilm.getImdbIdentifier().contains(imdbIdentifier)) {
                foundFilmsList.add(currentFilm);
            }
        }
        return foundFilmsList;
    }

    public List<Film> searchFilmByTitle(String title) {
        List<Film> foundFilmsList = new ArrayList<>();
        for (Film currentFilm : filmStorage.getSortFilms()) {
            if (currentFilm.getTitle().contains(title)) {
                foundFilmsList.add(currentFilm);
            }
        }
        return foundFilmsList;
    }

    public List<Film> searchFilmByReleaseDate(LocalDate releaseDate) {
        List<Film> foundFilmsList = new ArrayList<>();
        for (Film currentFilm : filmStorage.getSortFilms()) {
            if (currentFilm.getReleaseDate().equals(releaseDate)) {
                foundFilmsList.add(currentFilm);
            }
        }
        return foundFilmsList;
    }

}
