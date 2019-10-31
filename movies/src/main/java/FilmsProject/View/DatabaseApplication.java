package FilmsProject.View;

import FilmsProject.Database.FilmTable;
import FilmsProject.Database.UserTable;
import FilmsProject.Model.Film;
import FilmsProject.Model.User;

import java.sql.SQLException;
import java.time.LocalDate;

public class DatabaseApplication {
    public static void main(String[] args) {

        UserTable userTable = new UserTable();

        try {
            userTable.createTable();
            System.out.println("Таблица пользователь успешно создана!");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось создать таблицу. Возможно,неправильно сформирован SQL запрос");
            ex.printStackTrace();
        }

        try {
            if (userTable.signUp("Egor","egorka99","qwerty123")) {
                System.out.println("Пользователь успешно зарегистрирован!");
            }
            else {
                System.out.println("Пользователь с таким логином уже существует");
            }
        }
        catch (SQLException ex) {
            System.err.println("Не удалось создать пользователя");
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Не удалось создать пользователя. Не найден драйвер для подключения к БД");
            ex.printStackTrace();
        }

        try {
            userTable.signIn("egorka99","qwerty123");
            System.out.println("Пользователь успешно авторизировался!");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось создать пользователя");
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            System.err.println("Не удалось создать пользователя. Не найден драйвер для подключения к БД");
            ex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


        FilmTable filmTable = new FilmTable();
        try {
            filmTable.createTable();
            System.out.println("Таблица успешно создана!");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось создать таблицу. Возможно,неправильно сформирован SQL запрос");
            ex.printStackTrace();
        }


        try {
            filmTable.addTestData();
            System.out.println("Фильмы успешно добавлены!");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось добавить фильмы. Данные фильмы возможно уже добавлены");
            ex.printStackTrace();
        }

        try {
            filmTable.createReviewTable();
            System.out.println("Таблица отзывов успешно создана!");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось создать таблицу. Возможно,неправильно сформирован SQL запрос");
            ex.printStackTrace();
        }

        try {
            filmTable.addReviewTestData();
            System.out.println("Отзывы успешно добавлены");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось добавить отзывы.");
            ex.printStackTrace();
        }
        User user = new User();
        try {
            filmTable.addReview("77164",user,"bla bla ",8.9);
            System.out.println("Отзыв успешно добавлены");
        }
        catch (SQLException ex) {
            System.err.println("Не удалось добавить отзыв.");
            ex.printStackTrace();
        }

        try {
           for (Film film : filmTable.searchFilmByField("IMDBidentifier","77164")) {
               ConsoleInfo.getFullInfo(film);
           }
        }
        catch (SQLException ex) {
            System.err.println("Не удалось найти фильм.");
            ex.printStackTrace();
        }

        try {
            for (Film film : filmTable.searchFilmByField("title","The Shawshank Redemption")) {
                ConsoleInfo.getFullInfo(film);
            }
        }
        catch (SQLException ex) {
            System.err.println("Не удалось найти фильм.");
            ex.printStackTrace();
        }


        LocalDate date = LocalDate.of(2011,10,3);

        try {
            for (Film film : filmTable.searchFilmByField("releasedate",date.toString())) {
                ConsoleInfo.getFullInfo(film);
            }
        }
        catch (SQLException ex) {
            System.err.println("Не удалось найти фильм.");
            ex.printStackTrace();
        }


    }
}
