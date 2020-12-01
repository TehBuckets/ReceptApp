package receptapp.model.db;

public class DatabaseQueries {
    public static String selectAll(DatabaseTables table) {
        return "SELECT * FROM " + table.getTableName();
    }

    public static String insertInto(DatabaseTables table) {
        return "INSERT INTO " + table.getTableName() + " (" + table.getTableColumsString() + ") VALUES " + table.getParams();
    }

    public static String delete(DatabaseTables table) {
        String id = table.getTableName() + "_id";
        return "DELETE FROM " + table.getTableName() + " WHERE " + id + " = ?";
    }
}
