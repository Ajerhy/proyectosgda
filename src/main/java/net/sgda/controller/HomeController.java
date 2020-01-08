package net.sgda.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    
    @GetMapping("/listado")
    public String mostrarLista(Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendenro");
        lista.add("Arquitecto");
        model.addAttribute("empleos", lista);
        return "listar";
    }
    
    @GetMapping("/prueba")
    public String mostrarHome(Model model){
        model.addAttribute("home","Home SGDA");
        /*
        model.addAttribute("xx","hola desde thymeleaf");
        model.addAttribute("fecha",new Date());
        */
        
        String nombre = "Auxiliar Contable";
        Date fechaP = new Date();
        double salario =9000.0;
        boolean vigente = true;
        
        model.addAttribute("nombre",nombre);
        model.addAttribute("fecha",fechaP);
        model.addAttribute("salario",salario);
        model.addAttribute("vigente",vigente);
        return "home";
    }
}
