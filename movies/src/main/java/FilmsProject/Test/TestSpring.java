package FilmsProject.Test;

import FilmsProject.BusinessLayer.AdminOperations;
import FilmsProject.BusinessLayer.FilmOperations;
import FilmsProject.Model.Admin;
import FilmsProject.Model.Film;
import FilmsProject.View.ConsoleInfo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TestBean testBean = context.getBean("someBean",TestBean.class);
        testBean.info();

       FilmOperations adminOperations = context.getBean("filmOperations",FilmOperations.class);

        List<Film> filmsList = adminOperations.searchFilmByField("IMDBIdentifier","326");

        for (Film film: filmsList) {
            ConsoleInfo.getFullInfo(film);
        }


    }
}
