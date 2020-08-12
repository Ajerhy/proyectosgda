/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.servicio;

import java.util.List;
import net.sgda.modelo.SubCategoria;

/**
 *
 * @author Acer
 */
public interface ISubCategoriaServicio {

    List<SubCategoria> buscarTodos();

    SubCategoria buscarIdCategoria(Integer ID_SUBCATEGORIA);

    void guardar(SubCategoria subcategoria);
}
