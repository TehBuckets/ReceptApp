package receptapp.model.dao;

import receptapp.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
    int createCourse(Course c) throws ClassNotFoundException, SQLException;
    void deleteCourse(Course c) throws ClassNotFoundException, SQLException;
    List<Course> getAllCourse() throws ClassNotFoundException, SQLException;
}
