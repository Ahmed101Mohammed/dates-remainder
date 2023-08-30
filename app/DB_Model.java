package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
        String projectTable = "CREATE TABLE IF NOT EXISTS tasks (\n"
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

    public static void addNewTask(TaskWithDate task)
    {
        if(task.getDataAccessedRightState())
        {
            String insertNewTask = "INSERT INTO tasks(date,task) VALUES(?,?)";
            addNewTaskToDB(insertNewTask, task);
        }
        else
        {
            System.out.println("Your accessed right state for your input is false.");
        }
    }

    private static void addNewTaskToDB(String quary, TaskWithDate data)
    {
        try
        {
            PreparedStatement insertStatement = connectref.prepareStatement(quary);
            insertStatement.setString(1, data.getDate());
            insertStatement.setString(2, data.getTask());
            insertStatement.executeUpdate();
            System.out.println("Your task is saved.");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Sorry Your task not saved check the problem above.");
        }
    }
}
