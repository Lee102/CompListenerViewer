/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complistenerviewer;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn computerNameColumn, userDomainColumn, userNameColumn, macAddressColumn;

    @FXML
    private TableView wokstationAdditionalDataTableView;
    @FXML
    private TableColumn osVersionColumn, osArchColumn, javaVersionColumn, procIdColumn, procArchColumn, procCoresColumn, ramSizeColumn, diskSizeColumn;

    @FXML
    private TableView windowTableView;
    @FXML
    private TableColumn startDateColumn, windowTitleColumn, firstWindowColumn;

    @FXML
    private TableView keyboardClickTableView;
    @FXML
    private TableColumn keyboardClickTimeColumn, keyboardClickTextColumn;

    @FXML
    private TableView mouseClickTableView;
    @FXML
    private TableColumn mouseClickTimeColumn, mouseClickButtonColumn, mouseClickXColumn, mouseClickYColumn;

    @FXML
    private TableView mouseScrollTableView;
    @FXML
    private TableColumn mouseScrollTimeColumn, mouseScrollDirectionColumn;

    @FXML
    private ImageView printScreen;

    @FXML
    private void workstationTableViewClick(MouseEvent event) {
        if (workstationTableView.getSelectionModel().getSelectedItem() != null) {
            Workstation selectedWorkstation = (Workstation) workstationTableView.getSelectionModel().getSelectedItem();

            osVersionColumn.setCellValueFactory(new PropertyValueFactory<>("osVersion"));
            osArchColumn.setCellValueFactory(new PropertyValueFactory<>("osArch"));
            javaVersionColumn.setCellValueFactory(new PropertyValueFactory<>("javaVersion"));
            procIdColumn.setCellValueFactory(new PropertyValueFactory<>("procId"));
            procArchColumn.setCellValueFactory(new PropertyValueFactory<>("procArch"));
            procCoresColumn.setCellValueFactory(new PropertyValueFactory<>("procCores"));
            ramSizeColumn.setCellValueFactory(new PropertyValueFactory<>("ramSize"));
            diskSizeColumn.setCellValueFactory(new PropertyValueFactory<>("diskSize"));
            ObservableList observableList = FXCollections.observableArrayList();
            observableList.add(selectedWorkstation.getWorkstationAdditionalData());
            wokstationAdditionalDataTableView.setItems(observableList);

            startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
            windowTitleColumn.setCellValueFactory(new PropertyValueFactory<>("windowTitle"));
            firstWindowColumn.setCellValueFactory(new PropertyValueFactory<>("firstWindow"));
            ObservableList observableList1 = FXCollections.observableArrayList();
            selectedWorkstation.getWindowCollection().forEach((window) -> {
                observableList1.add(window);
            });
            windowTableView.setItems(observableList1);

            a.setCellValueFactory(new PropertyValueFactory<>("windowTitle"));
            b.setCellValueFactory(new PropertyValueFactory<>("startDate"));

            TreeItem<Window> root = new TreeItem<>(new Window()), first = null;
            root.setExpanded(true);

            for (Window window : selectedWorkstation.getWindowCollection()) {
                TreeItem<Window> item = new TreeItem<>(window);
                if (window.getFirstWindow() == 1) {
                    first = item;
                    root.getChildren().add(first);
                } else if (first != null) {
                    first.getChildren().add(item);
                }
            }
            //ttv.setRoot(root);
            //System.out.println("asdf");
            //ttv.setRoot(root);
            //ttv.setRoot(root);
            //ttv= new TreeTableView<>(root);
        }
    }

    @FXML
    private TreeTableView ttv;

    @FXML
    private TreeTableColumn a, b;

    @FXML
    private void windowTableViewClick(MouseEvent event) {
        if (windowTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = (Window) windowTableView.getSelectionModel().getSelectedItem();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(selectedWindow.getPrintScreen());
            Image image = new Image(byteArrayInputStream);
            printScreen.setImage(image);

            keyboardClickTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            keyboardClickTextColumn.setCellValueFactory(new PropertyValueFactory<>("keyText"));
            ObservableList observableList = FXCollections.observableArrayList();
            selectedWindow.getKeyboardClickCollection().forEach((keyboardClick) -> {
                observableList.add(keyboardClick);
            });
            keyboardClickTableView.setItems(observableList);

            mouseClickTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            mouseClickButtonColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
            mouseClickXColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
            mouseClickYColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
            ObservableList observableList1 = FXCollections.observableArrayList();
            selectedWindow.getMouseClickCollection().forEach((mouseClick) -> {
                observableList1.add(mouseClick);
            });
            mouseClickTableView.setItems(observableList1);

            mouseScrollTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
            mouseScrollDirectionColumn.setCellValueFactory(new PropertyValueFactory<>("direction"));
            ObservableList observableList2 = FXCollections.observableArrayList();
            selectedWindow.getMouseScrollCollection().forEach((mouseScroll) -> {
                observableList2.add(mouseScroll);
            });
            mouseScrollTableView.setItems(observableList2);
        }
    }

    @FXML
    private void saveDataAsMenuItemClick(ActionEvent event) {
        if (windowTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = (Window) windowTableView.getSelectionModel().getSelectedItem();
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
        if (windowTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = (Window) windowTableView.getSelectionModel().getSelectedItem();
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
    private void exitMenuItemClick(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Workstation> workstationList = WorkstationService.getAll();

        computerNameColumn.setCellValueFactory(new PropertyValueFactory<>("computerName"));
        userDomainColumn.setCellValueFactory(new PropertyValueFactory<>("userDomain"));
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        macAddressColumn.setCellValueFactory(new PropertyValueFactory<>("macAddress"));

        ObservableList observableList = FXCollections.observableArrayList();
        workstationList.forEach((workstation) -> {
            observableList.add(workstation);
        });

        workstationTableView.setItems(observableList);
    }

}
