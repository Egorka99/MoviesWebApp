package FilmsProject.View;

import FilmsProject.Model.Film;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleInfo {

    public void getFullInfo(Film film){
        System.out.printf("---Фильм № %s--- \n" +
                "Название: %s \n" +
                "Тип фильма: %s \n" +
                "Дата выхода: %s \n" +
                "Оценка: %s \n" +
                "Описание фильма: \n" +
                "%s \n"
                ,film.getImdbIdentifier(),film.getTitle(),film.getFilmType(),film.getReleaseDate(),
                film.getRating(),film.getDescription());
    }

    public void getInfoln(Film film){
        System.out.printf("Фильм № %s " +
                        "Название: %s " +
                        "Оценка: %s \n"
                ,film.getImdbIdentifier(),film.getTitle(),film.getRating());
    }

    public void getSearchResult(List<Film> foundFilms)  {
        System.out.println();
        System.out.println("Найденные фильмы: ");
            for (Film foundFilm: foundFilms) {
                getFullInfo(foundFilm);
                System.out.println();
            }
    }



}
