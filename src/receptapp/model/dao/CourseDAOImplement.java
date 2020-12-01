package receptapp.model.dao;

import receptapp.model.Course;
import receptapp.model.db.DatabaseConnection;
import receptapp.model.db.DatabaseQueries;
import receptapp.model.db.DatabaseTables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImplement implements CourseDAO {
    private DatabaseConnection db = new DatabaseConnection();
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    public int createCourse(Course c) throws ClassNotFoundException, SQLException {
        db.connect();
        this.pstm = db.preparedStatement(DatabaseQueries.insertInto(DatabaseTables.COURSE));

        pstm.setString(1, c.getName());

        db.update();

        int currentID = db.insertedID();
        c.setID(currentID);
        System.out.println("CREATED: " + c.toString());

        db.close();

        return currentID;
    }

    @Override
    public void deleteCourse(Course c) throws ClassNotFoundException, SQLException {
        db.connect();
        this.pstm = db.preparedStatement(DatabaseQueries.delete(DatabaseTables.COURSE));

        pstm.setInt(1, c.getID());

        db.update();
        System.out.println("DELETED: " + c.toString());

        db.close();
    }

    @Override
    public List<Course> getAllCourse() throws ClassNotFoundException, SQLException {
        List<Course> allCourse = new ArrayList<>();

        db.connect();

        pstm = db.preparedStatement(DatabaseQueries.selectAll(DatabaseTables.COURSE));
        rs = db.retrieve();

        while (rs.next()) {
            Course c = new Course();

            c.setID(rs.getInt(DatabaseTables.COURSE.getTableColumnsArrayList().get(0)));
            c.setName(rs.getString(DatabaseTables.COURSE.getTableColumnsArrayList().get(1)));
            allCourse.add(c);
        }

        db.close();

        return allCourse;
    }
}
