package receptapp;

import receptapp.model.*;
import receptapp.model.dao.*;

public class Main {
    public static void main(String[] args) {
        //Ingredient ingredient = new Ingredient("paradicsom", "db");
        IngredientDAO ingredientDAO = new IngredientDAOImplement();

        try {
            //ingredientDAO.createIngredient(ingredient);
            System.out.println(ingredientDAO.getAllIngredient());
        } catch (Exception e) {
            System.out.println("Hiba: " + e);
        }
    }
}
