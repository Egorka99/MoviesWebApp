package FilmsProject.Model;

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

}
