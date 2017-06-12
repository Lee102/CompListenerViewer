/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Window;
import java.util.Collection;
import java.util.Date;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

/**
 * Klasa zarządzająca zawartością TreeTableView wyświetlającego obiekty klasy
 * Window.
 *
 * @author Łukasz Wojtas
 */
public class WindowTable {

    /**
     * Metoda ustawiająca kolumny oraz ich zawartość na podstawie metod
     * prywatnych.
     *
     * @param windowTable Obiekt TreeTableView do wpisania danych.
     * @param windowCollection Kolekcja danych.
     */
    public static void getTable(TreeTableView<Window> windowTable, Collection<Window> windowCollection) {
        windowTable.getColumns().setAll(WindowTable.getWindowTitleColumn(), WindowTable.getStartDateColumn());
        windowTable.setShowRoot(false);
        windowTable.setRoot(WindowTable.getRoot(windowCollection));
    }

    /**
     * Metoda zwracająca dane w formie drzewa.
     *
     * @param windowCollection Kolekcja danych.
     * @return Dane w postaci TreeItem<Window> - root.
     */
    private static TreeItem<Window> getRoot(Collection<Window> windowCollection) {
        TreeItem<Window> root = new TreeItem<>(new Window()), rowWithFirstWindow = null;
        for (Window window : windowCollection) {
            TreeItem<Window> row = new TreeItem<>(window);
            if (window.getFirstWindow() == 1) {
                rowWithFirstWindow = row;
                root.getChildren().add(rowWithFirstWindow);
            } else if (rowWithFirstWindow != null) {
                rowWithFirstWindow.getChildren().add(row);
            }
        }
        return root;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Window title".
     *
     * @return Kolumna "Window title".
     */
    private static TreeTableColumn<Window, String> getWindowTitleColumn() {
        TreeTableColumn<Window, String> windowTitleColumn = new TreeTableColumn<>("Window title");
        windowTitleColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("windowTitle"));
        windowTitleColumn.setMinWidth(221);
        return windowTitleColumn;
    }

    /**
     * Metoda ustawiająca parametry kolumny "Start time".
     *
     * @return Kolumna "Start time".
     */
    private static TreeTableColumn<Window, Date> getStartDateColumn() {
        TreeTableColumn<Window, Date> startDateColumn = new TreeTableColumn<>("Start time");
        startDateColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("startDate"));
        startDateColumn.setMinWidth(130);
        return startDateColumn;
    }

}
