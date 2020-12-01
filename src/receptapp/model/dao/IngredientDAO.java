package receptapp.model.dao;

import receptapp.model.Ingredient;

import java.sql.SQLException;
import java.util.List;

public interface IngredientDAO {
    int createIngredient(Ingredient i) throws ClassNotFoundException, SQLException;
    void deleteIngredient(Ingredient i) throws ClassNotFoundException, SQLException;
    List<Ingredient> getAllIngredient() throws ClassNotFoundException, SQLException;
}
