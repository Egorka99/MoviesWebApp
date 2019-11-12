package FilmsProject.DataLayer.jpa;

import FilmsProject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private UserDAO userDAO;

    @Autowired
    public DataInit(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = userDAO.count();

        if(count == 0) {
            User user1 = new User();

            user1.setName("Egor");
            user1.setLogin("egorka99");
            user1.setPassword("qwerty123");

            userDAO.save(user1);
        }


    }
}
