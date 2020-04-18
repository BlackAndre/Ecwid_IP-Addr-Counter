package IPAdd;
import java.io.*;
import java.sql.SQLException;

public class IPAddrersses {
    public IPAddrersses() throws IOException, SQLException {
        String path = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(path + "/test.txt"));
        DataBaseHandler dbHandler = new DataBaseHandler();
        String line;
        while ((line = reader.readLine()) != null) {
            writeIntoBase(dbHandler, line);
            dbHandler.dbConnection.close();
        }
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
        IPAddrersses ip = new IPAddrersses();
        long end = System.currentTimeMillis();
        System.out.println("Load time: "+(end-start));

    }
}