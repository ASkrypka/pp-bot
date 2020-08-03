package objects;

public class Ingradient {
    private int recipeId;
    private Foods foodItem;
    private String ingredientsValueKG;
    private String ingredientsValueLiter;
    private String ingredientsItems;
    private String ingredientsValueSpoon;
    private String taste;

    public Ingradient(int recipeId, Foods foodItem, String ingredientsValueKG, String ingredientsValueLiter, String ingredientsItems, String ingredientsValueSpoon, String taste) {
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
        if (ingredientsItems != null) {
            this.ingredientsItems = ingredientsItems;
        } else {
            this.ingredientsItems = null;
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
                &&ingredientsItems==null
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

    public String getIngredientsItems() {
        return ingredientsItems;
    }

    public void setIngredientsItems(String ingredientsItems) {
        this.ingredientsItems = ingredientsItems;
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


    @Override
    public String toString() {
        String returninfo="";
        if (ingredientsValueKG!=null)
        {
            returninfo=returninfo+"\n\t"+foodItem.toString()+ingredientsValueKG+" г.";
        }
         if (ingredientsValueLiter!=null)
        {
            returninfo=returninfo+"\n\t"+foodItem.toString()+ingredientsValueLiter+" мл.";
        }
          if (ingredientsItems !=null)
        {
            returninfo=returninfo+"\n\t"+foodItem.toString()+ ingredientsItems +" штук.";
        }
        if (ingredientsValueSpoon !=null)
        {
            returninfo=returninfo+"\n\t"+foodItem.toString()+ ingredientsValueSpoon +" чайных ложек.";
        }

         if (taste!=null)
        {
            returninfo=returninfo+"\n\t"+foodItem.toString()+" по вкусу.";
        }

        return returninfo;
    }
}
