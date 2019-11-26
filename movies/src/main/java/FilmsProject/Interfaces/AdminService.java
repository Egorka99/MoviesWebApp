package filmsproject.interfaces;

import filmsproject.model.Admin;

public interface AdminService {
    boolean updateReview(Admin editor,Long reviewId, String reviewText, double rating);
    boolean deleteReview(Admin editor,Long reviewId);
}
