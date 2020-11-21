package receptapp.model.db;

import java.sql.*;

public class DatabaseConnection {
    private Connection connection = null;
    private PreparedStatement pstm = null;

    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection(
                DatabaseCredentials.DB_URL.getCredentials(),
                DatabaseCredentials.DB_USER.getCredentials(),
                DatabaseCredentials.DB_PW.getCredentials()
        );

        if (!this.connection.isClosed() || this.connection != null) {
            System.out.println("Sikeres kapcsolódás...");
        }
    }

    public void close() throws SQLException {
        if (this.connection != null && !connection.isClosed()) {
            connection.close();
        }

        connection = null;
        pstm = null;
    }

    public PreparedStatement preparedStatement(String query) throws SQLException {
        this.pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        return this.pstm;
    }

    public int update() throws SQLException {
        return this.pstm.executeUpdate();
    }

    public ResultSet retrieve() throws SQLException {
        return this.pstm.executeQuery();
    }

    public int insertedID() throws SQLException {
        ResultSet rs = pstm.getGeneratedKeys();

        if (rs.next()) {
            int key = rs.getInt(1);
            return key;
        }

        return -1;
    }
}
