package receptapp.model.dao;

import receptapp.model.Ingredient;
import receptapp.model.db.DatabaseConnection;
import receptapp.model.db.DatabaseQueries;
import receptapp.model.db.DatabaseTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAOImplement implements IngredientDAO {
    private DatabaseConnection db = new DatabaseConnection();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createIngredient(Ingredient i) throws ClassNotFoundException, SQLException {
        db.connect();
        this.pstm = db.preparedStatement(DatabaseQueries.insertInto(DatabaseTables.INGREDIENT));

        pstm.setString(1, i.getName());
        pstm.setString(2, i.getUnit());

        db.update();

        int currentID = db.insertedID();
        i.setID(currentID);
        System.out.println("CREATED: " + i.toString());

        db.close();

        return currentID;
    }

    @Override
    public int updateIngredient(Ingredient i) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public int deleteIngredient(Ingredient i) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public List<Ingredient> getAllIngredient() throws ClassNotFoundException, SQLException {
        List<Ingredient> allIngredient = new ArrayList<>();

        db.connect();

        pstm = db.preparedStatement(DatabaseQueries.selectAll(DatabaseTables.INGREDIENT));
        rs = db.retrieve();

        while (rs.next()) {
            Ingredient i = new Ingredient();

            i.setName(rs.getString(DatabaseTables.INGREDIENT.getTableColumnsArrayList().get(0)));
            i.setUnit(rs.getString(DatabaseTables.INGREDIENT.getTableColumnsArrayList().get(1)));
            allIngredient.add(i);
        }

        db.close();

        return allIngredient;
    }
}
