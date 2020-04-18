package IPAdd;
import java.io.*;
import java.sql.SQLException;

public class readFileAndWriteIntoBase {
    public readFileAndWriteIntoBase() throws IOException, SQLException {
        String path = new File("").getAbsolutePath();
        System.out.println("какой абсолют путь" + path);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Andrew\\Downloads\\ip_addresses\\test.txt"));
        DataBaseHandler dbHandler = new DataBaseHandler();
        String line;
        while ((line = reader.readLine()) != null) {
            writeIntoBase(dbHandler, line);
            dbHandler.dbConnection.close();
        }
        System.out.println("В БД строк: " + dbHandler.getRowNumber());
        reader.close();
        dbHandler.dbConnection.close();
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
        readFileAndWriteIntoBase ip = new readFileAndWriteIntoBase();
        long end = System.currentTimeMillis();
        System.out.println("Load time: "+(end-start));

    }
}