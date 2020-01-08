/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.controller;

import java.util.LinkedList;
import java.util.List;
import net.sgda.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Hp
 */
@Controller
public class UsuarioController {
    //*/index
    @GetMapping("/")
    public String Login(Model model){
        model.addAttribute("titulo","Login SGDA");
        model.addAttribute("link","/");
        return "sgda/usuario/login";
    }
    
    //*/index
    @GetMapping("/dashboard")
    public String Dashboard(Model model){
        model.addAttribute("titulo","Dashboard");
        model.addAttribute("link","/dashboard");
        return "sgda/dashboard/dashboard";
    }
    
    
    @GetMapping("usuario/listar")
    public String ListarUsuario(Model model){
        model.addAttribute("titulo","Listar Usuario");
        model.addAttribute("link","/usuario/listar");
        List<Usuario> lista = getUsuarios();
        model.addAttribute("usuarios",lista);
        return "sgda/usuario/listar";
    }
    
    @GetMapping("usuario/detalle")
    public String detalleUsuario(Model model){
        model.addAttribute("informacion","Detalle Usuario");
        model.addAttribute("link","/usuario/detalle");
        Usuario usuarios = new Usuario();
        
        usuarios.setUSUARIO("Pillow");
        usuarios.setCLAVE("Color");
        model.addAttribute("usuarios",usuarios);
        
        
        /*
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendenro");
        lista.add("Arquitecto");
        model.addAttribute("empleos", lista);
        */
        
        return "sgda/usuario/detalle";
    }
    
    private List<Usuario> getUsuarios(){
        List<Usuario> lista = new LinkedList<Usuario>();
        
        try {
         Usuario usuario1 = new Usuario();
         usuario1.setID_USUARIO(1);
         usuario1.setUSUARIO("ajerhy");
         usuario1.setCLAVE("alvarado 123");
         
         Usuario usuario2 = new Usuario();
         usuario2.setID_USUARIO(2);
         usuario2.setUSUARIO("feliciano");
         usuario2.setCLAVE("pessoa 123");
         
         Usuario usuario3 = new Usuario();
         usuario3.setID_USUARIO(3);
         usuario3.setUSUARIO("alejandro");
         usuario3.setCLAVE("abrego 123");
         
         
         lista.add(usuario1);
         lista.add(usuario2);
         lista.add(usuario3);
         
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return lista;
    }
    
    
}
