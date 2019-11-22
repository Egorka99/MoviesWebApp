package FilmsProject.DataLayer.jdbc;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class MoviesDB {
    //Notebook path
    //public static final String DB_URL = "jdbc:h2:/home/egor/Документы/GitHub/MoviesWebApp-master/movies/db/filmDB";
    //PC path
    public static final String DB_URL = "jdbc:h2:\\D:\\java\\MoviesWebApp\\movies\\db\\filmDB";
    public static final String DB_Driver = "org.h2.Driver";

    private Connection connection;

    private MoviesDB() throws ClassNotFoundException, SQLException{
        Class.forName(DB_Driver);
        connection = DriverManager.getConnection(DB_URL);
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        }
        catch (SQLException ex) {
            System.err.println("Не удалось получить объект Statement");
            return null;
        }
    }

}
