package receptapp.model;

public class Recipe {
    private int ID;
    private String name;
    private int prepTime;
    private boolean isVegetarian;
    private int courseID;

    public Recipe() {};

    public Recipe(String name, int prepTime, boolean isVegetarian, int courseID) {
        this.name = name;
        this.prepTime = prepTime;
        this.isVegetarian = isVegetarian;
        this.courseID = courseID;
    }

    public Recipe(int ID, String name, int prepTime, boolean isVegetarian, int courseID) {
        this.ID = ID;
        this.name = name;
        this.prepTime = prepTime;
        this.isVegetarian = isVegetarian;
        this.courseID = courseID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Recipe: [ID: " + this.ID +
                "] [Név: " + this.name +
                "] [Elkészítési idő: " + this.prepTime +
                " perc] [Vega: " + this.isVegetarian +
                "] [Fogás: " + this.courseID;
    }
}
