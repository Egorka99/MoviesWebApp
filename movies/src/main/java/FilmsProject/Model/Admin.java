package FilmsProject.Model;

import org.springframework.stereotype.Component;

@Component
public class Admin extends Person {

    public Admin() {
        name = "admin";
        login = "admin";
        password = "admin";
    }

}
