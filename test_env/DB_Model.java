package test_env;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                            +  "    task TEXT NOT NULL,\n"
                            +   "   date_value INTEGER NOT NULL);";
        
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
            String insertNewTask = "INSERT INTO tasks(date,task,date_value) VALUES(?,?,?)";
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
            insertStatement.setInt(3, convertDateToNumber(data.getDate()));
            insertStatement.executeUpdate();
            System.out.println("Your task is saved.");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Sorry Your task not saved check the problem above.");
        }
    }

    public static ArrayList<TaskWithDate> getTasks(String date)
    {
        String query = "Select task From tasks Where date LIKE '"+ date +"';";
        return getTasksFromDB(query, date);
    }

    private static ArrayList<TaskWithDate> getTasksFromDB(String query, String date)
    {
        try
        {
            Statement getStatement = connectref.createStatement();
            ResultSet tasks = getStatement.executeQuery(query);
            return convertResultSetToTaskWithDate(tasks, date);
        }
        catch (SQLException e)
        {
            System.out.println(e);
            ArrayList<TaskWithDate> tasksList = new ArrayList<TaskWithDate>();
            return tasksList; //empty if no results
        }
    }

    private static ArrayList<TaskWithDate> convertResultSetToTaskWithDate(ResultSet tasks, String date)
    {
        ArrayList<TaskWithDate> tasksList = new ArrayList<TaskWithDate>();
        try
        {
            while(tasks.next())
            {
                TaskWithDate task = new TaskWithDate(date, tasks.getString("task"));
                tasksList.add(task);
            }
            System.out.println("Data is ready.");
            return tasksList;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return tasksList;
        }
    }

    private static int convertDateToNumber(String date)
    {
        String[] yearMonthDay = TaskWithDate.yearMonthDay(date);
        modifyYearMonthDayFormate(yearMonthDay);
        return Integer.parseInt(yearMonthDay[0]+yearMonthDay[1]+yearMonthDay[2]);
    }

    private static void modifyYearMonthDayFormate(String[] yearMonthDay)
    {
        for (int i = 1; i < yearMonthDay.length; i++)
        {
            yearMonthDay[i] = addZeroStringForOneLenghtString(yearMonthDay[i]);
        }
    }

    private static String addZeroStringForOneLenghtString(String string)
    {
        if (string.length() == 1)
        {
            return "0" + string;
        }
        return string;
    }
}
