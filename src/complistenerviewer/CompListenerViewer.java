/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complistenerviewer;

import java.util.logging.Level;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Główna klasa programu.
 *
 * @author Łukasz Wojtas
 */
public class CompListenerViewer extends Application {

    /**
     * Prywatne, statyczne pole klasy Stage.
     */
    private static Stage stage;

    /**
     * Metoda tworząca nową scenę za pomocą pliku FXML.
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));

        Scene scene = new Scene(root);
        CompListenerViewer.stage = stage;
        stage.setTitle("CompListenerViewer");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.setOnCloseRequest((WindowEvent t) -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    /**
     * Metoda main.
     *
     * @param args Argumenty linii poleceń.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Getter pola stage.
     *
     * @return Wartość pola stage.
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * Setter pola stage.
     *
     * @param stage Wartość do zapisania do pola stage.
     */
    public static void setStage(Stage stage) {
        CompListenerViewer.stage = stage;
    }

}
