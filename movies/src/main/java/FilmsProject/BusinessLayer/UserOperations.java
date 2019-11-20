package FilmsProject.BusinessLayer;

import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Interfaces.UserAccessService;
import FilmsProject.Interfaces.UserService;
import FilmsProject.Model.Review;
import FilmsProject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserOperations implements UserService {

    @Autowired
    private UserAccessService userAccessService;
    @Autowired
    private FilmAccessService filmAccessService;

    @Override
    public User signIn(String login, String password) {
        User existUser = userAccessService.getUserByLogin(login);
        return existUser.getPassword().equals(password) ? existUser : null;
    }

    @Override
    public boolean signUp(String userName, String userLogin, String userPassword) {
        if (userAccessService.getUserByLogin(userLogin) == null) {
             return userAccessService.addNewUser(new User(userName,userLogin,userPassword));
        }
        else return false;
    }

    @Override
    public boolean writeReview(String authorLogin, String filmIdentifier, String reviewText, double rating) {
        LocalDate reviewDate = LocalDate.now();
        Review review = new Review(null,reviewDate,authorLogin,reviewText,rating);
        return filmAccessService.addNewReview(filmIdentifier,review);
    }

    @Override
    public boolean updateReview(String authorLoginOfCurrentReview, String filmIdentifier, Long currentReviewId, String reviewText, double rating) {
        LocalDate currentDate = LocalDate.now();
        for (Review currentReview: filmAccessService.getFilmReviews(filmIdentifier)) {
            System.out.println(currentReview.getAuthorLogin());
            //TODO Вернуть обратно проверку на автора
            if (currentReview.getReviewId().equals(currentReviewId)) {
                return filmAccessService.updateReview(currentReviewId,currentDate,reviewText,rating);
            }
        }
        return false;
    }
}
