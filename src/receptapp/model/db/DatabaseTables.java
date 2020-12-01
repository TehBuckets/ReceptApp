package receptapp.model.db;

import java.util.ArrayList;
import java.util.Arrays;

public enum DatabaseTables {
    INGREDIENT(
            "hozzavalo",
            new ArrayList<String>(Arrays.asList("hozzavalo_id", "hozzavalo_nev", "hozzavalo_egyseg")),
            "(?, ?)"
    ),
    COURSE(
            "fogas",
            new ArrayList<String>(Arrays.asList("fogas_id", "fogas_nev")),
            "(?)"
    ),
    RECIPE(
            "recept",
            new ArrayList<String>(Arrays.asList("recept_id", "recept_nev", "recept_elkeszitesi_ido", "recept_vegetarianus", "fogas_id")),
            "(?, ?, ?, ?)"
    ),
    METHOD(
            "elkeszites",
            new ArrayList<String>(Arrays.asList("elkeszites_id", "recept_id", "elkeszites_sorszam", "elkeszites_leiras")),
            "(?, ?, ?)"
    );

    private String tableName;
    private ArrayList<String> tableColumns;
    private String params;

    DatabaseTables(String tableName, ArrayList<String> tableColumns, String params) {
        this.tableName = tableName;
        this.tableColumns = tableColumns;
        this.params = params;
    }

    public String getTableName() {
        return this.tableName;
    }

    public ArrayList<String> getTableColumnsArrayList() {
        return this.tableColumns;
    }

    public String getTableColumsString() {
        String columnsString = String.join(", ", this.tableColumns);

        return columnsString;
    }

    public String getParams() {
        return this.params;
    }
}
