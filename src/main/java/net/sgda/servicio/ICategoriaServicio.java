/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.servicio;

import java.util.List;
import net.sgda.modelo.Categoria;

/**
 *
 * @author Acer
 */
public interface ICategoriaServicio {
        
    List<Categoria> buscarTodos();
    Categoria buscarIdCategoria(Integer ID_CATEGORIA);
    
    void guardar(Categoria categoria);
    
}
