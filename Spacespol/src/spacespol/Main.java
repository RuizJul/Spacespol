/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spacespol;

/**
 *
 * @author Julian
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el FXML de la pantalla de bienvenida
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Bienvenida.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 600, 400); // tamaño de tu Pane

            primaryStage.setTitle("Artemis Project");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

