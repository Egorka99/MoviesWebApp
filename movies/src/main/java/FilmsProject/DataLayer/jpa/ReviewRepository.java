package FilmsProject.DataLayer.jpa;

import FilmsProject.Model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReviewRepository extends CrudRepository<Review,Long> {

}
