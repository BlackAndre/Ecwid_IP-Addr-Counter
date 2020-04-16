package sql.demo;

import org.w3c.dom.ls.LSOutput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()  {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
           // System.out.println("Соединение с СУБД выполнено.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

    public void closeConnection () throws SQLException {
        dbConnection.close();
    }
    public void AddTheIP (String string) throws SQLException, ClassNotFoundException {
        String insert = "INSERT IGNORE INTO " + Const.IP_TABLE + "(" + Const.IP_ADDRESSES + ")" + " VALUES(?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, string);
        prSt.executeUpdate();
    }

}
