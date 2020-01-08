/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {

    //*/index
    @GetMapping("/")
    public String Login(Model model){
        model.addAttribute("titulo","Login SGDA");
        model.addAttribute("link","/");
        return "sgda/usuario/login";
    }
    
    //*/dashboard
    @GetMapping("/dashboard")
    public String Dashboard(Model model){
        model.addAttribute("titulo","Dashboard");
        model.addAttribute("link","/dashboard");
        return "sgda/dashboard/dashboard";
    }
    
}
