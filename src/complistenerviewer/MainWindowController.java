/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complistenerviewer;

import util.KeyboardClickTable;
import util.WorkstationAdditionalDataTable;
import util.MouseScrollTable;
import util.WindowTable;
import util.WorkstationTable;
import util.MouseClickTable;
import entity.Window;
import entity.Workstation;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import service.WorkstationService;

/**
 * FXML Controller class
 *
 * @author Łukasz Wojtas
 */
public class MainWindowController implements Initializable {

    @FXML
    private TableView workstationTableView;

    @FXML
    private TableView wokstationAdditionalDataTableView;

    @FXML
    private TableView keyboardClickTableView;

    @FXML
    private TableView mouseClickTableView;

    @FXML
    private TableView mouseScrollTableView;

    @FXML
    private TreeTableView<Window> windowTreeTableView;

    @FXML
    private ImageView imageView;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private void workstationTableViewClick(MouseEvent event) {
        if (workstationTableView.getSelectionModel().getSelectedItem() != null) {
            Workstation selectedWorkstation = (Workstation) workstationTableView.getSelectionModel().getSelectedItem();

            WorkstationAdditionalDataTable.getTable(wokstationAdditionalDataTableView, selectedWorkstation.getWorkstationAdditionalData());
            WindowTable.getTable(windowTreeTableView, selectedWorkstation.getWindowCollection());
        }
    }

    @FXML
    private void windowTreeTableViewClick(MouseEvent event) {
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(selectedWindow.getPrintScreen());
            Image image = new Image(byteArrayInputStream);
            imageView.setImage(image);

            KeyboardClickTable.getTable(keyboardClickTableView, selectedWindow.getKeyboardClickCollection());
            MouseClickTable.getTable(mouseClickTableView, selectedWindow.getMouseClickCollection());
            MouseScrollTable.getTable(mouseScrollTableView, selectedWindow.getMouseScrollCollection());
        }
    }

    @FXML
    private void saveDataAsMenuItemClick(ActionEvent event) {
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();
            String initialFileName = new String();
            initialFileName += "CompListener " + selectedWindow.getWindowTitle() + " " + selectedWindow.getStartDate().getDate() + "-" + selectedWindow.getStartDate().getMonth() + "-" + (selectedWindow.getStartDate().getYear() + 1900) + " " + selectedWindow.getStartDate().getHours() + "-" + selectedWindow.getStartDate().getMinutes() + "-" + selectedWindow.getStartDate().getSeconds();

            FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle("Save data as:");
            fileChooser.setInitialFileName(initialFileName);
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("TXT", "*.txt");
            fileChooser.getExtensionFilters().add(fileExtensions);

            File file = fileChooser.showSaveDialog(CompListenerViewer.getStage());
            System.out.println(fileChooser.getSelectedExtensionFilter().getDescription() + " " + fileChooser.getSelectedExtensionFilter().toString());
            if (file != null) {
                try {
                    List<String> lines = new ArrayList<>();
                    lines.add(selectedWindow.getWindowTitle() + " " + selectedWindow.getStartDate());
                    lines.add("");
                    lines.add("Keys clicks (key_text time):");
                    selectedWindow.getKeyboardClickCollection().forEach((keyboardClick) -> {
                        lines.add(keyboardClick.getKeyText() + " " + keyboardClick.getTime());
                    });
                    lines.add("");
                    lines.add("Mouse clicks (button x y time):");
                    selectedWindow.getMouseClickCollection().forEach((mouseClick) -> {
                        lines.add(mouseClick.getButton() + " " + mouseClick.getX() + " " + mouseClick.getY() + " " + mouseClick.getTime());
                    });
                    lines.add("");
                    lines.add("Mouse scrolls (direction time):");
                    selectedWindow.getMouseScrollCollection().forEach((mouseScroll) -> {
                        lines.add(mouseScroll.getDirection() + " " + mouseScroll.getTime());
                    });
                    Files.write(Paths.get(file.getAbsolutePath()), lines, Charset.forName("UTF-8"));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @FXML
    private void savePictureAsMenuItemClick(ActionEvent event) {
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();
            String initialFileName = new String();
            initialFileName += "CompListener " + selectedWindow.getWindowTitle() + " " + selectedWindow.getStartDate().getDate() + "-" + selectedWindow.getStartDate().getMonth() + "-" + (selectedWindow.getStartDate().getYear() + 1900) + " " + selectedWindow.getStartDate().getHours() + "-" + selectedWindow.getStartDate().getMinutes() + "-" + selectedWindow.getStartDate().getSeconds();

            FileChooser fileChooser = new FileChooser();

            fileChooser.setTitle("Save picture as:");
            fileChooser.setInitialFileName(initialFileName);
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("PNG", "*.png");
            fileChooser.getExtensionFilters().add(fileExtensions);
            fileExtensions = new FileChooser.ExtensionFilter("JPEG", "*.jpg");
            fileChooser.getExtensionFilters().add(fileExtensions);
            fileExtensions = new FileChooser.ExtensionFilter("GIF", "*.gif");
            fileChooser.getExtensionFilters().add(fileExtensions);

            File file = fileChooser.showSaveDialog(CompListenerViewer.getStage());
            System.out.println(fileChooser.getSelectedExtensionFilter().getDescription() + " " + fileChooser.getSelectedExtensionFilter().toString());
            if (file != null) {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(selectedWindow.getPrintScreen());
                    Image image = new Image(byteArrayInputStream);
                    if (fileChooser.getSelectedExtensionFilter().getDescription().compareTo("PNG") == 0) {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                    } else if (fileChooser.getSelectedExtensionFilter().getDescription().compareTo("JPEG") == 0) {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "jpg", file);
                    } else if (fileChooser.getSelectedExtensionFilter().getDescription().compareTo("GIF") == 0) {
                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "gif", file);
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @FXML
    private void closeMenuItemClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void aboutMenuItemClick(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Program info");
        alert.setHeaderText(null);
        alert.setContentText("CompListenerViewer\nAuthor: Łukasz Wojtas");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageView.fitWidthProperty().bind(scrollPane.widthProperty());
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        List<Workstation> workstationList = WorkstationService.getAll();

        WorkstationTable.getTable(workstationTableView, workstationList);
    }

}
