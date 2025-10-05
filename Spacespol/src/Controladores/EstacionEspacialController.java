
package Controladores;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class EstacionEspacialController implements Initializable {
    
    @FXML
    private Button misionButton;
    
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
    }


