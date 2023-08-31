package app;
import java.util.Scanner;
public abstract class AddingTaskProcess {
    public static void start()
    {
        System.out.println("To quite form app pres: (CTRL + Z) OR (CTRL + C) OR print 'quit' word.");
        System.out.println("You can Add new task (In any step print \"no\" to avoid adding the task):");

        while(true)
        {
            String date = getDateFromUser();
            if (!TaskWithDate.isRealFutureDate(date))
            {
                System.out.println("Plase add real date in right formate: yyyy/mm/dd .");
                continue;
            }
            
            String task = getTaskFromUser();

            TaskWithDate newTask = new TaskWithDate(date, task);
            DB_Model.addNewTask(newTask);
        }
    }

    private static void exis(boolean condition)
    {
        if (condition)
        {
            System.exit(0);
        }
    }

    private static String getDateFromUser()
    {
        return getStringDataFromScanner("Add the date of you new task (yyyy/mm/dd): ");
    }

    private static String getTaskFromUser()
    {
        return getStringDataFromScanner("Add your new task: ");
    }

    private static String getStringDataFromScanner(String ask_sentence)
    {
        Scanner myScan = new Scanner(System.in);
        System.out.print(ask_sentence);
        String data = myScan.next();
        myScan.close();
        exis(data.equals("quit"));
        return data;
    }
}
