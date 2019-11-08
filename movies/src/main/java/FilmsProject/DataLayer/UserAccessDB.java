package FilmsProject.DataLayer;

import FilmsProject.Interfaces.UserAccessService;
import FilmsProject.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@Component
public class UserAccessDB implements UserAccessService {

    @Autowired
    private MoviesDB DBconnection;

    public boolean createTable() throws SQLException {
        return DBconnection.getPreparedStatement("CREATE TABLE IF NOT EXISTS User(\n" +
                "                login VARCHAR(20) PRIMARY KEY, \n" +
                "                name VARCHAR(20) NOT NULL, \n" +
                "                password VARCHAR(20) NOT NULL)").execute();
    }

    @Override
    public User getUserByLogin(String login) {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM User WHERE login = ?;");
        try {
            preparedStatement.setString(1,login);
            ResultSet queryResult = preparedStatement.executeQuery();
            return queryResult.next() ? new User(queryResult.getString("name"),login,queryResult.getString("password")) : null;
        }
        catch (SQLException ex) {
            System.err.println("Не удалось получить пользователя по логину");
            return null;
        }
    }

    @Override
    public boolean addNewUser(User user) {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("INSERT INTO User VALUES (?,?,?);");
        try {
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getPassword());
            if (!isUserExist(user)) {
                preparedStatement.execute();
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
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM User WHERE login = ?;");
        try {
            preparedStatement.setString(1,user.getLogin());
            return preparedStatement.executeQuery().next();
        }
        catch (SQLException ex) {
            System.err.println("Не удалось найти пользователя");
            return false;
        }

    }
}
