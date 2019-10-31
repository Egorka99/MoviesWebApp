package FilmsProject.View;

import FilmsProject.Controller.FilmOperationImpl;
import FilmsProject.Controller.FilmStorage;
import FilmsProject.Controller.UserOperationImpl;
import FilmsProject.Model.*;

import java.time.LocalDate;

public class Test {

    public static void userTest() {
        UserOperationImpl userOperation = UserOperationImpl.getInstance();

        if (userOperation.signUp("Egor", "egorka99", "qwerty123")) {
            System.out.println("Пользователь успешно зарегистрирован ");
        } else {
            System.err.println("Не удалось зарегистрироваться ");
        } //true
        if ( userOperation.signUp("FakeEgor","egorka99","qwertyf123")) {
            System.out.println("Пользователь успешно зарегистрирован ");
        } else {
            System.err.println("Не удалось зарегистрироваться ");
        } //false


        User user = null;
        try { //true
            user = userOperation.signIn("egorka99","qwerty123");
            System.out.println("Пользователь авторизован!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ошибка при авторизации");
        }

        try { // false
            userOperation.signIn("nonexisted","logpass");
            System.out.println("Пользователь авторизован!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void filmStorageTest() {
        LocalDate date = LocalDate.of(2019,8,13);

        Film newFilm = new Film("Marvel Avengers","wadq213213", FilmType.FILM,"Action",
                date, 8.1,"Marvel Film");
        Film newFilm2 = new Film("Marvel Avengers: Infinity War","waddq213213",FilmType.FILM,"Action",
                date, 8.1,"Marvel Film");

        FilmStorage filmStorage = FilmStorage.getInstance();

        filmStorage.addNewFilm(newFilm);
        filmStorage.addNewFilm(newFilm2);

        System.out.println("Все фильмы: ");
        for (Film film: filmStorage.getFilms()) {
            System.out.println(film.getTitle());
        }
    }
    public static void searchFilmTest() {

        UserOperationImpl userOperation =  UserOperationImpl.getInstance();
        userOperation.signUp("Egor","egorka99","qwerty123");

        try {
            userOperation.signIn("egorka99","qwerty123");
            System.out.println("Пользователь авторизован!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ошибка при авторизации");
        }

        LocalDate date1 = LocalDate.of(2019,8,13);
        LocalDate date2 = LocalDate.of(2019,10,22);


        Film newFilm = new Film("Marvel Avengers","wadq213213",FilmType.FILM,"Action",
                date1, 8.1,"Marvel Film");
        Film newFilm2 = new Film("Games Of Thrones","43242213213",FilmType.SERIES,"Series",
                date2, 7.1,"Game of Thrones is an American fantasy drama television series created by " +
                "David Benioff and D. B. Weiss for HBO. It is an adaptation of A Song of Ice and Fire, George R. R. ... " +
                "The series premiered on HBO in the United States on April 17, 2011, and concluded on May 19, 2019, with " +
                "73 episodes broadcast over eight seasons.");
        Film newFilm3 = new Film("Woody Woodpecker","435345433",FilmType.CARTOON,"Comedy",
                date2, 9.1,"Woody Woodpecker is an animated cartoon character, an anthropomorphic" +
                " red-headed woodpecker who appeared in theatrical short films produced by the Walter Lantz animation" +
                " studio and distributed by Universal Studios.");

        FilmStorage filmStorage = FilmStorage.getInstance();

        filmStorage.addNewFilm(newFilm);
        filmStorage.addNewFilm(newFilm2);
        filmStorage.addNewFilm(newFilm3);

        System.out.println();
        System.out.println("Поиск фильма по дате 22.10.2019");
        System.out.println();

        ConsoleInfo.getSearchResult(FilmOperationImpl.getInstance().searchFilmByTitle("a")); // avengers and games of thrones

    }

    public static void reviewTest() {

        UserOperationImpl userOperation = UserOperationImpl.getInstance();
        userOperation.signUp("Egor","egorka99","qwerty123");

        User user = new User();
        try {
            user = userOperation.signIn("egorka99","qwerty123");
            System.out.println("Пользователь авторизован!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ошибка при авторизации");
        }

        LocalDate date1 = LocalDate.of(2019,8,13);

        Film newFilm = new Film("Marvel Avengers", "213213", FilmType.FILM, "Action",
                date1, 8.1, "Marvel Film");

        FilmStorage.getInstance().addNewFilm(newFilm);

        FilmOperationImpl.getInstance().addReview("213213",user,"bla bla", 8.1);
        FilmOperationImpl.getInstance().addReview("213213",user,"bla bla bla ",8.4);


        System.out.println("ID всех отзывов фильма: ");
        for (Film film : FilmOperationImpl.getInstance().searchFilmByIdentifier("213213")) {
            for (Review rw : film.getReviewList()) {
                System.out.println(rw.getReviewId());
            }
        }

        System.out.println("---");
        Admin admin = new Admin();

        FilmOperationImpl.getInstance().deleteReview("213213",admin,1);

        System.out.println("Удаляем отзыв с ID 1...");
        System.out.println("ID всех отзывов фильма: ");
        for (Film film : FilmOperationImpl.getInstance().searchFilmByIdentifier("213213")) {
            for (Review rw : film.getReviewList()) {
                System.out.println(rw.getReviewId());
            }
        }
        System.out.println("---");

        FilmOperationImpl.getInstance().updateReview("213213",admin,2,"...",8.7);

        System.out.println("Изменяем отзыв с ID 2 на отзыв с ID 3");
        System.out.println("ID всех отзывов фильма: ");


        for (Film film : FilmOperationImpl.getInstance().searchFilmByIdentifier("213213")) {
            for (Review rw : film.getReviewList()) {
                System.out.println(rw.getReviewId());
            }
        }
    }

    public static void filmInfoTest() {
        UserOperationImpl userOperation = UserOperationImpl.getInstance();
        userOperation.signUp("Egor","egorka99","qwerty123");

        User user = new User();
        try {
            user = userOperation.signIn("egorka99","qwerty123");
            System.out.println("Пользователь авторизован!");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Ошибка при авторизации");
        }

        LocalDate date1 = LocalDate.of(2019,8,13);
        Film newFilm = new Film("Marvel Avengers", "213213", FilmType.FILM, "Action",
                date1, 8.1, "Marvel Film");

        FilmStorage.getInstance().addNewFilm(newFilm);

        FilmOperationImpl.getInstance().addReview("213213",user,"Фильм ниче так кста",8.1);
        FilmOperationImpl.getInstance().addReview("213213",user,"Классный фильм",8.5);

        ConsoleInfo.getInfoln(newFilm);
        ConsoleInfo.getFullInfo(newFilm);
    }

    public static void main(String[] args) {
         userTest();
//       filmStorageTest();
//       searchFilmTest();
//       reviewTest();
//       filmInfoTest();
    }
}
