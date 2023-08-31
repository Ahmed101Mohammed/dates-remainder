package app;

public class Main {
    public static void main(String[] args) {
        System.out.println( "Hi to day is: " + DayTasksPresentation.convetToDayToString().substring(5, 9));
        DB_Model.prepareAppDB();
        DB_Model.removeAllpreviouseTasks();
        System.out.println(DayTasksPresentation.PresentToDayTasks());
        AddingTaskProcess.start();
    }
}
