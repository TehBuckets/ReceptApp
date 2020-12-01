package receptapp.model.dao;

import receptapp.model.Recipe;
import receptapp.model.db.DatabaseConnection;
import receptapp.model.db.DatabaseQueries;
import receptapp.model.db.DatabaseTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAOImplement implements RecipeDAO {
    private DatabaseConnection db = new DatabaseConnection();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createRecipe(Recipe r) throws ClassNotFoundException, SQLException {
        db.connect();
        this.pstm = db.preparedStatement(DatabaseQueries.insertInto(DatabaseTables.RECIPE));

        pstm.setString(1, r.getName());
        pstm.setInt(2, r.getPrepTime());
        pstm.setBoolean(3, r.isVegetarian());
        pstm.setInt(4, r.getCourseID());

        db.close();

        int currentID = db.insertedID();
        r.setID(currentID);
        System.out.println("CREATED: " + r.toString());

        db.close();

        return currentID;
    }

    @Override
    public void deleteRecipe(Recipe r) throws ClassNotFoundException, SQLException {
        db.connect();
        this.pstm = db.preparedStatement(DatabaseQueries.delete(DatabaseTables.RECIPE));

        pstm.setInt(1, r.getID());

        db.update();
        System.out.println("DELETED: " + r.toString());
    }

    @Override
    public List<Recipe> getAllRecipe() throws ClassNotFoundException, SQLException {
        List<Recipe> allRecipe = new ArrayList<>();

        db.connect();

        pstm = db.preparedStatement(DatabaseQueries.selectAll(DatabaseTables.RECIPE));
        rs = db.retrieve();

        while (rs.next()) {
            Recipe r = new Recipe();

            r.setID(rs.getInt(DatabaseTables.RECIPE.getTableColumnsArrayList().get(0)));
            r.setName(rs.getString(DatabaseTables.RECIPE.getTableColumnsArrayList().get(1)));
            r.setPrepTime(rs.getInt(DatabaseTables.RECIPE.getTableColumnsArrayList().get(2)));
            r.setVegetarian(rs.getBoolean(DatabaseTables.RECIPE.getTableColumnsArrayList().get(3)));
            r.setCourseID(rs.getInt(DatabaseTables.RECIPE.getTableColumnsArrayList().get(4)));
            allRecipe.add(r);
        }

        db.close();

        return allRecipe;
    }
}
