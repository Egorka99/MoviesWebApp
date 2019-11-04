package FilmsProject.View;

import FilmsProject.DataLayer.FilmAccessDB;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;

import java.sql.SQLException;
import java.util.List;

public class ConsoleInfo {

    public static void getFullInfo(Film film){
        System.out.printf("---Фильм № %s--- \n" +
                "Название: %s \n" +
                "Тип фильма: %s \n" +
                "Жанр фильма: %s \n" +
                "Дата выхода: %s \n" +
                "Оценка: %s \n" +
                "Описание фильма: \n" +
                "%s \n"
                ,film.getImdbIdentifier(),film.getTitle(),film.getFilmType(),film.getGenre(),film.getReleaseDate(),
                film.getRating(),film.getDescription());
        getReviewsInfo(film);
        getReviewsFromDBInfo(film);
    }

    public static void getReviewsInfo(Film film) {
        for (Review currentReview : film.getReviewList()) {
            System.out.printf("Отзыв № %s. Автор: %s. Дата создания: %s. Оценка: %s \n",currentReview.getReviewId(),
                    currentReview.getAuthor().getName(),currentReview.getCreateDate(),currentReview.getRating());
            System.out.println(currentReview.getReviewText());
        }
    }

    public static void getReviewsFromDBInfo(Film film){
        for (Review currentReview : new FilmAccessDB().getFilmReviews(film.getImdbIdentifier())) {
            System.out.printf("Отзыв № %s. Автор: %s. Дата создания: %s. Оценка: %s \n",currentReview.getReviewId(),
                    currentReview.getAuthor().getName(),currentReview.getCreateDate(),currentReview.getRating());
            System.out.println(currentReview.getReviewText());
        }
    }

    public static void getInfoln(Film film){
        System.out.printf("Фильм № %s " +
                        "Название: %s " +
                        "Оценка: %s \n"
                ,film.getImdbIdentifier(),film.getTitle(),film.getRating());
    }

    public static void getSearchResult(List<Film> foundFilms)  {
        System.out.println();
        System.out.println("Найденные фильмы: ");
            for (Film foundFilm: foundFilms) {
                getFullInfo(foundFilm);
                System.out.println();
            }
    }



}
