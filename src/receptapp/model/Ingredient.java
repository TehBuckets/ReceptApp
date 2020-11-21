package receptapp.model;

public class Ingredient {
    private int ID;
    private String name;
    private String unit;

    public Ingredient() {};

    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public Ingredient(int ID, String name, String unit) {
        this.ID = ID;
        this.name = name;
        this.unit = unit;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient: [ID: " + this.ID + "] " + this.name + " (" + this.unit + ")";
    }
}
