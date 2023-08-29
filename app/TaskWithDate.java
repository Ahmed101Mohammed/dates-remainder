package app;
import java.util.Arrays;
import java.util.HashSet;
import java.time.LocalDate;

public class TaskWithDate {
    private String date;
    private String task;
    public boolean data_accessed_right;
    static HashSet<String> validString = new HashSet<String>(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "/"));
    
    public TaskWithDate(String date, String task)
    {
        if(isRealFutureDate(date))
        {
            this.date = date;
            this.task = task;
            this.data_accessed_right = true;
        }
        else
        {
            this.data_accessed_right = false;
        }
        
    }

    public boolean isRealFutureDate(String date)
    {
        if(isDateInLegalForm(date))
        {
            String[] userDate = yearMonthDay(date);
            if(eachStringHasChar(userDate) && arrMonthsAndDaysInRange(userDate))
            {
                LocalDate toDay = LocalDate.now();
                int year = Integer.parseInt(userDate[0]);
                int month = Integer.parseInt(userDate[1]);
                int day = Integer.parseInt(userDate[2]);
                int[] toDayints = {toDay.getYear(), toDay.getMonthValue(), toDay.getDayOfMonth()};
                int[] userDateints = {year, month, day};
                if(isD1GreaterthanD2(userDateints, toDayints))
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean isDateInLegalForm(String date)
    {
        int count_backSlach = 0;
        for (String ch:date.split(""))
        {
            boolean isExist = validString.contains(ch);
            if(! isExist)
            {
                return false;
            }

            if(isExist && ch.equals("/"))
            {
                count_backSlach += 1;
            }
        }

        if(count_backSlach == 2)
        {
            return true;
        }
        return false;
    }

    private String[] yearMonthDay(String dateInValidForm)
    {
        int count_backSlach = 0;
        String[] year_month_day = {"","",""};
        for(String chr:dateInValidForm.split(""))
        {
            if(chr.equals("/"))
            {
                count_backSlach += 1;
            }
            else if(count_backSlach == 0)
            {
                year_month_day[0] = year_month_day[0] + chr;
            }
            else if(count_backSlach == 1)
            {
                year_month_day[1] = year_month_day[1] + chr;
            }
            else
            {
                year_month_day[2] = year_month_day[2] + chr;
            }
        }

        if(eachStringHasChar(year_month_day))
        {
            return year_month_day;
        }
        {
            String[] empty = {};
            return empty;
        }
    }

    private boolean eachStringHasChar(String[] list)
        {
            for(String item:list)
            {
                if(item.length() == 0)
                {
                    return false;
                }
            }
            return true;
        }

    private boolean arrMonthsAndDaysInRange(String[] YearMonthDay)
    {
        int year = Integer.parseInt(YearMonthDay[0]);
        int month = Integer.parseInt(YearMonthDay[1]);
        int day = Integer.parseInt(YearMonthDay[2]);

        int monthRange = 12;
        int[] daysRange = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year))
        {
            daysRange[1] = 29; 
        }

        if (year > 0 && (month > 0 && month <= monthRange) && (day > 0 && day <= daysRange[month-1]))
        {
            return true;
        }
        return false;
    }

    private boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean isD1GreaterthanD2(int[] date1, int[] date2)
    {
        int year1 = date1[0];
        int year2 = date2[0];
        int month1 = date1[1];
        int month2 = date2[1];
        int day1 = date1[2];
        int day2 = date2[2];

        if (year1 > year2)
        {
            return true;
        }
        else if (year1 == year2 && month1 > month2)
        {
           return true;
        }
        else if (year1 == year2 && month1 == month2 && day1 > day2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
