package FilmsProject.Model;

import java.util.Objects;

public abstract class Person {
    protected String name;
    protected String login;
    protected String password;

    protected void logOut() {
        name = null;
        login = null;
        password = null;
    }

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
        Person person = (Person) o;
        return login.equals(person.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
