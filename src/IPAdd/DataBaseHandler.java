package IPAdd;

import java.sql.*;

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


    public void AddTheIP (String string) throws SQLException, ClassNotFoundException {
        String insert = "INSERT IGNORE INTO " + Const.IP_TABLE + "(" + Const.IP_ADDRESSES + ")" +
                " VALUES(?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, string);
        prSt.executeUpdate();

    }
    public int getRowNumber(){

        int numberRow = 0;

        try{
            String query = "select count(*) from ip.ip";
            PreparedStatement st = getDbConnection().prepareStatement(query);
            ResultSet result = st.executeQuery();
            while(result.next()){
                numberRow = result.getInt("count(*)");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return numberRow;
    }
}
