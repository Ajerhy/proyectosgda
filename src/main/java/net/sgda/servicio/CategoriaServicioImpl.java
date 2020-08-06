/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.servicio;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import net.sgda.modelo.Categoria;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer
 */
@Service
public class CategoriaServicioImpl implements ICategoriaServicio{
    
    private List<Categoria> lista = null;
    
    public CategoriaServicioImpl(){
        SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
        //(dma.parse("02/01/2020"));
        lista = new LinkedList<Categoria>();
        try {
         Categoria categoria1 = new Categoria();
         categoria1.setID_CATEGORIA(1);
         categoria1.setNOMBRE("Django");
         categoria1.setSIGLA("Python");
         categoria1.setESTADO(true);
         categoria1.setREGISTRO(dma.parse("01/01/2021"));
         
         
         Categoria categoria2 = new Categoria();
         categoria2.setID_CATEGORIA(2);
         categoria2.setNOMBRE("Spring Boot");
         categoria2.setSIGLA("Java");
         categoria2.setESTADO(true);
         categoria2.setREGISTRO(dma.parse("01/01/2021"));
         
         Categoria categoria3 = new Categoria();
         categoria3.setID_CATEGORIA(3);
         categoria3.setNOMBRE("Laravel");
         categoria3.setSIGLA("Php");
         categoria3.setESTADO(true);
         categoria3.setREGISTRO(dma.parse("01/01/2022"));
         
         Categoria categoria4 = new Categoria();
         categoria4.setID_CATEGORIA(4);
         categoria4.setNOMBRE("Kotlin");
         categoria4.setSIGLA("JavaScript");
         categoria4.setESTADO(true);
         categoria4.setREGISTRO(dma.parse("01/01/2023"));
         
         Categoria categoria5 = new Categoria();
         categoria5.setID_CATEGORIA(5);
         categoria5.setNOMBRE("Spring");
         categoria5.setSIGLA("Java");
         categoria5.setESTADO(false);
         categoria5.setREGISTRO(dma.parse("01/01/2024"));
         
         lista.add(categoria1);
         lista.add(categoria2);
         lista.add(categoria3);
         lista.add(categoria4);
         lista.add(categoria5);

        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
        }
    }
    
    @Override
    public List<Categoria> buscarTodos() {
        return lista;
    }
    
    @Override
    public Categoria buscarIdCategoria(Integer ID_CATEGORIA) {
        for (Categoria c: lista){
            if(c.getID_CATEGORIA()==ID_CATEGORIA){
                return c;
            }
        }
        return null;
    }
    
    @Override
    public void guardar(Categoria categoria) {
        lista.add(categoria);
    }
    
}
