package app;
import java.time.LocalDate;

public class DayTasksPresentation {
    
    public static String convetToDayToString()
    {
        LocalDate toDay = LocalDate.now();
        String toDayString = Integer.toString(toDay.getYear()) + "/" + Integer.toString(toDay.getMonthValue()) + "/" + Integer.toString(toDay.getDayOfMonth());
        return toDayString;
    }
}
