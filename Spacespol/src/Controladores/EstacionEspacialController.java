
package Controladores;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class EstacionEspacialController implements Initializable {
    
    @FXML
    private Button misionButton;
    
    @FXML
    private Button laboratorioBoton;
    
    @FXML
    private Button retrocederBoton;
    @FXML
    private ImageView panelMisiones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

    @FXML
    private void iniciarMision() {
        System.out.println("¡Misión iniciada!");
        panelMisiones.setVisible(true);
//        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.3), panelMisiones);
//        fadeIn.setFromValue(0);
//        fadeIn.setToValue(1);
//        fadeIn.play();
    }
    @FXML
    public void cambiarALab(){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/Laboratorio.fxml"));
        Stage stage = (Stage) retrocederBoton.getScene().getWindow(); // obtener ventana actual
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }
    
    

    @FXML
    public void retroceder(){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/SeleccionModu.fxml"));
        Stage stage = (Stage) retrocederBoton.getScene().getWindow(); // obtener ventana actual
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    }
}
    



