package filmsproject.businesslayer;

import filmsproject.interfaces.AdminService;
import filmsproject.interfaces.FilmAccessService;
import filmsproject.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AdminOperations implements AdminService {

   @Autowired
   @Qualifier("filmAccessJPA")
   private FilmAccessService filmAccessService;

    @Override
    public boolean updateReview(Admin editor, Long reviewId, String reviewText, double rating)  {
        LocalDate currentDate = LocalDate.now();
        if (editor != null) {
           return filmAccessService.updateReview(reviewId,currentDate,reviewText,rating);
        }
        return false;
    }

    @Override
    public boolean deleteReview(Admin editor, Long reviewId) {
        if (editor != null) {
           return filmAccessService.deleteReview(reviewId);
        }
        return false;
    }
}
