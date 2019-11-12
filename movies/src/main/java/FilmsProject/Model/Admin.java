package FilmsProject.Model;

import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class Admin  {

    private String name;
    private String login;
    private String password;

    public Admin() {
        name = "admin";
        login = "admin";
        password = "admin";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
