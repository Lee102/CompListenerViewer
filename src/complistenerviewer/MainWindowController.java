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
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import service.WindowService;
import service.WorkstationService;
import util.KeyboardClickTextArea;

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
    private Label keyboardClickLabel;

    @FXML
    private TextArea keyboardClickTextArea;

    @FXML
    private HBox keyboardClickAndMouseScrollHBox;

    @FXML
    private MenuItem backToNormalDisplayModeMenuItem;

    private int keyboardClickViewMode, searchMode;

    /**
     * Metoda obsługująca kliknięcie na TableView wyświetlający obiekty klasy
     * Workstation. Po wybraniu 1 z obiektów ładowane są zawartość TreeTableView
     * wyświetlającego obiekty klasy Window.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void workstationTableViewClick(MouseEvent event) {
        if (workstationTableView.getSelectionModel().getSelectedItem() != null) {
            Workstation selectedWorkstation = (Workstation) workstationTableView.getSelectionModel().getSelectedItem();

            WorkstationAdditionalDataTable.getTable(wokstationAdditionalDataTableView, selectedWorkstation.getWorkstationAdditionalData());
            if (searchMode != 2) {
                WindowTable.getTable(windowTreeTableView, selectedWorkstation.getWindowCollection());
            }
        }
    }

    /**
     * Metoda obsługująca kliknięcie na TreeTableView wyświetlający obiekty
     * klasy Window. Po wybraniu 1 z obiektów ładowany jest obraz do ImageView
     * oraz zawartość TableView wyświetlających obiekty klas KeyboardClick,
     * MouseClick, MouseScroll.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void windowTreeTableViewClick(MouseEvent event) {
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(selectedWindow.getPrintScreen());
            Image image = new Image(byteArrayInputStream);
            if (image.getWidth() >= image.getHeight()) {
                imageView.fitWidthProperty().bind(scrollPane.widthProperty());
            } else {
                imageView.fitHeightProperty().bind(scrollPane.heightProperty());
            }
            imageView.setImage(image);

            MouseClickTable.getTable(mouseClickTableView, selectedWindow.getMouseClickCollection());
            MouseScrollTable.getTable(mouseScrollTableView, selectedWindow.getMouseScrollCollection());
            switch (keyboardClickViewMode) {
                case 0:
                    KeyboardClickTextArea.getTextAreaInc(keyboardClickTextArea, selectedWindow.getKeyboardClickCollection());
                    break;
                case 1:
                    KeyboardClickTextArea.getTextAreaExc(keyboardClickTextArea, selectedWindow.getKeyboardClickCollection());
                    break;
                case 2:
                    KeyboardClickTable.getTable(keyboardClickTableView, selectedWindow.getKeyboardClickCollection());
                    break;
            }
        }
    }

    @FXML
    private void imageViewClick(MouseEvent event) {
        if (imageView.getImage() != null) {
            try {
                FullScreenImageViewController.setImage(imageView.getImage());
                Parent root = FXMLLoader.load(getClass().getResource("FullScreenImageView.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("CompListenerViewer - fullscreen print screen");
                stage.setFullScreen(true);
                stage.setFullScreenExitHint("Click anywhere to close");
                stage.setMinWidth(800);
                stage.setMinHeight(600);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Save data as...".
     * Inicjalizowany jest FileChooser w celu wybrania miejsca do zapisu danych.
     * Następnie w wybarnym miejscu zapisywane są dane.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
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

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Save picture as...".
     * Inicjalizowany jest FileChooser w celu wybrania miejsca do zapisu zrzutu
     * ekranu. Następnie w wybarnym miejscu zapisywany jest obraz.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
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

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Save picture as...". Pobierane
     * są nowe dane z bazy danych.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void refreshDataMenuItemClick(ActionEvent event) {
        List<Workstation> workstationList = WorkstationService.getAll();
        WorkstationTable.getTable(workstationTableView, workstationList);
        WorkstationAdditionalDataTable.getTable(wokstationAdditionalDataTableView, null);
        WindowTable.getTable(windowTreeTableView, null);
        MouseClickTable.getTable(mouseClickTableView, null);
        KeyboardClickTable.getTable(keyboardClickTableView, null);
        KeyboardClickTextArea.getTextAreaInc(keyboardClickTextArea, null);
        MouseScrollTable.getTable(mouseScrollTableView, null);
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Close". Program jest wyłączany.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void closeMenuItemClick(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Basic info (include
     * backspace)". Tryb wyświetlania obiektów klasy KeyboardClick jest
     * ustawiany na tryb listy z uwzględnieniem usunięć znaków.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void basickInfoIncMenuItemClick(ActionEvent event) {
        keyboardClickViewMode = 0;
        keyboardClickLabel.setVisible(true);
        keyboardClickTextArea.setVisible(true);
        keyboardClickAndMouseScrollHBox.setVisible(false);
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();
            KeyboardClickTextArea.getTextAreaInc(keyboardClickTextArea, selectedWindow.getKeyboardClickCollection());
        }
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Basic info (exclude
     * backspace)". Tryb wyświetlania obiektów klasy KeyboardClick jest
     * ustawiany na tryb listy z pominięciem usunięć znaków.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void basickInfoExcMenuItemClick(ActionEvent event) {
        keyboardClickViewMode = 1;
        keyboardClickLabel.setVisible(true);
        keyboardClickTextArea.setVisible(true);
        keyboardClickAndMouseScrollHBox.setVisible(false);
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();
            KeyboardClickTextArea.getTextAreaExc(keyboardClickTextArea, selectedWindow.getKeyboardClickCollection());
        }
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Extended info (+ mouse
     * scrolls)". Tryb wyświetlania obiektów klasy KeyboardClick jest ustawiany
     * na tryb rozszerzony.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void extendedInfoMenuItemClick(ActionEvent event) {
        keyboardClickViewMode = 2;
        keyboardClickLabel.setVisible(false);
        keyboardClickTextArea.setVisible(false);
        keyboardClickAndMouseScrollHBox.setVisible(true);
        if (windowTreeTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = windowTreeTableView.getSelectionModel().getSelectedItem().getValue();
            KeyboardClickTable.getTable(keyboardClickTableView, selectedWindow.getKeyboardClickCollection());
        }
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Search by workstation".
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void searchByWorkstationMenuItemClick(ActionEvent event) {
        backToNormalDisplayModeMenuItem.setVisible(true);
        searchMode = 1;

        WorkstationAdditionalDataTable.getTable(wokstationAdditionalDataTableView, null);
        WindowTable.getTable(windowTreeTableView, null);
        MouseClickTable.getTable(mouseClickTableView, null);
        KeyboardClickTable.getTable(keyboardClickTableView, null);
        KeyboardClickTextArea.getTextAreaInc(keyboardClickTextArea, null);
        MouseScrollTable.getTable(mouseScrollTableView, null);

        TextField computerName = new TextField();
        TextField userDomain = new TextField();
        TextField userName = new TextField();
        TextField macAddress = new TextField();

        computerName.setPromptText("Computer name");
        userDomain.setPromptText("User domain");
        userName.setPromptText("User name");
        macAddress.setPromptText("MAC address");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        gridPane.add(new Label("Computer name:"), 0, 0);
        gridPane.add(computerName, 1, 0);
        gridPane.add(new Label("User domain:"), 0, 1);
        gridPane.add(userDomain, 1, 1);
        gridPane.add(new Label("User name:"), 0, 2);
        gridPane.add(userName, 1, 2);
        gridPane.add(new Label("MAC address:"), 0, 3);
        gridPane.add(macAddress, 1, 3);

        ButtonType searchButton = new ButtonType("Search", ButtonData.OK_DONE);

        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(gridPane);

        Dialog dialog = new Dialog();
        dialog.setTitle("Search by workstation data");

        dialog.setDialogPane(dialogPane);
        dialog.getDialogPane().getButtonTypes().add(searchButton);
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.get() == searchButton) {
            List<Workstation> workstationList = WorkstationService.findByAll(computerName.getText(), userDomain.getText(), userName.getText(), macAddress.getText());
            WorkstationTable.getTable(workstationTableView, workstationList);
        }

    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Search by window".
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void searchByWindowMenuItemClick(ActionEvent event) {
        backToNormalDisplayModeMenuItem.setVisible(true);
        searchMode = 2;

        WorkstationAdditionalDataTable.getTable(wokstationAdditionalDataTableView, null);
        MouseClickTable.getTable(mouseClickTableView, null);
        KeyboardClickTable.getTable(keyboardClickTableView, null);
        KeyboardClickTextArea.getTextAreaInc(keyboardClickTextArea, null);
        MouseScrollTable.getTable(mouseScrollTableView, null);

        TextField windowTitle = new TextField();
        DatePicker fromDate = new DatePicker();
        DatePicker toDate = new DatePicker();

        windowTitle.setPromptText("Window Title");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        gridPane.add(new Label("windowTitle:"), 0, 0);
        gridPane.add(windowTitle, 1, 0);
        gridPane.add(new Label("From date:"), 0, 1);
        gridPane.add(fromDate, 1, 1);
        gridPane.add(new Label("To data:"), 0, 2);
        gridPane.add(toDate, 1, 2);

        ButtonType searchButton = new ButtonType("Search", ButtonData.OK_DONE);

        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(gridPane);

        Dialog dialog = new Dialog();
        dialog.setTitle("Search by window data");

        dialog.setDialogPane(dialogPane);
        dialog.getDialogPane().getButtonTypes().add(searchButton);
        dialog.getDialogPane().getButtonTypes().add(new ButtonType("Cancel", ButtonData.CANCEL_CLOSE));

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.get() == searchButton) {
            Date dateMin, dateMax;
            if (fromDate.getValue() != null) {
                dateMin = Date.from(Instant.from(fromDate.getValue().atStartOfDay(ZoneId.systemDefault())));
            } else {
                dateMin = null;
            }
            if (toDate.getValue() != null) {
                dateMax = Date.from(Instant.from(toDate.getValue().atStartOfDay(ZoneId.systemDefault())));
            } else {
                dateMax = null;
            }

            List<Window> windowList = WindowService.findByAll(windowTitle.getText(), dateMin, dateMax);
            WindowTable.getTableWithoutLevels(windowTreeTableView, windowList);

            List<Workstation> workstationList = new ArrayList<>();
            for (Window window : windowList) {
                if (!workstationList.contains(window.getWorkstationId())) {
                    workstationList.add(window.getWorkstationId());
                }
            }
            WorkstationTable.getTable(workstationTableView, workstationList);
        }
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "Back to normal display mode".
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void backToNormalDisplayModeMenuItemClick(ActionEvent event) {
        backToNormalDisplayModeMenuItem.setVisible(false);
        searchMode = 0;

        List<Workstation> workstationList = WorkstationService.getAll();
        WorkstationTable.getTable(workstationTableView, workstationList);
        WorkstationAdditionalDataTable.getTable(wokstationAdditionalDataTableView, null);
        WindowTable.getTable(windowTreeTableView, null);
        MouseClickTable.getTable(mouseClickTableView, null);
        KeyboardClickTable.getTable(keyboardClickTableView, null);
        KeyboardClickTextArea.getTextAreaInc(keyboardClickTextArea, null);
        MouseScrollTable.getTable(mouseScrollTableView, null);
    }

    /**
     * Metoda obsługująca kliknięcie w MenuItem "About". Wyświetlany jest Alert
     * z podstawowymi informacjami o programie.
     *
     * @param event Parametry dotyczące kliknięcia.
     */
    @FXML
    private void aboutMenuItemClick(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Program info");
        alert.setHeaderText(null);
        alert.setContentText("CompListenerViewer\nAuthor: Łukasz Wojtas");
        alert.showAndWait();
    }

    /**
     * Metoda inicjalizująca. Ustawia właściwości skalowania ImageView oraz
     * przypisuje dane do TableView wyświetlającego obiekty klasy Workstation.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        List<Workstation> workstationList = WorkstationService.getAll();

        keyboardClickLabel.managedProperty().bind(keyboardClickLabel.visibleProperty());
        keyboardClickTextArea.managedProperty().bind(keyboardClickTextArea.visibleProperty());
        keyboardClickAndMouseScrollHBox.managedProperty().bind(keyboardClickAndMouseScrollHBox.visibleProperty());

        keyboardClickViewMode = 0;
        searchMode = 0;

        WorkstationTable.getTable(workstationTableView, workstationList);
    }

}
