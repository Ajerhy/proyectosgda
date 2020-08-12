/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.servicio;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
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
    public SubCategoriaServicioImpl(){
        SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
        //(dma.parse("02/01/2020"));
        lista = new LinkedList<SubCategoria>();
        
        try {
           SubCategoria SC1 = new SubCategoria();
            SC1.setId_subcategoria(1);
            //SC1.setCategoria(1);
            //SC1.setCategoria(Categoria(1));
            SC1.setNombre("Libreria");
            SC1.setEstado(true);
            SC1.setRegistro(dma.parse("01/01/2023"));
            
            SubCategoria SC2 = new SubCategoria();
            SC2.setId_subcategoria(3);
            //SC2.setCategoria();
            //SC2.setCategoria(Categoria(2));
            SC2.setNombre("Framework");
            SC2.setEstado(false);
            SC2.setRegistro(dma.parse("01/01/2022"));
            
            lista.add(SC1);
            lista.add(SC2);
            
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
        }
    }
    
    @Override
    public List<SubCategoria> buscarTodos() {
        return lista;
    }

    @Override
    public SubCategoria buscarIdCategoria(Integer ID_SUBCATEGORIA) {
        for (SubCategoria c: lista){
            if(c.getId_subcategoria()==ID_SUBCATEGORIA){
                return c;
            }
        }
        return null;
    }

    @Override
    public void guardar(SubCategoria subcategoria) {
        lista.add(subcategoria);
    }
    
}
