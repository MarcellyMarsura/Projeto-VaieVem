/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.utils;

import java.util.function.BiConsumer;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

/**
 *
 * @author m.molinari.marsura
 */
public class HelperTable {
    public static <T> void criaHyperLink(TableColumn<T, T> tableColumn, String nome, BiConsumer<T, ActionEvent> hyperlinkAction) {

        Callback<TableColumn<T, T>, TableCell<T, T>> cellFactory = (final TableColumn<T, T> param) -> {
            final TableCell<T, T> cell = new TableCell<T, T>() {
                final Hyperlink hyperlink = new Hyperlink(nome);

                @Override
                public void updateItem(T item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(hyperlink);
                    }
                }

                {
                    hyperlink.setOnAction((ActionEvent event) -> {
                        T data = getTableView().getItems().get(getIndex());
                        hyperlinkAction.accept(data, event);
                    });
                }
            };
            return cell;
        };
        tableColumn.setCellFactory(cellFactory);
    }
}
