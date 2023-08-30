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
    }

    public static void test_TaskWithDate_isDateInLegalForm()
    {
        TaskWithDate task1 = new TaskWithDate("aa", "");
        boolean result = task1.isDateInLegalForm("55/33/99");
        System.out.println(result);
    }

    public static void test_TaskWithDate_yearMonthDay()
    {
        TaskWithDate task = new TaskWithDate("","");
        String[] result = task.yearMonthDay("55/99/99");
        for (String item:result)
        {
            System.out.println(item);
        }
        
    }

    public static void test_TaskWithDate_createObject()
    {
        TaskWithDate task = new TaskWithDate("202/12/30", "Playing footbal");
        System.out.println(task.data_accessed_right);
    }
}
