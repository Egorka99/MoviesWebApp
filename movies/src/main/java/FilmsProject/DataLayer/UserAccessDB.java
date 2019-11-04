package FilmsProject.DataLayer;

import FilmsProject.Interfaces.UserAccessService;
import FilmsProject.Model.User;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Component
public class UserAccessDB implements UserAccessService {

    private MoviesDB DBconnection = MoviesDB.getInstance();

    public boolean createTable() throws SQLException {
        return DBconnection.getPreparedStatement("CREATE TABLE IF NOT EXISTS User(\n" +
                "                login VARCHAR(20) PRIMARY KEY, \n" +
                "                name VARCHAR(20) NOT NULL, \n" +
                "                password VARCHAR(20) NOT NULL)").execute();
    }

    @Override
    public User getUserByLogin(String login) {
        Statement preparedStatement = DBconnection.getStatement();
        try {
            ResultSet queryResult = preparedStatement.executeQuery("SELECT * FROM User WHERE login = '"+login+"';");
            return queryResult.next() ? new User(queryResult.getString("name"),login,queryResult.getString("password")) : null;
        }
        catch (SQLException ex) {
            System.err.println("Не удалось получить пользователя по логину");
            return null;
        }
    }

    @Override
    public boolean addNewUser(User user) {
        Statement preparedStatement = DBconnection.getStatement();
        try {
            if (!isUserExist(user)) {
                preparedStatement.execute("INSERT INTO User VALUES ('"+user.getLogin()+"','"+user.getName()+"','"+user.getPassword()+"');");
                return true;
            }
            else return false;
        }
        catch (SQLException ex) {
            System.err.println("Не удалось добавить пользователя");
            ex.printStackTrace();
            return false;
        }
    }
    private boolean isUserExist(User user) {
        Statement preparedStatement = DBconnection.getStatement();
        try {
            return preparedStatement.executeQuery("SELECT * FROM User WHERE login = '"+user.getLogin()+"';").next();
        }
        catch (SQLException ex) {
            System.err.println("Не удалось найти пользователя");
            return false;
        }

    }
}
