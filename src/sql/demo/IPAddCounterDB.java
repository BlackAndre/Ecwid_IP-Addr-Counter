package sql.demo;
import java.io.*;
import java.sql.SQLException;

public class IPAddCounterDB{
    public IPAddCounterDB() throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Andrew\\Downloads\\ip_addresses\\test.txt"));
        DataBaseHandler dbHandler = new DataBaseHandler();
        String line;
        while ((line = reader.readLine()) != null) {
            writeIntoBase(dbHandler, line);
            dbHandler.dbConnection.close();
        }
            reader.close();
        dbHandler.dbConnection.close();
        // отключение от БД
        System.out.println("Отключение от СУБД выполнено.");
    }

void writeIntoBase (DataBaseHandler dbHandler,String string) {
    try {
        dbHandler.AddTheIP(string);
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) throws IOException, SQLException {
        long start = System.currentTimeMillis();
        IPAddCounterDB ip = new IPAddCounterDB();
        long end = System.currentTimeMillis();
        System.out.println("Load time: "+(end-start));
    }








        // Блок объявления констант
/*
        public static final String DB_URL = "jdbc:h2:C:\\Users\\Andrew\\IdeaProjects\\SQLDEMO\\db\\IPAddCounter";
        public static final String DB_Driver = "org.h2.Driver";


        public static void main(String[] args) {
            try {
                Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
                Connection connection = DriverManager.getConnection(DB_URL);//соединениесБД
                System.out.println("Соединение с СУБД выполнено.");
                connection.close();       // отключение от БД
                System.out.println("Отключение от СУБД выполнено.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // обработка ошибки  Class.forName
                System.out.println("JDBC драйвер для СУБД не найден!");
            } catch (SQLException e) {
                e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
                System.out.println("Ошибка SQL !");
            }
        }*/
    }