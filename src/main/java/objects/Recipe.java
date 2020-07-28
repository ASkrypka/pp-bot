package objects;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    public int receptID;
    public String Name;
    public String PrigotovlenieReceptText;
    public List<Ingradient> Ingradient =new ArrayList<>();
    public String PrigotovlenieReceptIMG;

    public Recipe(int receptID, String name, String prigotovlenieReceptIMG, String prigotovlenieReceptText, Ingradient ingradientu ) {
        this.receptID = receptID;
        Name = name;
        PrigotovlenieReceptText = prigotovlenieReceptText;

        Ingradient.add(ingradientu);
        PrigotovlenieReceptIMG = prigotovlenieReceptIMG;
    }
    public Recipe(int receptID, String name, String prigotovlenieReceptIMG, String prigotovlenieReceptText, List<Ingradient> ingradientu ) {
        this.receptID = receptID;
        Name = name;
        PrigotovlenieReceptText = prigotovlenieReceptText;
        Ingradient=ingradientu;
        PrigotovlenieReceptIMG = prigotovlenieReceptIMG;
    }

    public Recipe() {}

    public int getReceptID() {
        return receptID;
    }

    public void setReceptID(int receptID) {
        this.receptID = receptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrigotovlenieReceptText() {
        return PrigotovlenieReceptText;
    }

    public void setPrigotovlenieReceptText(String prigotovlenieReceptText) {
        PrigotovlenieReceptText = prigotovlenieReceptText;
    }

    public List<Ingradient> getIngradientu() {
        return Ingradient;
    }

    public void setIngradient(List<Ingradient> Ingradient) {
        this.Ingradient = Ingradient;
    }
    public String getPrigotovlenieReceptIMG() {
        return PrigotovlenieReceptIMG;
    }

    public void setPrigotovlenieReceptIMG(String prigotovlenieReceptIMG) {
        PrigotovlenieReceptIMG = prigotovlenieReceptIMG;
    }



}
