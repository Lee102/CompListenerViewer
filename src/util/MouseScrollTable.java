/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.MouseScroll;
import java.util.Collection;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Klasa zarządzająca zawartością TableView wyświetlającego obiekty klasy
 * MouseScroll.
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollTable {

    /**
     * Metoda ustawiająca kolumny oraz ich zawartość na podstawie metod
     * prywatnych.
     *
     * @param mouseScrollTable Obiekt TableView do wpisania danych.
     * @param mouseScrollCollection Kolekcja danych.
     */
    public static void getTable(TableView mouseScrollTable, Collection<MouseScroll> mouseScrollCollection) {
        mouseScrollTable.getColumns().setAll(MouseScrollTable.getMouseScrollTimeColumn(), MouseScrollTable.getMouseScrollDirectionColumn());
        if (mouseScrollCollection != null) {
            mouseScrollTable.setItems(MouseScrollTable.getItems(mouseScrollCollection));
        } else {
            mouseScrollTable.setItems(null);
        }
    }

    /**
     * Metoda zwracająca dane w odpowiedniej formie.
     *
     * @param mouseScrollCollection Kolekcja danych.
     * @return Dane w postaci ObservableList.
     */
    private static ObservableList getItems(Collection<MouseScroll> mouseScrollCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        mouseScrollCollection.forEach((mouseScroll) -> {
            observableList.add(mouseScroll);
        });
        return observableList;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Time".
     *
     * @return Kolumna "Time".
     */
    private static TableColumn<MouseScroll, Date> getMouseScrollTimeColumn() {
        TableColumn<MouseScroll, Date> mouseScrollTimeColumn = new TableColumn<>("Time");
        mouseScrollTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        mouseScrollTimeColumn.setMinWidth(130);
        return mouseScrollTimeColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Direction".
     *
     * @return Kolumna "Direction".
     */
    private static TableColumn<MouseScroll, String> getMouseScrollDirectionColumn() {
        TableColumn<MouseScroll, String> mouseScrollDirectionColumn = new TableColumn<>("Direction");
        mouseScrollDirectionColumn.setCellValueFactory(new PropertyValueFactory<>("direction"));
        mouseScrollDirectionColumn.setMinWidth(71);
        return mouseScrollDirectionColumn;
    }
    
}
