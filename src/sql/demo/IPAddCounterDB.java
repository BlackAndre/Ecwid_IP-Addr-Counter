package sql.demo;

import org.h2.store.DataReader;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IPAddCounterDB{
    public IPAddCounterDB() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Andrew\\Desktop\\IT\\1.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            writeIntoBase(line);
        }
        reader.close();
    }



void writeIntoBase (String string) {
    DataBaseHandler dbHandler = new DataBaseHandler();
    try {
        dbHandler.AddTheIP(string);
        dbHandler.dbConnection.close();       // отключение от БД
        System.out.println("Отключение от СУБД выполнено.");
    } catch (SQLException e) {
        e.printStackTrace();;
    } catch (ClassNotFoundException e) {
        System.out.println("There is ClassNotFoundException ");;
    }
}

    public static void main(String[] args) throws IOException {
        IPAddCounterDB ip = new IPAddCounterDB();

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