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
public class ShowWorkstationController implements Initializable {

    @FXML
    private TableView tableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Workstation> workstationList = WorkstationService.getAll();

        TableColumn idColumn = new TableColumn("ID");
        idColumn.setMinWidth(30);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn computerNameColumn = new TableColumn("Computer name");
        computerNameColumn.setMinWidth(150);
        computerNameColumn.setCellValueFactory(new PropertyValueFactory<>("computerName"));
        
        TableColumn userDomainColumn = new TableColumn("Domain name");
        userDomainColumn.setMinWidth(150);
        userDomainColumn.setCellValueFactory(new PropertyValueFactory<>("userDomain"));
        
        TableColumn userNameColumn = new TableColumn("User name");
        userNameColumn.setMinWidth(100);
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        
        TableColumn macAddressColumn = new TableColumn("MAC address");
        macAddressColumn.setMinWidth(100);
        macAddressColumn.setCellValueFactory(new PropertyValueFactory<>("macAddress"));

        ObservableList data = FXCollections.observableArrayList();
        workstationList.forEach((workstation) -> {
            data.add(workstation);
        });

        tableView.setItems(data);
        tableView.getColumns().addAll(idColumn, computerNameColumn, userDomainColumn, userNameColumn, macAddressColumn);
    }

}
