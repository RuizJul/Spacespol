/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author romin
 */
public class SeleccionModuController implements Initializable {

    
    
    @FXML
    private Button logisBoton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void iniciarVentanaEmergente() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vistas/infoLogis.fxml"));
            Scene escena = new Scene(root);

            Stage stage = (Stage) logisBoton.getScene().getWindow();
            stage.setScene(escena);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    
