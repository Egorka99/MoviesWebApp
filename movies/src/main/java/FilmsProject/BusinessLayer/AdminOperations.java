package FilmsProject.BusinessLayer;

import FilmsProject.DataLayer.FilmAccessDB;
import FilmsProject.Interfaces.AdminService;
import FilmsProject.Interfaces.FilmAccessService;
import FilmsProject.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AdminOperations implements AdminService {

    @Autowired
    private FilmAccessService filmAccessService;

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
