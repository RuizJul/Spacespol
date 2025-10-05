/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class eleccionDificultadController {

    @FXML
    private Button botonFacil;

    @FXML
    private Button botonIntermedio;

    @FXML
    private Button botonDificil;

    @FXML
    public void initialize() {
        // Se asigna la misma acción a los tres botones
        botonFacil.setOnAction(event ->
                cargarSiguienteVista());
        botonIntermedio.setOnAction(event -> cargarSiguienteVista());
        botonDificil.setOnAction(event -> cargarSiguienteVista());
    }

    private void cargarSiguienteVista() {
        System.out.println("hola");
        try {
            // Cargar el FXML de la siguiente vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/SeleccionModu.fxml"));
            Parent root = loader.load();

            // Obtener la ventana actual 
            Stage stage = (Stage) botonFacil.getScene().getWindow();

            // Cambiar la escena
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

