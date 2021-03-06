package receptapp.model.dao;

import receptapp.model.Recipe;

import java.sql.SQLException;
import java.util.List;

public interface RecipeDAO {
    int createRecipe(Recipe r) throws ClassNotFoundException, SQLException;
    void deleteRecipe(Recipe r) throws ClassNotFoundException, SQLException;
    List<Recipe> getAllRecipe() throws ClassNotFoundException, SQLException;
}
