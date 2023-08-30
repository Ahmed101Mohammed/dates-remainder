package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public abstract class DB_Model {
    private static Connection connectref;
    private static String path = "jdbc:sqlite:tasks.db";
    
    public static void connect()
    {
        try
        {
            connectref = null;
            connectref = DriverManager.getConnection(path);
            System.out.println("Connected to DB is done.");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static void prepareAppDB()
    {
        String projectTable = "CREATE TABLE IF NOT EXISTS tesks (\n"
                            +  "    date TEXT NOT NULL,\n"
                            +  "    task TEXT NOT NULL\n);";
        
        try
        {
            Statement createTebleStatement = connectref.createStatement();
            createTebleStatement.execute(projectTable);
            System.out.println("Project table is created.");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
