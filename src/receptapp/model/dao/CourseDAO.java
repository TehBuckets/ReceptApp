package receptapp.model.dao;

import receptapp.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {
    int createCourse(Course c) throws ClassNotFoundException, SQLException;
    int updateCourse(Course c) throws ClassNotFoundException, SQLException;
    int deleteCourse(Course c) throws ClassNotFoundException, SQLException;
    List<Course> getAllCourse() throws ClassNotFoundException, SQLException;
}
