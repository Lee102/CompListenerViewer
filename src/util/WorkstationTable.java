/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Workstation;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Klasa zarządzająca zawartością TableView wyświetlającego obiekty klasy
 * Workstation.
 *
 * @author Łukasz Wojtas
 */
public class WorkstationTable {

    /**
     * Metoda ustawiająca kolumny oraz ich zawartość na podstawie metod
     * prywatnych.
     *
     * @param workstationTable Obiekt TableView do wpisania danych.
     * @param workstationCollection Kolekcja danych.
     */
    public static void getTable(TableView workstationTable, Collection<Workstation> workstationCollection) {
        workstationTable.getColumns().setAll(WorkstationTable.getComputerNameColumn(), WorkstationTable.getUserDomainColumn(), WorkstationTable.getUserNameColumn(), WorkstationTable.getMacAddressColumn());
        if (workstationCollection != null) {
            workstationTable.setItems(WorkstationTable.getItems(workstationCollection));
        } else {
            workstationTable.setItems(null);
        }
    }

    /**
     * Metoda zwracająca dane w odpowiedniej formie.
     *
     * @param workstationCollection Kolekcja danych.
     * @return Dane w postaci ObservableList.
     */
    private static ObservableList getItems(Collection<Workstation> workstationCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        workstationCollection.forEach((workstation) -> {
            observableList.add(workstation);
        });
        return observableList;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Computer name".
     *
     * @return Kolumna "Computer name".
     */
    private static TableColumn<Workstation, String> getComputerNameColumn() {
        TableColumn<Workstation, String> computerNameColumn = new TableColumn<>("Computer name");
        computerNameColumn.setCellValueFactory(new PropertyValueFactory<>("computerName"));
        computerNameColumn.setMinWidth(105);
        return computerNameColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "User domain".
     *
     * @return Kolumna "User domain".
     */
    private static TableColumn<Workstation, String> getUserDomainColumn() {
        TableColumn<Workstation, String> userDomainColumn = new TableColumn<>("User domain");
        userDomainColumn.setCellValueFactory(new PropertyValueFactory<>("userDomain"));
        userDomainColumn.setMinWidth(85);
        return userDomainColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "User name".
     *
     * @return Kolumna "User name".
     */
    private static TableColumn<Workstation, String> getUserNameColumn() {
        TableColumn<Workstation, String> userNameColumn = new TableColumn<>("User name");
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userNameColumn.setMinWidth(70);
        return userNameColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "MAC address".
     *
     * @return Kolumna "MAC address".
     */
    private static TableColumn<Workstation, byte[]> getMacAddressColumn() {
        TableColumn<Workstation, byte[]> macAddressColumn = new TableColumn<>("MAC address");
        macAddressColumn.setCellValueFactory(new PropertyValueFactory<>("macAddress"));
        macAddressColumn.setMinWidth(110);
        return macAddressColumn;
    }

}
