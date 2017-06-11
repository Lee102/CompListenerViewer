/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.KeyboardClick;
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
public class KeyboardClickTable {

    public static void getTable(TableView keyboardClickTable, Collection<KeyboardClick> keyboardClickCollection) {
        keyboardClickTable.getColumns().setAll(KeyboardClickTable.getKeyboardClickTimeColumn(), KeyboardClickTable.getKeyboardClickTextColumn());
        keyboardClickTable.setItems(KeyboardClickTable.getItems(keyboardClickCollection));
    }

    private static ObservableList getItems(Collection<KeyboardClick> keyboardClickCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        keyboardClickCollection.forEach((keyboardClick) -> {
            observableList.add(keyboardClick);
        });
        return observableList;
    }

    private static TableColumn<KeyboardClick, Date> getKeyboardClickTimeColumn() {
        TableColumn<KeyboardClick, Date> keyboardClickTimeColumn = new TableColumn<>("Time");
        keyboardClickTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        keyboardClickTimeColumn.setMinWidth(130);
        return keyboardClickTimeColumn;
    }

    private static TableColumn<KeyboardClick, String> getKeyboardClickTextColumn() {
        TableColumn<KeyboardClick, String> keyboardClickTextColumn = new TableColumn<>("Key text");
        keyboardClickTextColumn.setCellValueFactory(new PropertyValueFactory<>("keyText"));
        keyboardClickTextColumn.setMinWidth(71);
        return keyboardClickTextColumn;
    }

}
