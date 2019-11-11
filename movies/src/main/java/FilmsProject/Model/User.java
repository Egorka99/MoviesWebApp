package FilmsProject.Model;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class User  {

    @Column(name = "name")
    private String name;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name="password")
    private String password;

    public User(String userName, String userLogin, String userPassword) {
        this.name = userName;
        this.login = userLogin;
        this.password = userPassword;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

}
