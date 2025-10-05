/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import java.io.IOException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author romin
 */
public class SeleccionModuController implements Initializable {

    @FXML
    private Button retrocederBoton;
    
    @FXML
    private Button siguienteBoton;
    
    @FXML
    private Circle circulo1;
    
    @FXML
    private Circle circulo2;
    
    @FXML
    private Circle circulo3;
    
    @FXML
    private Circle circulo4;
    
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
    
    @FXML
    public void retroceder(){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/eleccionDificultad.fxml"));
        Stage stage = (Stage) retrocederBoton.getScene().getWindow(); // obtener ventana actual 
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }
    
    @FXML
    public void siguiente(){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/EstacionEspacial.fxml"));
        Stage stage = (Stage) retrocederBoton.getScene().getWindow(); // obtener ventana actual 
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }
        
    
    @FXML
    private void toggleCircle(MouseEvent event) {
        Circle circle = (Circle) event.getSource();

        if (circle.getFill().equals(Color.WHITE)) {
            circle.setFill(Color.LIMEGREEN); // cambia a verde
        } else {
            circle.setFill(Color.WHITE); // vuelve a blanco
        }
    }
    }
    
