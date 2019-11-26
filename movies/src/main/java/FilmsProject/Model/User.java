package filmsproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User  {

    @Column(name = "name")
    private String name;

    @Id
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
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
