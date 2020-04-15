package sql.demo;

import org.h2.store.DataReader;

import java.io.*;
import java.sql.SQLException;

public class IPAddCounterDB{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name1;
    {
        try {
            name1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    FileInputStream inputStream1;
    {
        try {
            inputStream1 = new FileInputStream(name1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    void writeIntoBase (String string) {
    DataBaseHandler dbHandler = new DataBaseHandler();
    try {
        dbHandler.AddTheIP(string);
    } catch (SQLException e) {
        System.out.println("There is SQL Exception");;
    } catch (ClassNotFoundException e) {
        System.out.println("There is ClassNotFoundException ");;
    }
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