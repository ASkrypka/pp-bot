import Helper.Helper;
import Helper.Helper.*;
import objects.Ingradient;
import objects.MenuForDayOfWeek;
import objects.Recipe;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.Calendar;

import static Helper.Helper.*;

public class PPBot extends TelegramLongPollingBot {
    public String COMMAND = "";
    public SendMessage massage = new SendMessage();

    public void onUpdateReceived(Update update) {
        COMMAND = update.getMessage().getText();
        if (COMMAND.equals("Меню на текущую неделю")) {
            try {
                SheetsAndJava.mains(Helper.getWeekNum());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            massage.setText(MENU_FOR_WEEK.toString());
        }
        if (COMMAND.equals("Меню на сегодня")) {
            try {
                SheetsAndJava.mains(Helper.getWeekNum());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            if (MENU_FOR_WEEK.getMonday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getMonday().getDate() + "\n" + MENU_FOR_WEEK.getMonday().toString());
            if (MENU_FOR_WEEK.getTuesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getTuesday().getDate() + "\n" + MENU_FOR_WEEK.getTuesday().toString());
            if (MENU_FOR_WEEK.getWednesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getWednesday().getDate() + "\n" + MENU_FOR_WEEK.getWednesday().toString());
            if (MENU_FOR_WEEK.getThursday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getThursday().getDate() + "\n" + MENU_FOR_WEEK.getThursday().toString());
            if (MENU_FOR_WEEK.getFriday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getFriday().getDate() + "\n" + MENU_FOR_WEEK.getFriday().toString());
            if (MENU_FOR_WEEK.getSaturday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getSaturday().getDate() + "\n" + MENU_FOR_WEEK.getSaturday().toString());
            if (MENU_FOR_WEEK.getSunday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getSunday().getDate() + "\n" + MENU_FOR_WEEK.getSunday().toString());
        }
        if (COMMAND.equals("Меню на завтра")) {
            try {
                SheetsAndJava.mains(Helper.getWeekNum());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            if (MENU_FOR_WEEK.getMonday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getMonday().getDate() + "\n" + MENU_FOR_WEEK.getMonday().toString());
            if (MENU_FOR_WEEK.getTuesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getTuesday().getDate() + "\n" + MENU_FOR_WEEK.getTuesday().toString());
            if (MENU_FOR_WEEK.getWednesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getWednesday().getDate() + "\n" + MENU_FOR_WEEK.getWednesday().toString());
            if (MENU_FOR_WEEK.getThursday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getThursday().getDate() + "\n" + MENU_FOR_WEEK.getThursday().toString());
            if (MENU_FOR_WEEK.getFriday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getFriday().getDate() + "\n" + MENU_FOR_WEEK.getFriday().toString());
            if (MENU_FOR_WEEK.getSaturday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getSaturday().getDate() + "\n" + MENU_FOR_WEEK.getSaturday().toString());
            if (MENU_FOR_WEEK.getSunday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getSunday().getDate() + "\n" + MENU_FOR_WEEK.getSunday().toString());
        }


        for (Recipe itemRecipe : BREAKFAST_RESIPE_LIST) {
            if (COMMAND.equals("/"+itemRecipe.latinName)) {
                massage.setText(itemRecipe.toString());
            }
        }
        for (Recipe itemRecipe : LUNCH_RESIPE_LIST) {
            if (COMMAND.equals("/"+itemRecipe.latinName)) {
                massage.setText(itemRecipe.toString());
            }
        }
        for ( Recipe itemRecipe : DINNER_RESIPE_LIST) {
            if (COMMAND.equals("/"+itemRecipe.getLatinName())) {
                massage.setText(itemRecipe.toString());
            }
        }


        massage.setChatId(update.getMessage().getChatId());
        try {
            execute(massage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "bot_name";
    }

    public String getBotToken() {
        return "1237763806:AAGt4hw6Kn4xZ7bR_HuaiBXUiamI3g4VTs4";
    }
}
