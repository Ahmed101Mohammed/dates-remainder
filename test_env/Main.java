package test_env;

public class Main {
    public static void main(String[] args) {
        // TaskWithDate tests:
        test_TaskWithDate_isDateInLegalForm();
        test_TaskWithDate_yearMonthDay();
        test_TaskWithDate_createObject();

        // DB_Model tests:
        DB_Model.connect();
        DB_Model.prepareAppDB();
        TaskWithDate newTask = new TaskWithDate("2023/9/23", "Review Al-Majaraiat book.");
        TaskWithDate newTask1 = new TaskWithDate("2023/10/3", "Review How to study book.");
        TaskWithDate newTask2 = new TaskWithDate("2023/11/10", "Quartir year review started.");
        TaskWithDate newTask3 = new TaskWithDate("2023/12/4", "Review Egypt between Helenia and Ramany book.");

        DB_Model.addNewTask(newTask);
        DB_Model.addNewTask(newTask1);
        DB_Model.addNewTask(newTask2);
        DB_Model.addNewTask(newTask3);
        System.out.println(DB_Model.getTasks("2023/9/1"));
    }

    public static void test_TaskWithDate_isDateInLegalForm()
    {
        TaskWithDate task1 = new TaskWithDate("aa", "");
        boolean result = task1.isDateInLegalForm("55/33/99");
        System.out.println(result);
    }

    public static void test_TaskWithDate_yearMonthDay()
    {
        String[] result = TaskWithDate.yearMonthDay("55/99/99");
        for (String item:result)
        {
            System.out.println(item);
        }
        
    }

    public static void test_TaskWithDate_createObject()
    {
        TaskWithDate task = new TaskWithDate("202/12/30", "Playing footbal");
        System.out.println(task.dataAccessedRight);
    }
}
