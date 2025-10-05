/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author romin
 */
public class LaboratorioController implements Initializable {

    @FXML
    private Button misionBoton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

  @FXML
private void cambiarMision(ActionEvent event) {
    try {
        // Cargar segunda pantalla
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/MisionPantalla.fxml"));
        Stage stage = (Stage) misionBoton.getScene().getWindow(); // obtener ventana actual
        stage.setScene(new Scene(root));
        stage.show();

       

    } catch (IOException ex) {
        ex.printStackTrace();
    }
    
    
}
}