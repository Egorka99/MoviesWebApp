package FilmsProject.Interfaces;

import FilmsProject.Model.Admin;

public interface AdminService {
    boolean updateReview(Admin editor,Long reviewId, String reviewText, double rating);
    boolean deleteReview(Admin editor,Long reviewId);
}
