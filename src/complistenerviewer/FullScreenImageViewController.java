/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complistenerviewer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Łukasz Wojtas
 */
public class FullScreenImageViewController implements Initializable {

    private static Image image;

    @FXML
    private VBox vBox;

    @FXML
    private ImageView imageView;

    /**
     * Metoda obsługująca kliknięcie w dowolny element okna. Zamyka okno.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void anythingClick(MouseEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    /**
     * Metoda inicjalizująca. Ustawia właściwości skalowania ImageView oraz
     * przypisuje Image do ImageView.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (image.getWidth() >= image.getHeight()) {
            imageView.fitWidthProperty().bind(vBox.widthProperty());
        } else {
            imageView.fitHeightProperty().bind(vBox.heightProperty());
        }
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setImage(image);
    }

    /**
     * Setter pola image.
     *
     * @param image Wartość do zapisania do pola image.
     */
    public static void setImage(Image image) {
        FullScreenImageViewController.image = image;
    }

}
