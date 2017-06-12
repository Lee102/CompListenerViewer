/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.WorkstationAdditionalData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Klasa zarządzająca zawartością TableView wyświetlającego obiekty klasy
 * WorkstationAdditionalData.
 *
 * @author Łukasz Wojtas
 */
public class WorkstationAdditionalDataTable {

    /**
     * Metoda ustawiająca kolumny oraz ich zawartość na podstawie metod
     * prywatnych.
     *
     * @param workstationAdditionalDataTable Obiekt TableView do wpisania
     * danych.
     * @param workstationAdditionalData Kolekcja danych.
     */
    public static void getTable(TableView workstationAdditionalDataTable, WorkstationAdditionalData workstationAdditionalData) {
        workstationAdditionalDataTable.getColumns().setAll(WorkstationAdditionalDataTable.getOsVersionColumn(), WorkstationAdditionalDataTable.getOsArchColumn(), WorkstationAdditionalDataTable.getJavaVersionColumn(), WorkstationAdditionalDataTable.getProcIdColumn(), WorkstationAdditionalDataTable.getProcArchColumn(), WorkstationAdditionalDataTable.getProcCoresColumn(), WorkstationAdditionalDataTable.getRamSizeColumn(), WorkstationAdditionalDataTable.getDiskSizeColumn());
        workstationAdditionalDataTable.setItems(WorkstationAdditionalDataTable.getItems(workstationAdditionalData));
    }

    /**
     * Metoda zwracająca dane w odpowiedniej formie.
     *
     * @param workstationAdditionalData Kolekcja danych.
     * @return Dane w postaci ObservableList.
     */
    private static ObservableList getItems(WorkstationAdditionalData workstationAdditionalData) {
        ObservableList observableList = FXCollections.observableArrayList();
        observableList.add(workstationAdditionalData);
        return observableList;
    }

    /**
     * Metoda ustawiająca parametry kolumny "OS version".
     *
     * @return Kolumna "OS version".
     */
    private static TableColumn<WorkstationAdditionalDataTable, String> getOsVersionColumn() {
        TableColumn<WorkstationAdditionalDataTable, String> osVersionColumn = new TableColumn<>("OS version");
        osVersionColumn.setCellValueFactory(new PropertyValueFactory<>("osVersion"));
        osVersionColumn.setMinWidth(70);
        return osVersionColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "OS arch".
     *
     * @return Kolumna "OS arch".
     */
    private static TableColumn<WorkstationAdditionalDataTable, String> getOsArchColumn() {
        TableColumn<WorkstationAdditionalDataTable, String> osArchColumn = new TableColumn<>("OS arch");
        osArchColumn.setCellValueFactory(new PropertyValueFactory<>("osArch"));
        osArchColumn.setMinWidth(55);
        return osArchColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Java version".
     *
     * @return Kolumna "Java version".
     */
    private static TableColumn<WorkstationAdditionalDataTable, String> getJavaVersionColumn() {
        TableColumn<WorkstationAdditionalDataTable, String> javaVersionColumn = new TableColumn<>("Java version");
        javaVersionColumn.setCellValueFactory(new PropertyValueFactory<>("javaVersion"));
        javaVersionColumn.setMinWidth(80);
        return javaVersionColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "CPU ID".
     *
     * @return Kolumna "CPU ID".
     */
    private static TableColumn<WorkstationAdditionalDataTable, String> getProcIdColumn() {
        TableColumn<WorkstationAdditionalDataTable, String> procIdColumn = new TableColumn<>("CPU ID");
        procIdColumn.setCellValueFactory(new PropertyValueFactory<>("procId"));
        procIdColumn.setMinWidth(55);
        return procIdColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "CPU arch".
     *
     * @return Kolumna "CPU arch".
     */
    private static TableColumn<WorkstationAdditionalDataTable, String> getProcArchColumn() {
        TableColumn<WorkstationAdditionalDataTable, String> procArchColumn = new TableColumn<>("CPU arch");
        procArchColumn.setCellValueFactory(new PropertyValueFactory<>("procArch"));
        procArchColumn.setMinWidth(65);
        return procArchColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "CPU cores".
     *
     * @return Kolumna "CPU cores".
     */
    private static TableColumn<WorkstationAdditionalDataTable, Integer> getProcCoresColumn() {
        TableColumn<WorkstationAdditionalDataTable, Integer> procCoresColumn = new TableColumn<>("CPU cores");
        procCoresColumn.setCellValueFactory(new PropertyValueFactory<>("procCores"));
        procCoresColumn.setMinWidth(70);
        return procCoresColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "RAM size".
     *
     * @return Kolumna "RAM size".
     */
    private static TableColumn<WorkstationAdditionalDataTable, Integer> getRamSizeColumn() {
        TableColumn<WorkstationAdditionalDataTable, Integer> ramSizeColumn = new TableColumn<>("RAM size");
        ramSizeColumn.setCellValueFactory(new PropertyValueFactory<>("ramSize"));
        ramSizeColumn.setMinWidth(70);
        return ramSizeColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Disk size".
     *
     * @return Kolumna "Disk size".
     */
    private static TableColumn<WorkstationAdditionalDataTable, Integer> getDiskSizeColumn() {
        TableColumn<WorkstationAdditionalDataTable, Integer> diskSizeColumn = new TableColumn<>("Disk size");
        diskSizeColumn.setCellValueFactory(new PropertyValueFactory<>("diskSize"));
        diskSizeColumn.setMinWidth(70);
        return diskSizeColumn;
    }

}
