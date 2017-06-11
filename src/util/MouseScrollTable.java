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
 *
 * @author Łukasz Wojtas
 */
public class MouseScrollTable {

    public static void getTable(TableView mouseScrollTable, Collection<MouseScroll> mouseScrollCollection) {
        mouseScrollTable.getColumns().setAll(MouseScrollTable.getMouseScrollTimeColumn(), MouseScrollTable.getMouseScrollDirectionColumn());
        mouseScrollTable.setItems(MouseScrollTable.getItems(mouseScrollCollection));
    }

    private static ObservableList getItems(Collection<MouseScroll> mouseScrollCollection) {
        ObservableList observableList = FXCollections.observableArrayList();
        mouseScrollCollection.forEach((mouseScroll) -> {
            observableList.add(mouseScroll);
        });
        return observableList;
    }

    private static TableColumn<MouseScroll, Date> getMouseScrollTimeColumn() {
        TableColumn<MouseScroll, Date> mouseScrollTimeColumn = new TableColumn<>("Time");
        mouseScrollTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        mouseScrollTimeColumn.setMinWidth(130);
        return mouseScrollTimeColumn;
    }

    private static TableColumn<MouseScroll, String> getMouseScrollDirectionColumn() {
        TableColumn<MouseScroll, String> mouseScrollDirectionColumn = new TableColumn<>("Direction");
        mouseScrollDirectionColumn.setCellValueFactory(new PropertyValueFactory<>("direction"));
        mouseScrollDirectionColumn.setMinWidth(71);
        return mouseScrollDirectionColumn;
    }

}
