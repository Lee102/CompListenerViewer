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
 *
 * @author Łukasz Wojtas
 */
public class MouseClickTable {

    public static void getTable(TableView mouseClickTable, Collection<MouseClick> mouseClickCollection) {
        mouseClickTable.getColumns().setAll(MouseClickTable.getMouseClickTimeColumn(), MouseClickTable.getMouseClickButtonColumn(), MouseClickTable.getMouseClickXColumn(), MouseClickTable.getMouseClickYColumn());
        mouseClickTable.setItems(MouseClickTable.getItems(mouseClickCollection));
    }

    private static ObservableList getItems(Collection<MouseClick> mouseClickCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        mouseClickCollection.forEach((mouseClick) -> {
            observableList.add(mouseClick);
        });
        return observableList;
    }

    private static TableColumn<MouseClick, Date> getMouseClickTimeColumn() {
        TableColumn<MouseClick, Date> mouseClickTimeColumn = new TableColumn<>("Time");
        mouseClickTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        mouseClickTimeColumn.setMinWidth(130);
        return mouseClickTimeColumn;
    }

    private static TableColumn<MouseClick, String> getMouseClickButtonColumn() {
        TableColumn<MouseClick, String> mouseClickButtonColumn = new TableColumn<>("Button");
        mouseClickButtonColumn.setCellValueFactory(new PropertyValueFactory<>("button"));
        mouseClickButtonColumn.setMinWidth(71);
        return mouseClickButtonColumn;
    }

    private static TableColumn<MouseClick, String> getMouseClickXColumn() {
        TableColumn<MouseClick, String> mouseClickXColumn = new TableColumn<>("X");
        mouseClickXColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        mouseClickXColumn.setMinWidth(50);
        return mouseClickXColumn;
    }

    private static TableColumn<MouseClick, String> getMouseClickYColumn() {
        TableColumn<MouseClick, String> mouseClickYColumn = new TableColumn<>("Y");
        mouseClickYColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        mouseClickYColumn.setMinWidth(50);
        return mouseClickYColumn;
    }

}
