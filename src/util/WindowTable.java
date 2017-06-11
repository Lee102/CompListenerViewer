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
 *
 * @author Łukasz Wojtas
 */
public class WindowTable {

    public static void getTable(TreeTableView<Window> windowTable, Collection<Window> windowCollection) {
        windowTable.getColumns().setAll(WindowTable.getWindowTitleColumn(), WindowTable.getStartDateColumn());
        windowTable.setShowRoot(false);
        windowTable.setRoot(WindowTable.getRoot(windowCollection));
    }

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

    private static TreeTableColumn<Window, String> getWindowTitleColumn() {
        TreeTableColumn<Window, String> windowTitleColumn = new TreeTableColumn<>("Window title");
        windowTitleColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("windowTitle"));
        windowTitleColumn.setMinWidth(221);
        return windowTitleColumn;
    }

    private static TreeTableColumn<Window, Date> getStartDateColumn() {
        TreeTableColumn<Window, Date> startDateColumn = new TreeTableColumn<>("Start time");
        startDateColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("startDate"));
        startDateColumn.setMinWidth(130);
        return startDateColumn;
    }

}
