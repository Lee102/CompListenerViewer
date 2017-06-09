/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complistenerviewer;

import entity.Workstation;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn computerName, userDomain, userName, macAddress;

    @FXML
    private TableView wokstationAdditionalDataTableView;

    @FXML
    private TableColumn osVersion, osArch, javaVersion, procId, procArch, procCores, ramSize, diskSize;

    @FXML
    private void workstationTableViewClick(ActionEvent event) {
        if (workstationTableView.getSelectionModel().getSelectedItem() != null) {
            Workstation selected = (Workstation) workstationTableView.getSelectionModel().getSelectedItem();
            osVersion.setCellValueFactory(new PropertyValueFactory<>("os_version"));
            osArch.setCellValueFactory(new PropertyValueFactory<>("os_arch"));
            javaVersion.setCellValueFactory(new PropertyValueFactory<>("java_version"));
            procId.setCellValueFactory(new PropertyValueFactory<>("proc_id"));
            procArch.setCellValueFactory(new PropertyValueFactory<>("proc_arch"));
            procCores.setCellValueFactory(new PropertyValueFactory<>("proc_cores"));
            ramSize.setCellValueFactory(new PropertyValueFactory<>("ram_size"));
            diskSize.setCellValueFactory(new PropertyValueFactory<>("disk_size"));

            ObservableList data1 = FXCollections.observableArrayList();
            data1.add(((List) selected.getWorkstationAdditionalDataCollection()).get(0));

            wokstationAdditionalDataTableView.setItems(data1);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Workstation> workstationList = WorkstationService.getAll();

        computerName.setCellValueFactory(new PropertyValueFactory<>("computerName"));
        userDomain.setCellValueFactory(new PropertyValueFactory<>("userDomain"));
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        macAddress.setCellValueFactory(new PropertyValueFactory<>("macAddress"));

        ObservableList data = FXCollections.observableArrayList();
        workstationList.forEach((workstation) -> {
            data.add(workstation);
        });

        workstationTableView.setItems(data);

        /*Workstation selected = (Workstation)workstationTableView.getSelectionModel().getSelectedItem();
        osVersion.setCellValueFactory(new PropertyValueFactory<>("os_version"));
        osArch.setCellValueFactory(new PropertyValueFactory<>("os_arch"));
        javaVersion.setCellValueFactory(new PropertyValueFactory<>("java_version"));
        procId.setCellValueFactory(new PropertyValueFactory<>("proc_id"));
        procArch.setCellValueFactory(new PropertyValueFactory<>("proc_arch"));
        procCores.setCellValueFactory(new PropertyValueFactory<>("proc_cores"));
        ramSize.setCellValueFactory(new PropertyValueFactory<>("ram_size"));
        diskSize.setCellValueFactory(new PropertyValueFactory<>("disk_size"));
                
        ObservableList data1 = FXCollections.observableArrayList();        
        data1.add(((List)selected.getWorkstationAdditionalDataCollection()).get(0));
        
        wokstationAdditionalDataTableView.setItems(data1);*/
    }

}
