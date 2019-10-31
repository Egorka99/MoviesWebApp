package FilmsProject.Database;

import FilmsProject.Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable extends BaseTable {

    MoviesDB DBconnection = MoviesDB.getInstance();

    public UserTable() {
        super("User");
    }

    public boolean createTable() throws SQLException {
        return execute("CREATE TABLE IF NOT EXISTS User(\n" +
                "                login VARCHAR(20) PRIMARY KEY, \n" +
                "                name VARCHAR(20) NOT NULL, \n" +
                "                password VARCHAR(20) NOT NULL)");
    }

    public User signIn(String login, String password) throws Exception {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM User WHERE login = ? AND password = ?;");
        preparedStatement.setString(1,login);
        preparedStatement.setString(2,password);
        ResultSet queryResult = preparedStatement.executeQuery();
        if (queryResult.next()) {
            return new User(queryResult.getString("name"),login,password);
        }
        throw new Exception("Неверные данные для авторизации");
    }

    public boolean signUp(String userName, String userLogin, String userPassword) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBconnection.getPreparedStatement("SELECT * FROM User WHERE login = ?;");
        preparedStatement.setString(1,userLogin);
        ResultSet queryResult = preparedStatement.executeQuery();
        if (queryResult.next()) {
            return false;
        }
        else {
            execute("INSERT INTO User VALUES ('"+userLogin+"','"+userName+"','"+userPassword+"');");
            return true;
        }
    }
}
