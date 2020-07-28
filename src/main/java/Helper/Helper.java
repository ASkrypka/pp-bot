package Helper;

import objects.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class Helper {
    public static final List<MenuForDayOfWeek> MENU_FOR_DAY_OF_WEEK= new ArrayList<>();
    public static final MenuForWeek MENU_FOR_WEEK= new MenuForWeek();
    public static final List<Recipe> BREAKFAST_RESIPE_LIST= new ArrayList<>();
    public static final List<Recipe> LUNCH_RESIPE_LIST= new ArrayList<>();
    public static final List<Recipe> DINNER_RESIPE_LIST= new ArrayList<>();
    public static final List<Ingradient> INGRADIENTS_LIST= new ArrayList<>();
    public static final  List<Foods> FOOD_LIST= new ArrayList<Foods>();

    public enum DayOfweek{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    public enum DishFor{
        BREAKFASK,
        LUNCH,
        DINNER
    }

    public static String getFood_list ()
    {
        String foodListReturn="";

        for (Foods foditem:FOOD_LIST)
        {
            foodListReturn=foodListReturn+"\n"+foditem.toString()+"\n";

        }

        return foodListReturn;

    }


        public static Long getNumber() {
            LocalDate date = LocalDate.now();
            DayOfWeek day = date.getDayOfWeek();
            return new Long(day.getValue());
        }
    public static int getWeekNum() {
         LocalDate date = LocalDate.now();

        WeekFields wf = WeekFields.of(Locale.getDefault()) ;                    // Use week fields appropriate to your locale. People in different places define a week and week-number differently, such as starting on a Monday or a Sunday, and so on.
        TemporalField weekNum = wf.weekOfWeekBasedYear();                       // Represent the idea of this locale’s definition of week number as a `TemporalField`.
        int week = Integer.parseInt(String.format("%02d",date.get(weekNum)));   // Using that locale’s definition of week number, determine the week-number for this particular `LocalDate` value.

        return week;
    }



}
