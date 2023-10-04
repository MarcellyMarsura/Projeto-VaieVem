/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem;

import br.edu.fesa.vaievem.viewmodels.UsuarioViewModel;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;

/**
 *
 * @author m.molinari.marsura
 */
public class HelperController<T> {
    
    public TableCell<T, String> HyperlinkExcluir(TableView<T> tabela){
        TableCell<T, String> cell = new TableCell<T, String>() {
                final Hyperlink deleteButton = new Hyperlink("Excluir");

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(deleteButton);
                        deleteButton.setOnAction(event -> {
                            T model = getTableView().getItems().get(getIndex());
                            tabela.getItems().remove(model);
                        });
                    }
                }
            };

            return cell;
    }
}
