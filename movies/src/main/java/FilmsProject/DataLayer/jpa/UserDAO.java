package FilmsProject.DataLayer.jpa;

import FilmsProject.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

}
