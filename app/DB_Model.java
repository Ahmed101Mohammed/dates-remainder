package app;
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
    
    private static boolean connect()
    {
        try
        {
            connectref = null;
            connectref = DriverManager.getConnection(path);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean prepareAppDB()
    {
        connect();
        String projectTable = "CREATE TABLE IF NOT EXISTS tasks (\n"
                            +  "    date TEXT NOT NULL,\n"
                            +  "    task TEXT NOT NULL,\n"
                            +   "   date_value INTEGER NOT NULL);";
        
        try
        {
            Statement createTebleStatement = connectref.createStatement();
            createTebleStatement.execute(projectTable);
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
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

    private static boolean addNewTaskToDB(String quary, TaskWithDate data)
    {
        try
        {
            PreparedStatement insertStatement = connectref.prepareStatement(quary);
            insertStatement.setString(1, data.getDate());
            insertStatement.setString(2, data.getTask());
            insertStatement.setInt(3, convertDateToNumber(data.getDate()));
            insertStatement.executeUpdate();
            System.out.println("Your new task is saved!");
            return true;
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Sorry Your task not saved check the problem above.");
            return false;
        }
    }

    public static ArrayList<TaskWithDate> getTasks(String date)
    {
        String query = "Select date, task From tasks Where date LIKE '"+ date +"';";
        return getTasksFromDB(query, date);
    }

    private static ArrayList<TaskWithDate> getTasksFromDB(String query, String date)
    {
        try
        {
            Statement getStatement = connectref.createStatement();
            ResultSet tasks = getStatement.executeQuery(query);
            return convertResultSetToTaskWithDate(tasks);
        }
        catch (SQLException e)
        {
            System.out.println(e);
            ArrayList<TaskWithDate> tasksList = new ArrayList<TaskWithDate>();
            return tasksList; //empty if no results
        }
    }

    private static ArrayList<TaskWithDate> convertResultSetToTaskWithDate(ResultSet tasks)
    {
        ArrayList<TaskWithDate> tasksList = new ArrayList<TaskWithDate>();
        try
        {
            while(tasks.next())
            {
                TaskWithDate task = new TaskWithDate(tasks.getString("date"), tasks.getString("task"));
                tasksList.add(task);
            }
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
        String dateInStringStandard = convertDateToStandardFormate(date);
        return Integer.parseInt(dateInStringStandard);
    }

    public static String convertDateToStandardFormate(String date)
    {
        String[] yearMonthDay = TaskWithDate.yearMonthDay(date);
        modifyYearMonthDayFormate(yearMonthDay);
        return yearMonthDay[0]+yearMonthDay[1]+yearMonthDay[2];
    }

    public static String convertDateToStandardFormateWithSlachs(String date)
    {
        String[] yearMonthDay = TaskWithDate.yearMonthDay(date);
        modifyYearMonthDayFormate(yearMonthDay);
        return yearMonthDay[0]+"/"+yearMonthDay[1]+"/"+yearMonthDay[2];
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


    public static void removeAllpreviouseTasks()
    {
        String toDayString = DayTasksPresentation.convetToDayToString();
        int toDayValue = convertDateToNumber(toDayString);

        String deleteQuery = "DELETE FROM tasks WHERE date_value < " + toDayValue + " ;";
        removeAllpreviouseTasksFromDB(deleteQuery);
    }

    private static boolean removeAllpreviouseTasksFromDB(String quary)
    {
        try
        {
            Statement deleteStatment = connectref.createStatement();
            deleteStatment.execute(quary);
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            System.out.println("DB didn't refreshed plase check the problem above.");
            return false;
        }
    }

    public static ArrayList<TaskWithDate> getAllTasksFromDB()
    {
        String getAllStatement = "SELECT date, task FROM tasks;";
        try
        {
            Statement getAll = connectref.createStatement();
            ResultSet allTasks = getAll.executeQuery(getAllStatement);
            return convertResultSetToTaskWithDate(allTasks);

        }
        catch(SQLException e)
        {
            System.out.println(e);
            ArrayList<TaskWithDate> empty = new ArrayList<TaskWithDate>();
            return empty;
        }
    }
}
