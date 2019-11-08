package FilmsProject.Test;

import FilmsProject.BusinessLayer.AdminOperations;
import FilmsProject.BusinessLayer.FilmOperations;
import FilmsProject.BusinessLayer.UserOperations;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.Admin;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import FilmsProject.Model.User;
import FilmsProject.View.ConsoleInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBean testBean = context.getBean("someBean",TestBean.class);
        testBean.info();

       FilmOperations filmOperations = context.getBean("filmOperations",FilmOperations.class);

        List<Film> filmsList = filmOperations.searchFilmByField("IMDBIdentifier","326");

        for (Film film: filmsList) {
            new ConsoleInfo().getInfoln(film);
        }
        List<Review> reviewList = filmOperations.getReviews("326");

        for (Review review : reviewList) {
            System.out.println(review);
        }


        UserService userService = context.getBean("userOperations", UserOperations.class);

        User user = userService.signIn("egorka99","qwerty123");

        System.out.println(user.getName());

    }
}
