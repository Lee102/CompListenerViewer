/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complistenerviewer;

import entity.Window;
import entity.Workstation;
import entity.WorkstationAdditionalData;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import service.WorkstationService;

/**
 * FXML Controller class
 *
 * @author Łukasz Wojtas
 */
public class MainWindowController implements Initializable {

    @FXML
    private TableView wokstationAdditionalDataTableView;

    @FXML
    private TableColumn osVersionColumn, osArchColumn, javaVersionColumn, procIdColumn, procArchColumn, procCoresColumn, ramSizeColumn, diskSizeColumn;

    @FXML
    private TableView windowTableView;

    @FXML
    private TableColumn startDateColumn, windowTitleColumn, firstWindowColumn;

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
            //startDateColumn.setCellValueFactory(new PropertyValueFactory<>("windowTitle"));
            windowTitleColumn.setCellValueFactory(new PropertyValueFactory<>("windowTitle"));
            firstWindowColumn.setCellValueFactory(new PropertyValueFactory<>("firstWindow"));
            ObservableList observableList1 = FXCollections.observableArrayList();
            selectedWorkstation.getWindowCollection().forEach((window) -> {
                observableList1.add(window);
            });

            windowTableView.setItems(observableList1);
        }
    }

    @FXML ImageView printScreen;
    
    @FXML
    private void windowTableViewClick(MouseEvent event) {
        if (windowTableView.getSelectionModel().getSelectedItem() != null) {
            Window selectedWindow = (Window) windowTableView.getSelectionModel().getSelectedItem();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(selectedWindow.getPrintScreen());
            Image image = new Image(byteArrayInputStream);
            printScreen.setImage(image);
        }
    }
    
    @FXML
    private TableView workstationTableView;

    @FXML
    private TableColumn computerNameColumn, userDomainColumn, userNameColumn, macAddressColumn;

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
