package receptapp.model.dao;

import receptapp.model.Method;

import java.sql.SQLException;
import java.util.List;

public interface MethodDAO {
    int createMethod(Method m) throws ClassNotFoundException, SQLException;
    int updateMethod(Method m) throws ClassNotFoundException, SQLException;
    int deleteMethod(Method m) throws ClassNotFoundException, SQLException;
    List<Method> getAllMethod() throws ClassNotFoundException, SQLException;
}
