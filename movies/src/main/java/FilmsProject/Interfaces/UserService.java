package FilmsProject.Interfaces;

import FilmsProject.Model.User;

public interface UserService {
    User signIn(String login, String password);
    boolean signUp(String userName, String userLogin, String userPassword);
    boolean writeReview(String authorLogin, String filmIdentifier,String reviewText,double rating);
    boolean updateReview(String authorLoginOfCurrentReview, String filmidentifier, Long currentReviewId,String reviewText,double rating);
    
}
