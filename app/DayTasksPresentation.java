package app;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class DayTasksPresentation {

    public static String PresentToDayTasks()
    {
        ArrayList<TaskWithDate> toDayTasks = DB_Model.getTasks(convetToDayToString());
        if(toDayTasks.isEmpty())
        {
            return "There is no tasks to day...";
        }
        
        String toDayTasksString = "These is your tasks to day:\n";
        for (int i = 0; i < toDayTasks.size(); i++)
        {
            toDayTasksString += "- " + toDayTasks.get(i).getTask() + "\n";
        }
        return toDayTasksString;
    }

    public static String convetToDayToString()
    {
        LocalDate toDay = LocalDate.now();
        String toDayString = Integer.toString(toDay.getYear()) + "/" + Integer.toString(toDay.getMonthValue()) + "/" + Integer.toString(toDay.getDayOfMonth());
        return toDayString;
    }
}
