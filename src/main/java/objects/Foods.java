package objects;

import Helper.Helper;

public class Foods {
    private int foodId;
    private String foodName;
    private String foodType;

    public Foods(int foodId, String foodName, String foodType) {
        this.foodId = foodId;
        if (foodType != null) {
            this.foodName = foodName;
            this.foodType = foodType;
        } else {
            this.foodName = foodName;
            this.foodType = null;
        }
    }
    public Foods(Foods foodItem) {
        this.foodId = foodItem.getFoodId();
        if (foodItem.getFoodType() != null) {
            this.foodName = foodItem.getFoodName();
            this.foodType = foodItem.getFoodType();
        } else {
            this.foodName = foodItem.getFoodName();
            this.foodType = null;
        }
    }

    public Foods() {
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public Foods getFoodItem(int requestId) {

        for (Foods foodItem : Helper.FOOD_LIST) {
            if (foodItem.getFoodId() == requestId) {
                return foodItem;
            }

        }
        return new Foods();
    }

    @Override
    public String toString() {
        String returnData="";
        if (foodType.equals("null"))
            returnData =foodName+": ";
        else
        returnData= foodName + "("+foodType+"): ";
        return returnData;
    }


}
