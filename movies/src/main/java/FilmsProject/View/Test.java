package FilmsProject.View;

import FilmsProject.BusinessLayer.FilmOperations;
import FilmsProject.BusinessLayer.UserOperations;
import FilmsProject.DataLayer.FilmAccessDB;
import FilmsProject.DataLayer.UserAccessDB;
import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.User;

import java.sql.SQLException;
import java.util.function.DoubleToIntFunction;

public class Test {
    public static void addTestData(){
        FilmAccessDB FilmAccessDB = new FilmAccessDB();
        UserAccessDB userAccessDB = new UserAccessDB();
        try {
            FilmAccessDB.createFilmTable();
            FilmAccessDB.createReviewTable();
            userAccessDB.createTable();
            FilmAccessDB.addTestData();
            FilmAccessDB.addReviewTestData();
            System.out.println("Успешно!");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void filmSearch(){
        FilmAccessService filmAccessService = new FilmAccessDB();
        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("IMDBidentifier","326"));
        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("IMDBidentifier","3226")); //nonexist
        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("releasedate","1965-10-03"));
    }
    public static void userRegistration() {
        UserService userService = new UserOperations();
        System.out.println(userService.signUp("Egor","egorka99","qwerty123"));
        System.out.println(userService.signUp("Egor","egorka99","qwerddty123"));
        System.out.println(userService.signUp("Egor","ivan99","qwerty123"));
        System.out.println(userService.signIn("egorka99","qwerty123")); //true
        System.out.println(userService.signIn("egorka99","qwertwday123")); //false
        System.out.println(userService.signIn("ivan99","qwerty123")); //true

    }
    public static void userWriteUpdateReview() {
        UserService userService = new UserOperations();
        FilmAccessService filmAccessService = new FilmAccessDB();

        userService.signUp("Egor","egorka99","qwerty123");
        User user = userService.signIn("egorka99","qwerty123");
        userService.writeReview(user,"326", "норм", 8.4);

        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("IMDBidentifier","326"));


    }
    public static void adminUpdateDeleteReview() {

    }
    public static void main(String[] args) {
        addTestData();
        //filmSearch();
       // userRegistration();
        userWriteUpdateReview();
    }
}
