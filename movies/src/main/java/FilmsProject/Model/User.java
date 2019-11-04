package FilmsProject.Model;


import org.springframework.stereotype.Component;

@Component
public class User extends Person {

    public User(String userName, String userLogin, String userPassword) {
        this.name = userName;
        this.login = userLogin;
        this.password = userPassword;
    }

    public User(String userLogin) {
        this.login = login;
    }

    public User() {}

}
