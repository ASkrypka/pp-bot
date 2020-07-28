package objects;

import objects.MenuForDayOfWeek;

public class MenuForWeek {
    private int numberOfweek;
    private MenuForDayOfWeek monday;
    private MenuForDayOfWeek tuesday;
    private MenuForDayOfWeek wednesday;
    private MenuForDayOfWeek thursday;
    private MenuForDayOfWeek friday;
    private MenuForDayOfWeek saturday;
    private MenuForDayOfWeek sunday;

    public MenuForWeek() {
    }

    public int getNumberOfweek() {
        return numberOfweek;
    }

    public void setNumberOfweek(int numOfweek) {
        numberOfweek = numOfweek;
    }

    public MenuForDayOfWeek getMonday() {
        return monday;
    }

    public void setMonday(MenuForDayOfWeek moday) {
        monday = moday;
    }

    public MenuForDayOfWeek getTuesday() {
        return tuesday;
    }

    public void setTuesday(MenuForDayOfWeek tuesday) {
        this.tuesday = tuesday;
    }

    public MenuForDayOfWeek getWednesday() {
        return wednesday;
    }

    public void setWednesday(MenuForDayOfWeek wednesday) {
        this.wednesday = wednesday;
    }

    public MenuForDayOfWeek getThursday() {
        return thursday;
    }

    public void setThursday(MenuForDayOfWeek thursday) {
        this.thursday = thursday;
    }

    public MenuForDayOfWeek getFriday() {
        return friday;
    }

    public void setFriday(MenuForDayOfWeek friday) {
        this.friday = friday;
    }

    public MenuForDayOfWeek getSaturday() {
        return saturday;
    }

    public void setSaturday(MenuForDayOfWeek saturday) {
        this.saturday = saturday;
    }

    public MenuForDayOfWeek getSunday() {
        return sunday;
    }

    public void setSunday(MenuForDayOfWeek sunday) {
        this.sunday = sunday;
    }

    public String getMenuforWeekByString() {
        return "Понедельник: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName() +
                "Вторник: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName() +
                "Среда: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName() +
                "Четверг: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName() +
                "Пятница: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName() +
                "Суббота: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName() +
                "Воскресенье: \n -----завтрак: " + monday.getBreackfast().getName() + "\n -----обед" + monday.getLunch().getName() + "\n -----завтрак" + monday.getBreackfast().getName();

    }

    @Override
    public String toString() {
        return "Мнею на неделю [" + monday.getDate() + "-" + sunday.getDate() + "]\n" +
                "П: " + monday.toString() + "\n" +
                "В: " + tuesday.toString() + "\n" +
                "С: " + wednesday.toString() + "\n" +
                "Ч: " + thursday.toString() + "\n" +
                "П: " + friday.toString() + "\n" +
                "С: " + saturday.toString() + "\n" +
                "В: " + sunday.toString() + "\n";
    }
}
