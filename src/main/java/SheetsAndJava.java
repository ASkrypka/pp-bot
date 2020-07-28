import Helper.Helper.*;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import objects.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static Helper.Helper.*;
import static Helper.Helper.DayOfweek.*;

public class SheetsAndJava {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "Google Test PP Recipt";
    private static String SPREADSHEET_ID = "1JIU-08nPy6MSnlmhrM_5GsiRk_VJYAyUqNkB9BfNbj8";

    private static Credential authorize() throws IOException, GeneralSecurityException {
        InputStream in = SheetsAndJava.class.getResourceAsStream("credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();

        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");
        return credential;
    }

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void mains(int noOFWeek) throws IOException, GeneralSecurityException {
        sheetsService = getSheetsService();

        createFoodList();//1
        createIngradientsList();//2
        createRecipeList();//3
        createMenuList(noOFWeek);//4



    }

    public static void createRecipeList() throws IOException {
        BREAKFAST_RESIPE_LIST.clear();
        LUNCH_RESIPE_LIST.clear();
        DINNER_RESIPE_LIST.clear();
        String recipeData = "recipeList!A2:E100000";
        ValueRange recipeList = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, recipeData).execute();
        List<List<Object>> recipeValues = recipeList.getValues();

        int recipeId = 0;
        String recipeName = "";
        String recipeIMGURL = "";
        String recipeTEXT = "";
        String dishFor = "";


        for (List row : recipeValues) {
            recipeId = Integer.parseInt(row.get(0).toString());
            recipeName = row.get(1).toString();
            recipeIMGURL = row.get(2).toString();
            recipeTEXT = row.get(3).toString();
            dishFor = row.get(4).toString();

            if (dishFor.equals(DishFor.BREAKFASK.toString())) {
                List<Ingradient> ingra = new ArrayList<>();
                for (Ingradient ingrad : INGRADIENTS_LIST) {
                    if (ingrad.getRecipeId() == recipeId) {
                        ingra.add(ingrad);
                    }
                }
                BREAKFAST_RESIPE_LIST.add(
                        new Recipe(recipeId,
                                recipeName,
                                recipeIMGURL,
                                recipeTEXT, ingra));
            }
            if (dishFor.equals(DishFor.LUNCH.toString())) {
                List<Ingradient> ingra = new ArrayList<>();
                for (Ingradient ingrad : INGRADIENTS_LIST) {
                    if (ingrad.getRecipeId() == recipeId) {
                        ingra.add(ingrad);
                    }
                }
                Recipe lunch = new Recipe(recipeId,
                        recipeName,
                        recipeIMGURL,
                        recipeTEXT, ingra);
                LUNCH_RESIPE_LIST.add(lunch);
            }
            if (dishFor.equals(DishFor.DINNER.toString())) {
                List<Ingradient> ingra = new ArrayList<>();
                for (Ingradient ingrad : INGRADIENTS_LIST) {
                    if (ingrad.getRecipeId() == recipeId) {
                        ingra.add(ingrad);
                    }
                }
                DINNER_RESIPE_LIST.add(
                        new Recipe(recipeId,
                                recipeName,
                                recipeIMGURL,
                                recipeTEXT, ingra));
            }
        }
    }

    public static void createIngradientsList() throws IOException {
        INGRADIENTS_LIST.clear();
        String ingradientData = "ingredients!A2:G100000";
        ValueRange ingradientList = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, ingradientData).execute();

        List<List<Object>> ingradientValues = ingradientList.getValues();
        int recipeId = 0;
        int foodId = 0;
        String ingredientsValueKG = "";
        String ingredientsValueLiter = "";
        String ingredientsValueUnit = "";
        String ingredientsValueSpoon = "";
        String taste = "";
        Foods foodForIngradits = new Foods();
        if (ingradientValues.isEmpty() || ingradientValues == null) {
            System.out.println("No Data Found for Food list ");
        } else {
            for (List row : ingradientValues) {
                recipeId = Integer.parseInt(row.get(0).toString());
                foodId = Integer.parseInt(row.get(1).toString());
                for (Foods foodItem : FOOD_LIST) {
                    if (foodItem.getFoodId() == foodId) {
                        foodForIngradits = foodItem;
                    }
                }
                ingredientsValueKG = row.get(2).toString();
                ingredientsValueLiter = row.get(3).toString();
                ingredientsValueUnit = row.get(4).toString();
                ingredientsValueSpoon = row.get(5).toString();
                taste = row.get(6).toString();
                INGRADIENTS_LIST.add(new Ingradient(recipeId, foodForIngradits, ingredientsValueKG, ingredientsValueLiter, ingredientsValueUnit, ingredientsValueSpoon, taste));
            }
        }
    }

    public static void createMenuList(int noOFWeek) throws IOException {
        String menuData = "menu!A2:F100000";
        ValueRange menuList = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, menuData).execute();

        List<List<Object>> menuValues = menuList.getValues();

        if (menuValues == null || menuValues.isEmpty()) {
            System.out.println("Not Data Found");
        } else {
            for (List row : menuValues) {
                String date =row.get(0).toString();
                //Date date =(Date)row.get(0);
                int numWeek = Integer.parseInt(row.get(1).toString());
                String typeOfDate = row.get(2).toString();
                int breakfastId = Integer.parseInt(row.get(3).toString());
                int lunchId = Integer.parseInt(row.get(4).toString());
                int dinnerId = Integer.parseInt(row.get(5).toString());
                MENU_FOR_DAY_OF_WEEK.add(setMenyForDay(date, breakfastId, lunchId, dinnerId, typeOfDate, numWeek));
            }

        }
        MenuForWeek menuForWeek = new MenuForWeek();
        for (MenuForDayOfWeek dayItem : MENU_FOR_DAY_OF_WEEK) {

            if (dayItem.getNumWeek() == noOFWeek) {
                MENU_FOR_WEEK.setNumberOfweek(noOFWeek);
                switch (dayItem.getTypeOfDay()) {
                    case MONDAY:
                        MENU_FOR_WEEK.setMonday(dayItem);
                        break;
                    case TUESDAY:
                        MENU_FOR_WEEK.setTuesday(dayItem);
                        break;
                    case WEDNESDAY:
                        MENU_FOR_WEEK.setWednesday(dayItem);
                        break;
                    case THURSDAY:
                        MENU_FOR_WEEK.setThursday(dayItem);
                        break;
                    case FRIDAY:
                        MENU_FOR_WEEK.setFriday(dayItem);
                        break;
                    case SATURDAY:
                        MENU_FOR_WEEK.setSaturday(dayItem);
                        break;
                    case SUNDAY:
                        MENU_FOR_WEEK.setSunday(dayItem);
                        break;
                }
            }
        }
    }

    public static MenuForDayOfWeek setMenyForDay(String date, int breakfastId, int lunchId, int dinnerId, String typeOfDay, int numWeek) {
        MenuForDayOfWeek menuForDayOfWeek = new MenuForDayOfWeek();

        menuForDayOfWeek.setDate(date);
        menuForDayOfWeek.setNumWeek(numWeek);
        menuForDayOfWeek.setTypeOfDay(DayOfweek.valueOf(typeOfDay));
        for (Recipe rowBreakfast : BREAKFAST_RESIPE_LIST) {
            if (breakfastId == rowBreakfast.getReceptID()) {
                menuForDayOfWeek.setBreackfast(rowBreakfast);
            }
        }
        for (Recipe rowLunch : LUNCH_RESIPE_LIST) {
            if (lunchId == rowLunch.getReceptID()) {
                menuForDayOfWeek.setLunch(rowLunch);
            }
        }
        for (Recipe rowDinner : DINNER_RESIPE_LIST) {
            if (dinnerId == rowDinner.getReceptID()) {
                menuForDayOfWeek.setDinner(rowDinner);
            }
        }
        return menuForDayOfWeek;

    }

    public static void createFoodList() throws IOException {
        String rangeFoodListOfData = "foodlist!A2:C100000";
        ValueRange responseFoodListData = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, rangeFoodListOfData).execute();

        List<List<Object>> valueFoodListDate = responseFoodListData.getValues();
        if (valueFoodListDate.isEmpty() || valueFoodListDate == null) {
            System.out.println("No Data Found for Food list ");
        } else {
            for (List row : valueFoodListDate) {
                FOOD_LIST.add(new Foods(Integer.parseInt(row.get(0).toString()), row.get(1).toString(), row.get(2).toString()));
            }
        }

    }
}