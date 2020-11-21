package receptapp.model;

public class Method {
    private int ID;
    private int recipeID;
    private int stepCount;
    private String stepDescription;

    public Method() {};

    public Method(int recipeID, int stepCount, String stepDescription) {
        this.recipeID = recipeID;
        this.stepCount = stepCount;
        this.stepDescription = stepDescription;
    }

    public Method(int ID, int recipeID, int stepCount, String stepDescription) {
        this.ID = ID;
        this.recipeID = recipeID;
        this.stepCount = stepCount;
        this.stepDescription = stepDescription;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public int getStepCount() {
        return stepCount;
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    @Override
    public String toString() {
        return "Method: [ID: " + this.ID +
                "] [Recept ID: " + this.recipeID +
                "] [Sorszam: " + this.stepCount +
                "] [Leiras: " + this.stepDescription;
    }
}
