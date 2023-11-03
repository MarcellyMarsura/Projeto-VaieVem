/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.vaievem.apagar;

import br.edu.fesa.vaievem.viewmodels.UsuarioViewModel;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author m.molinari.marsura
 */
public class UsuarioService {

    private List<UsuarioModel> listaUsuarioModel;

    public UsuarioService() {
        listaUsuarioModel = mockDadosBanco();
    }

    private List<UsuarioModel> mockDadosBanco() {
        List<UsuarioModel> lista = new ArrayList<>();

        lista.add(new UsuarioModel(1, "teste1", "teste1@gmail.com"));
        lista.add(new UsuarioModel(2, "teste2", "teste2@gmail.com"));
        lista.add(new UsuarioModel(3, "teste3", "teste3@gmail.com"));

        return lista;
    }

    private ObservableList<UsuarioViewModel> transformaDadosTabelaUsuario(List<UsuarioModel> listaUsuarioModel) {
        
        ObservableList<UsuarioViewModel> listaUsuarioViewModel = FXCollections.observableArrayList();
        
        for (UsuarioModel usuarioModel : listaUsuarioModel) {
            listaUsuarioViewModel.add(new UsuarioViewModel(usuarioModel));
        }

        return listaUsuarioViewModel;
    }

    public ObservableList<UsuarioViewModel> retornaDadosTabela() {
        return transformaDadosTabelaUsuario(listaUsuarioModel);
    }

    public void remover(int id) {
        //Chamar remover da dao
        listaUsuarioModel.remove(getById(id));

    }
    
    public void alterar(UsuarioModel usuario) {
        UsuarioModel usuarioModel = getById(usuario.getId());
        
        usuarioModel.setNome(usuario.getNome());
        usuarioModel.setEmail(usuario.getEmail());
    }

    public UsuarioModel getById(int id) {
        for (UsuarioModel usuario : listaUsuarioModel) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
