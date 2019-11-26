package filmsproject.datalayer.jpa;

import filmsproject.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ReviewRepository extends CrudRepository<Review,Long> {

}
