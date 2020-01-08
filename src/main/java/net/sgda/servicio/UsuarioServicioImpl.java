/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.servicio;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import net.sgda.modelo.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{
    
    private List<Usuario> lista = null;
    
    public UsuarioServicioImpl(){
        //SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
        //(dma.parse("02/01/2020"));
        lista = new LinkedList<Usuario>();
        try {
         Usuario usuario1 = new Usuario();
         usuario1.setID_USUARIO(1);
         usuario1.setUSUARIO("ajerhy");
         usuario1.setCLAVE("alvarado 321");
         usuario1.setESTADO(true);
         usuario1.setIMAGEN("avatar1.png");
         
         Usuario usuario2 = new Usuario();
         usuario2.setID_USUARIO(2);
         usuario2.setUSUARIO("feliciano");
         usuario2.setCLAVE("pessoa 123");
         usuario2.setESTADO(false);
         
         Usuario usuario3 = new Usuario();
         usuario3.setID_USUARIO(3);
         usuario3.setUSUARIO("alejandro");
         usuario3.setCLAVE("abrego 123");
         usuario3.setESTADO(true);
         usuario3.setIMAGEN("avatar3.png");
         
         Usuario usuario4 = new Usuario();
         usuario4.setID_USUARIO(4);
         usuario4.setUSUARIO("alfresco");
         usuario4.setCLAVE("arce 123");
         usuario4.setESTADO(true);
         usuario4.setIMAGEN("avatar4.png");
         
         Usuario usuario5 = new Usuario();
         usuario5.setID_USUARIO(5);
         usuario5.setUSUARIO("gustavo");
         usuario5.setCLAVE("soto 654");
         usuario5.setESTADO(false);
         usuario5.setIMAGEN("avatar5.png");
         
         lista.add(usuario1);
         lista.add(usuario2);
         lista.add(usuario3);
         lista.add(usuario4);
         lista.add(usuario5);

        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
        }
    }

    @Override
    public List<Usuario> buscarTodos() {
        return lista;
    }

    @Override
    public Usuario buscarIdUsuario(Integer ID_USUARIO) {
        for (Usuario u: lista) {
            if(u.getID_USUARIO()==ID_USUARIO){
                return u;
            }
        }
        return null;
    }
    
}
