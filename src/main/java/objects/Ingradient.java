package objects;

import java.util.concurrent.ExecutionException;

public class Ingradient {
    private int recipeId;
    private Foods foodItem;
    private String ingredientsValueKG;
    private String ingredientsValueLiter;
    private String ingredientsValueUnit;
    private String ingredientsValueSpoon;
    private String taste;

    public Ingradient(int recipeId, Foods foodItem, String ingredientsValueKG, String ingredientsValueLiter, String ingredientsValueUnit, String ingredientsValueSpoon, String taste) {
        this.recipeId = recipeId;
        this.foodItem = foodItem;
        if (ingredientsValueKG != null) {
            this.ingredientsValueKG = ingredientsValueKG;
        } else {
            this.ingredientsValueKG = null;
        }
        if (ingredientsValueLiter != null) {
            this.ingredientsValueLiter = ingredientsValueLiter;
        } else {
            this.ingredientsValueLiter = null;
        }
        if (ingredientsValueUnit != null) {
            this.ingredientsValueUnit = ingredientsValueUnit;
        } else {
            this.ingredientsValueUnit = null;
        }
        if (ingredientsValueSpoon != null) {
            this.ingredientsValueSpoon = ingredientsValueSpoon;
        } else {
            this.ingredientsValueSpoon = null;
        }
        if (taste != null) {
            this.taste = taste;
        } else {
            this.taste = null;
        }
        if (ingredientsValueKG==null
                &&ingredientsValueLiter==null
                &&ingredientsValueUnit==null
        &&ingredientsValueSpoon==null
        &&taste==null)
        {
          System.out.println("Some Of data is nulll");
        }
    }
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }


    public Foods getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(Foods foodItem) {
        this.foodItem = foodItem;
    }

    public String getIngredientsValueKG() {
        return ingredientsValueKG;
    }

    public void setIngredientsValueKG(String ingredientsValueKG) {
        this.ingredientsValueKG = ingredientsValueKG;
    }

    public String getIngredientsValueLiter() {
        return ingredientsValueLiter;
    }

    public void setIngredientsValueLiter(String ingredientsValueLiter) {
        this.ingredientsValueLiter = ingredientsValueLiter;
    }

    public String getIngredientsValueUnit() {
        return ingredientsValueUnit;
    }

    public void setIngredientsValueUnit(String ingredientsValueUnit) {
        this.ingredientsValueUnit = ingredientsValueUnit;
    }

    public String getIngredientsValueSpoon() {
        return ingredientsValueSpoon;
    }

    public void setIngredientsValueSpoon(String ingredientsValueSpoon) {
        this.ingredientsValueSpoon = ingredientsValueSpoon;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }


}
