package app;
import java.util.ArrayList;
import java.util.Scanner;
public abstract class AddingTaskProcess {
    public static void start()
    {
        System.out.println("\nTo quite form app press: (CTRL + Z) OR (CTRL + C) OR print 'quit' word.");
        System.out.println("You can Add new task (In any step print \"no\" to avoid adding the task \nor \"all\" to see all dates that you record before.):");

        while(true)
        {
            String date = getDateFromUser();
            if(date.equals("no")){continue;}
            if(date.equals("all")){myAllTasks(); continue;}
            if (!TaskWithDate.isRealFutureDate(date))
            {
                System.out.println("Plase add real future date in right formate: yyyy/mm/dd .");
                continue;
            }
            
            String task = getTaskFromUser();
            if(task.equals("no")){continue;}
            if(task.equals("all")){myAllTasks(); continue;}

            TaskWithDate newTask = new TaskWithDate(date, task);
            DB_Model.addNewTask(newTask);
        }
    }

    private static void exit(boolean condition)
    {
        if (condition)
        {
            System.exit(0);
        }
    }

    private static String getDateFromUser()
    {
        return getStringDataFromScanner("Add the date of your new task (yyyy/mm/dd): ");
    }

    private static String getTaskFromUser()
    {
        return getStringDataFromScanner("Add your new task: ");
    }

    private static String getStringDataFromScanner(String ask_sentence)
    {
        Scanner myScan = new Scanner(System.in);
        System.out.print(ask_sentence);
        String data = myScan.nextLine();
        exit(data.equals("quit"));
        return data;
    }

    private static void myAllTasks()
    {
        ArrayList<TaskWithDate> allTasks = DB_Model.getAllTasksFromDB();
        if(allTasks.isEmpty())
        {
            System.out.println("You didn't recored any task before.");
        }
        
        String allTasksString = "There is the remaind tasks:\n";
        for (int i = 0; i < allTasks.size(); i++)
        {
            allTasksString += "[" + DB_Model.convertDateToStandardFormateWithSlachs(allTasks.get(i).getDate()) + "]: " + allTasks.get(i).getTask() + "\n";
        }
        System.out.println(allTasksString);
    }
}
