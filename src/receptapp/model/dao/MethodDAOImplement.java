package receptapp.model.dao;

import receptapp.model.Method;
import receptapp.model.db.DatabaseConnection;
import receptapp.model.db.DatabaseQueries;
import receptapp.model.db.DatabaseTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MethodDAOImplement implements MethodDAO {
    private DatabaseConnection db = new DatabaseConnection();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createMethod(Method m) throws ClassNotFoundException, SQLException {
        db.connect();
        this.pstm = db.preparedStatement(DatabaseQueries.insertInto(DatabaseTables.METHOD));

        pstm.setInt(1, m.getRecipeID());
        pstm.setInt(2, m.getStepCount());
        pstm.setString(3, m.getStepDescription());

        db.close();

        int currentID = db.insertedID();
        m.setID(currentID);
        System.out.println("CREATED: " + m.toString());

        db.close();

        return currentID;
    }

    @Override
    public int updateMethod(Method m) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public int deleteMethod(Method m) throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public List<Method> getAllMethod() throws ClassNotFoundException, SQLException {
        List<Method> allMethod = new ArrayList<>();

        db.connect();

        pstm = db.preparedStatement(DatabaseQueries.selectAll(DatabaseTables.METHOD));
        rs = db.retrieve();

        while (rs.next()) {
            Method m = new Method();

            m.setID(rs.getInt(DatabaseTables.METHOD.getTableColumnsArrayList().get(0)));
            m.setStepCount(rs.getInt(DatabaseTables.METHOD.getTableColumnsArrayList().get(1)));
            m.setStepDescription(rs.getString(DatabaseTables.METHOD.getTableColumnsArrayList().get(2)));
        }

        db.connect();

        return allMethod;
    }
}
