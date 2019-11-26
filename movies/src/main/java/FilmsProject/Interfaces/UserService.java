package filmsproject.interfaces;

import filmsproject.model.User;

public interface UserService {
    User signIn(String login, String password);
    boolean signUp(String userName, String userLogin, String userPassword);
    boolean writeReview(String authorLogin, String filmIdentifier,String reviewText,double rating);
    boolean updateReview(String filmidentifier, Long currentReviewId,String reviewText,double rating);
    
}
