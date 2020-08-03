package Helper;

import com.ibm.icu.text.Transliterator;
import objects.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class Helper {
    private static String LATIN_TO_CYRILLIC = "Latin-Russian/BGN";
    private static String CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
    public static final List<MenuForDayOfWeek> MENU_FOR_DAY_OF_WEEK = new ArrayList<>();
    public static final MenuForWeek MENU_FOR_WEEK = new MenuForWeek();
    public static final List<Recipe> BREAKFAST_RESIPE_LIST = new ArrayList<>();
    public static final List<Recipe> LUNCH_RESIPE_LIST = new ArrayList<>();
    public static final List<Recipe> DINNER_RESIPE_LIST = new ArrayList<>();
    public static final List<Ingradient> INGRADIENTS_LIST = new ArrayList<>();
    public static final List<Foods> FOOD_LIST = new ArrayList<Foods>();

    public enum DayOfweek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public enum DishFor {
        BREAKFAST,
        LUNCH,
        DINNER
    }

    public static String getFood_list() {
        String foodListReturn = "";

        for (Foods foditem : FOOD_LIST) {
            foodListReturn = foodListReturn + "\n" + foditem.toString() + "\n";

        }

        return foodListReturn;

    }


    public static String getLatinName(String nameKyrillic) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        return toLatinTrans.transliterate(nameKyrillic).replace(" ","_").replace("-","_");
    }
    public static String getKyrillicName(String nameLatin) {
        Transliterator toLatinTrans = Transliterator.getInstance(LATIN_TO_CYRILLIC);
        return toLatinTrans.transliterate(nameLatin);
    }

    public static Long getNumber() {
        LocalDate date = LocalDate.now();
        DayOfWeek day = date.getDayOfWeek();
        return new Long(day.getValue());
    }

    public static int getWeekNum() {
        LocalDate date = LocalDate.now();

        WeekFields wf = WeekFields.of(Locale.getDefault());                    // Use week fields appropriate to your locale. People in different places define a week and week-number differently, such as starting on a Monday or a Sunday, and so on.
        TemporalField weekNum = wf.weekOfWeekBasedYear();                       // Represent the idea of this locale’s definition of week number as a `TemporalField`.
        int week = Integer.parseInt(String.format("%02d", date.get(weekNum)));   // Using that locale’s definition of week number, determine the week-number for this particular `LocalDate` value.

        return week;
    }


}
