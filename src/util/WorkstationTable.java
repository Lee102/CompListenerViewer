/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Workstation;
import java.util.Collection;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Łukasz Wojtas
 */
public class WorkstationTable {

    public static void getTable(TableView workstationTable, Collection<Workstation> workstationCollection) {
        workstationTable.getColumns().setAll(WorkstationTable.getComputerNameColumn(), WorkstationTable.getUserDomainColumn(), WorkstationTable.getUserNameColumn(), WorkstationTable.getMacAddressColumn());
        workstationTable.setItems(WorkstationTable.getItems(workstationCollection));
    }

    private static ObservableList getItems(Collection<Workstation> workstationCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        workstationCollection.forEach((workstation) -> {
            observableList.add(workstation);
        });
        return observableList;
    }
//computerNameColumn, userDomainColumn, userNameColumn, macAddressColumn

    private static TableColumn<Workstation, String> getComputerNameColumn() {
        TableColumn<Workstation, String> computerNameColumn = new TableColumn<>("Computer name");
        computerNameColumn.setCellValueFactory(new PropertyValueFactory<>("computerName"));
        computerNameColumn.setMinWidth(105);
        return computerNameColumn;
    }

    private static TableColumn<Workstation, String> getUserDomainColumn() {
        TableColumn<Workstation, String> userDomainColumn = new TableColumn<>("User domain");
        userDomainColumn.setCellValueFactory(new PropertyValueFactory<>("userDomain"));
        userDomainColumn.setMinWidth(85);
        return userDomainColumn;
    }

    private static TableColumn<Workstation, String> getUserNameColumn() {
        TableColumn<Workstation, String> userNameColumn = new TableColumn<>("User name");
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userNameColumn.setMinWidth(70);
        return userNameColumn;
    }

    private static TableColumn<Workstation, byte[]> getMacAddressColumn() {
        TableColumn<Workstation, byte[]> macAddressColumn = new TableColumn<>("MAC address");
        macAddressColumn.setCellValueFactory(new PropertyValueFactory<>("macAddress"));
        macAddressColumn.setMinWidth(90);
        return macAddressColumn;
    }

}
