package receptapp.model.db;

public enum DatabaseCredentials {
    DB_URL("jdbc:mysql://localhost:3306/receptkonyv_db"),
    DB_USER("root"),
    DB_PW("");

    private String credentials;

    DatabaseCredentials(String data) {
        this.credentials = data;
    }

    public String getCredentials() {
        return this.credentials;
    }
}
