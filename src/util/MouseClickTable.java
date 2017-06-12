/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.MouseClick;
import java.util.Collection;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Klasa zarządzająca zawartością TableView wyświetlającego obiekty klasy
 * MouseClick.
 *
 * @author Łukasz Wojtas
 */
public class MouseClickTable {

    /**
     * Metoda ustawiająca kolumny oraz ich zawartość na podstawie metod
     * prywatnych.
     *
     * @param mouseClickTable Obiekt TableView do wpisania danych.
     * @param mouseClickCollection Kolekcja danych.
     */
    public static void getTable(TableView mouseClickTable, Collection<MouseClick> mouseClickCollection) {
        mouseClickTable.getColumns().setAll(MouseClickTable.getMouseClickTimeColumn(), MouseClickTable.getMouseClickButtonColumn(), MouseClickTable.getMouseClickXColumn(), MouseClickTable.getMouseClickYColumn());
        mouseClickTable.setItems(MouseClickTable.getItems(mouseClickCollection));
    }

    /**
     * Metoda zwracająca dane w odpowiedniej formie.
     *
     * @param mouseClickCollection Kolekcja danych.
     * @return Dane w postaci ObservableList.
     */
    private static ObservableList getItems(Collection<MouseClick> mouseClickCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        mouseClickCollection.forEach((mouseClick) -> {
            observableList.add(mouseClick);
        });
        return observableList;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Time".
     *
     * @return Kolumna "Time".
     */
    private static TableColumn<MouseClick, Date> getMouseClickTimeColumn() {
        TableColumn<MouseClick, Date> mouseClickTimeColumn = new TableColumn<>("Time");
        mouseClickTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        mouseClickTimeColumn.setMinWidth(130);
        return mouseClickTimeColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Button".
     *
     * @return Kolumna "Button".
     */
    private static TableColumn<MouseClick, String> getMouseClickButtonColumn() {
        TableColumn<MouseClick, String> mouseClickButtonColumn = new TableColumn<>("Button");
        mouseClickButtonColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
        mouseClickButtonColumn.setMinWidth(71);
        return mouseClickButtonColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "X".
     *
     * @return Kolumna "X".
     */
    private static TableColumn<MouseClick, String> getMouseClickXColumn() {
        TableColumn<MouseClick, String> mouseClickXColumn = new TableColumn<>("X");
        mouseClickXColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        mouseClickXColumn.setMinWidth(50);
        return mouseClickXColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Y".
     *
     * @return Kolumna "Y".
     */
    private static TableColumn<MouseClick, String> getMouseClickYColumn() {
        TableColumn<MouseClick, String> mouseClickYColumn = new TableColumn<>("Y");
        mouseClickYColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        mouseClickYColumn.setMinWidth(50);
        return mouseClickYColumn;
    }

}
