package app;

public class Main {
    public static void main(String[] args) {
        String toDay = DayTasksPresentation.convetToDayToString();
        System.out.println( "Hi to day is: " + toDay.substring(5, toDay.length()));
        DB_Model.prepareAppDB();
        DB_Model.removeAllpreviouseTasks();
        System.out.println(DayTasksPresentation.PresentToDayTasks());
        AddingTaskProcess.start();
    }
}
