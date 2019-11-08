package FilmsProject.SpringTest;

import FilmsProject.BusinessLayer.AdminOperations;
import FilmsProject.BusinessLayer.FilmOperations;
import FilmsProject.BusinessLayer.UserOperations;
import FilmsProject.Interfaces.AdminService;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.Admin;
import FilmsProject.Model.Film;
import FilmsProject.Model.Review;
import FilmsProject.Model.User;
import FilmsProject.View.ConsoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class TestSpring {

    @Autowired
    Admin admin;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBean testBean = context.getBean("someBean",TestBean.class);
        testBean.info();

       FilmOperations filmOperations = context.getBean("filmOperations",FilmOperations.class);

        List<Film> filmsList = filmOperations.searchFilmByField("IMDBIdentifier","77164");

        for (Film film: filmsList) {
            new ConsoleInfo().getInfoln(film);
        }

        UserService userService = context.getBean("userOperations", UserOperations.class);
        User user = userService.signIn("egorka99","qwerty123");

        AdminService adminService = context.getBean("adminOperations", AdminService.class);
        Admin admin = context.getBean("admin", Admin.class);

       // adminService.deleteReview(admin,210L);

        adminService.updateReview(admin,213L,"bla bla", 1.1);

        List<Review> reviewList = filmOperations.getReviews("77164");

        for (Review review : reviewList) {
            System.out.println(review);
        }

    }
}
