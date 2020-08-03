package objects;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public int receptID;
    public String name;

    public String getLatinName() {
        return latinName;
    }

    public String latinName;
    public String prigotovlenieReceptText;
    public List<Ingradient> ingradient = new ArrayList<>();
    public String prigotovlenieReceptIMG;


    public Recipe(int receptID, String name, String prigotovlenieReceptIMG, String prigotovlenieReceptText, Ingradient ingradientu) {
        this.receptID = receptID;
        this.name = name;
        this.latinName=Helper.Helper.getLatinName(name);
        this.prigotovlenieReceptText = prigotovlenieReceptText;
        ingradient.add(ingradientu);
        this.prigotovlenieReceptIMG = prigotovlenieReceptIMG;
    }

    public Recipe(int receptID, String name, String prigotovlenieReceptIMG, String prigotovlenieReceptText, List<Ingradient> ingradientu) {
        this.receptID = receptID;
        this.name = name;
        this.latinName=Helper.Helper.getLatinName(name);
        if (prigotovlenieReceptText != null) {
            this.prigotovlenieReceptText = prigotovlenieReceptText;
        } else {
            this.prigotovlenieReceptText = null;
        }
        if (prigotovlenieReceptIMG != null) {
            this.prigotovlenieReceptIMG = prigotovlenieReceptIMG;
        } else {
            this.prigotovlenieReceptIMG = null;
        }
        ingradient = ingradientu;
    }

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrigotovlenieReceptText() {
        return prigotovlenieReceptText;
    }

    public void setPrigotovlenieReceptText(String prigotovlenieReceptText) {
        prigotovlenieReceptText = prigotovlenieReceptText;
    }

    public List<Ingradient> getIngradientu() {
        return ingradient;
    }

    public void setIngradient(List<Ingradient> Ingradient) {
        this.ingradient = Ingradient;
    }

    public String getPrigotovlenieReceptIMG() {
        return prigotovlenieReceptIMG;
    }

    public void setPrigotovlenieReceptIMG(String prigotovlenieReceptIMG) {
        this.prigotovlenieReceptIMG = prigotovlenieReceptIMG;
    }


    @Override
    public String toString() {
        String returnData = "";

        String ing = ingradient.toString();
        if (prigotovlenieReceptText == null && prigotovlenieReceptIMG != null) {
            returnData = name + ":\n" + "----Инградиенты :\n" + ingradient.toString() + "\n\n\t----Рецепт :\n" + prigotovlenieReceptIMG;
        }
        if (prigotovlenieReceptText != null && prigotovlenieReceptIMG == null) {
            returnData = name + ":\n" + "----Инградиенты :\n" + ingradient.toString() + "\n\n\t----Рецепт :\n" + prigotovlenieReceptText;
        }
        if (prigotovlenieReceptText != null && prigotovlenieReceptIMG != null) {
            returnData = name + ":\n" + "----Инградиенты :\n" + ingradient.toString() + "\n\n\t----Рецепт :\n" + prigotovlenieReceptText + "\n\t---- :\n" + prigotovlenieReceptIMG;
        }
        if (prigotovlenieReceptText == null && prigotovlenieReceptIMG == null) {
            returnData = name + ":\n" + "----Инградиенты :\n" + ingradient.toString() + "\n\n\t----Рецепт :\n" + "Рецепт не задан.";
        }

        return returnData;
    }
}
