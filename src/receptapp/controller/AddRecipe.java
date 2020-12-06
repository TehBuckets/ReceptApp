package receptapp.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddRecipe {

    @FXML
    private Button btnSave;
    @FXML
    private Button btnEmpty;
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private TextField tf7;
    @FXML
    private TextField tf8;
    @FXML
    private TextField tf9;
    @FXML
    private TextField tf10;
    @FXML
    private TextField tf11;
    @FXML
    private MenuItem miSave;
    @FXML
    private MenuItem miExit;
    @FXML
    private MenuItem miAboutus;

// Szövegmezők törlése főmenü gombbal
    @FXML
    private void fieldEmpty() throws IOException {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        tf8.setText("");
        tf9.setText("");
        tf10.setText("");
        tf11.setText("");
    }

    // Programból kilépés menüsor gombbal
    @FXML
    private void exitProgram() throws IOException {
        Platform.exit();
        System.exit(0);
    }

    //Szövegmezők törlése menüsor gombbal
    @FXML
    private void mifieldEmpty() throws IOException {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        tf8.setText("");
        tf9.setText("");
        tf10.setText("");
        tf11.setText("");
    }

    //Rólunk menüsor gomb, amit nem tudtam befejezni, jelenleg nem fut le a program ha ez nincs bent.
    //add_recipe.fxml ben ott található a rólunk mellett az onAction event ami végett nem megy.
    //Bent hagytam ezt a kódot ha kellene, de nyugottan lehet törölni.
    @FXML
    private void aboutUs() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/about_us.fxml"));
       // miAboutus.getScene().setRoot(root);
    }

    private void connection() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/add_recipe.fxml"));

    }
}

