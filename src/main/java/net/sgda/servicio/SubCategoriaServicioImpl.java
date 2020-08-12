/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.servicio;

import java.util.List;
import net.sgda.modelo.SubCategoria;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class SubCategoriaServicioImpl implements ISubCategoriaServicio{
    
    private List<SubCategoria> lista = null;
    
    @Override
    public List<SubCategoria> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubCategoria buscarIdCategoria(Integer ID_SUBCATEGORIA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar(SubCategoria subcategoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
