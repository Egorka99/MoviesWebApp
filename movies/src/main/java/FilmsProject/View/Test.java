package FilmsProject.View;

import FilmsProject.BusinessLayer.UserOperations;
import FilmsProject.DataLayer.jdbc.FilmAccessJDDB;
import FilmsProject.DataLayer.jdbc.UserAccessJDDB;
import FilmsProject.Interfaces.UserService;

import java.sql.SQLException;

public class Test {
    public static void addTestData(){
        FilmAccessJDDB FilmAccessJDDB = new FilmAccessJDDB();
        UserAccessJDDB userAccessJDDB = new UserAccessJDDB();
        try {
            FilmAccessJDDB.createFilmTable();
            FilmAccessJDDB.createReviewTable();
            userAccessJDDB.createTable();
            FilmAccessJDDB.addTestData();
            FilmAccessJDDB.addReviewTestData();
            System.out.println("Успешно!");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//    public static void filmSearch(){
//        FilmAccessService filmAccessService = new FilmAccessDB();
//        new onsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("IMDBidentifier","326"));
//        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("IMDBidentifier","3226")); //nonexist
//        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("releasedate","1965-10-03"));
//    }
    public static void userRegistration() {
        UserService userService = new UserOperations();
        System.out.println(userService.signUp("Egor","egorka99","qwerty123"));
        System.out.println(userService.signUp("Egor","egorka99","qwerddty123"));
        System.out.println(userService.signUp("Egor","ivan99","qwerty123"));
        System.out.println(userService.signIn("egorka99","qwerty123")); //true
        System.out.println(userService.signIn("egorka99","qwertwday123")); //false
        System.out.println(userService.signIn("ivan99","qwerty123")); //true

    }
//    public static void userWriteUpdateReview() {
//        UserService userService = new UserOperations();
//        FilmAccessService filmAccessService = new FilmAccessDB();
//
//        userService.signUp("Egor","egorka99","qwerty123");
//        User user = userService.signIn("egorka99","qwerty123");
//        userService.writeReview(user,"326", "норм", 8.4);
//
//        ConsoleInfo.getSearchResult(filmAccessService.getFilmsByProperty("IMDBidentifier","326"));
//    }
    public static void adminUpdateDeleteReview() {

    }
    public static void main(String[] args) {
        addTestData();
        //filmSearch();
       // userRegistration();
       // userWriteUpdateReview();
    }
}
