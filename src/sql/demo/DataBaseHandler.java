package sql.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void closeConnection () throws SQLException {
        dbConnection.close();
    }
    public void AddTheIP (String string) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.IP_TABLE + "(" + Const.IP_ADDRESSES + ")" + "VALUES(?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, string);
        prSt.executeUpdate();
    }

}
