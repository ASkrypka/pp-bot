import Helper.Helper;
import Helper.Helper.*;
import objects.Ingradient;
import objects.Recipe;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.util.Calendar;

import static Helper.Helper.BREAKFAST_RESIPE_LIST;
import static Helper.Helper.MENU_FOR_WEEK;

public class PPBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        String command=update.getMessage().getText();
        SendMessage massage= new SendMessage();
        if (command.equals("/MenuForCurrentWeek"))
        {
            try {
                SheetsAndJava.mains(Helper.getWeekNum());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
              massage.setText(MENU_FOR_WEEK.toString());
        }
        if (command.equals("/MenuForCurrentDate"))
        {
            try {
                SheetsAndJava.mains(Helper.getWeekNum());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            if (MENU_FOR_WEEK.getMonday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getMonday().toString());
            if (MENU_FOR_WEEK.getTuesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getTuesday().toString());
            if (MENU_FOR_WEEK.getWednesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getWednesday().toString());
            if (MENU_FOR_WEEK.getThursday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getThursday().toString());
            if (MENU_FOR_WEEK.getFriday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getFriday().toString());
            if (MENU_FOR_WEEK.getSaturday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getSaturday().toString());
            if (MENU_FOR_WEEK.getSunday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().name()))
                massage.setText(MENU_FOR_WEEK.getSunday().toString());
        }
        if (command.equals("/MenuForNextDate"))
        {
            try {
                SheetsAndJava.mains(Helper.getWeekNum());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            if (MENU_FOR_WEEK.getMonday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getMonday().toString());
            if (MENU_FOR_WEEK.getTuesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getTuesday().toString());
            if (MENU_FOR_WEEK.getWednesday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getWednesday().toString());
            if (MENU_FOR_WEEK.getThursday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getThursday().toString());
            if (MENU_FOR_WEEK.getFriday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getFriday().toString());
            if (MENU_FOR_WEEK.getSaturday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getSaturday().toString());
            if (MENU_FOR_WEEK.getSunday().getTypeOfDay().toString().equals(LocalDate.now().getDayOfWeek().plus(1).name()))
                massage.setText(MENU_FOR_WEEK.getSunday().toString());
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
