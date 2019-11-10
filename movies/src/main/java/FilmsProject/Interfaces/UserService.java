package FilmsProject.Interfaces;

import FilmsProject.Model.User;

public interface UserService {
    User signIn(String login, String password);
    boolean signUp(String userName, String userLogin, String userPassword);
    boolean writeReview(User author, String filmIdentifier,String reviewText,double rating);
    boolean updateReview(User authorOfCurrentReview, String filmidentifier, Long currentReviewId,String reviewText,double rating);
    
}
