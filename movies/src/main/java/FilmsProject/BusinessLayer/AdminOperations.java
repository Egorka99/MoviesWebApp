package FilmsProject.BusinessLayer;

import FilmsProject.DataLayer.FilmAccessDB;
import FilmsProject.Interfaces.AdminService;
import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Model.Admin;

import java.time.LocalDate;

public class AdminOperations implements AdminService {

    private FilmAccessService filmAccessService = new FilmAccessDB();

    @Override
    public boolean updateReview(Admin editor, int reviewId, String reviewText, double rating) {
        LocalDate currentDate = LocalDate.now();
        if (editor != null) {
           return filmAccessService.updateReview(reviewId,currentDate,reviewText,rating);
        }
        return false;
    }

    @Override
    public boolean deleteReview(Admin editor, int reviewId) {
        if (editor != null) {
           return filmAccessService.deleteReview(reviewId);
        }
        return false;
    }
}
