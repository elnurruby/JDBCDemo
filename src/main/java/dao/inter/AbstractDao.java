package dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {
    public Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/resume", username = "root", password = "root";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
