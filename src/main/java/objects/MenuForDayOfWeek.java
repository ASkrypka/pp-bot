package objects;

import objects.Recipe;
import Helper.Helper.*;

public class MenuForDayOfWeek {
    private String date;

    public int getNumWeek() {
        return numWeek;
    }

    public void setNumWeek(int numWeek) {
        this.numWeek = numWeek;
    }

    private int numWeek;
    private DayOfweek typeOfDay;

    public DayOfweek getTypeOfDay() {
        return typeOfDay;
    }

    public void setTypeOfDay(DayOfweek typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    private Recipe Breackfast;
    private  Recipe Lunch;
    private  Recipe Dinner;

    public  String getDate() {
        return date;
    }

    public  void setDate(String date) {
        this.date = date;
    }
    public  Recipe getBreackfast() {
        return Breackfast;
    }

    public  void setBreackfast(Recipe Recipe) {
        Breackfast = Recipe;
    }

    public  Recipe getLunch() {
        return Lunch;
    }

    public  void setLunch(Recipe Recipe) {
        Lunch = Recipe;
    }

    public  Recipe getDinner() {
        return Dinner;
    }

    public  void setDinner(Recipe Recipe) {
         Dinner = Recipe;
    }

    @Override
    public String toString() {
        return  "Завтрак: "+Breackfast.getName() +" /"+Breackfast.getLatinName() +"\n"+
                "Обед: " + Lunch.getName()+" /"+Lunch.getLatinName() +"\n"+
                "Ужин: " + Dinner.getName()+" /"+Dinner.getLatinName() +"\n";
    }
}
