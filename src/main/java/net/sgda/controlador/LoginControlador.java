package net.sgda.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "")
public class LoginControlador {
    
    private String Login = "sgda/login/login";
    private String Registrarse = "sgda/login/registrarse";
    private String Dashboard = "sgda/dashboard/dashboard";
    private String BloqueoPantalla = "sgda/login/bloqueo";
    private String Modal = "sgda/dashboard/modal";
    
    //@GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Login(Model model) {
        model.addAttribute("titulo","Login SGDA");
        model.addAttribute("link","/");
        
        return Login;
    }
    
    //@GetMapping("/registrarse")
    @RequestMapping(value = "/registrarse", method = RequestMethod.GET)
    public String Registrarse(Model model) {
        model.addAttribute("titulo", "Registrarse SGDA");
        model.addAttribute("link", "/registrarse");
        
        return Registrarse;
    }
    
    //@PostMapping("/dashboard")
    //@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String Dashboard(Model model/*,
            @RequestParam("usuario") String usuario,@RequestParam("clave") String clave,HttpServletRequest request*/) {
        model.addAttribute("titulo", "Dashboard");
        model.addAttribute("link", "/dashboard");
        /*
        System.out.println("PathVariable Usuario:" + usuario);
        model.addAttribute("usuario", usuario);
        System.out.println("PathVariable Clave:" + clave);
        model.addAttribute("clave", clave);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("inicio",usuario+""+clave);
        */
        return Dashboard;
    }
    
    //@GetMapping("/lockscreen")
    @RequestMapping(value = "/lockscreen", method = RequestMethod.GET)
    public String BloqueoPantalla(Model model){
        model.addAttribute("titulo","Pantalla Bloqueada");
        model.addAttribute("link","/lockscreen");

        return BloqueoPantalla;
    }
    
    //@GetMapping("/modal")
    @RequestMapping(value = "/modal", method = RequestMethod.GET)
    public String Modal(Model model){
        model.addAttribute("titulo","Modal");
        model.addAttribute("link","/modal");
        return Modal;
    }
    
    /*
    ///Index
    @GetMapping("/")
    public String Login(Model model){
        model.addAttribute("titulo","Login SGDA");
        model.addAttribute("link","/");
        return "sgda/login/login";
    }
    
    ///Dashboard
    @GetMapping("/dashboard")
    public String Dashboard(Model model){
        model.addAttribute("titulo","Dashboard");
        model.addAttribute("link","/dashboard");
        return "sgda/dashboard/dashboard";
    }
    
    ///Lockscreen
    @GetMapping("/lockscreen")
    public String BloqueoPantalla(Model model){
        model.addAttribute("titulo","Pantalla Bloqueada");
        model.addAttribute("link","/lockscreen");
        return "sgda/login/bloqueo";
    }    
    
    ///Lockscreen
    @GetMapping("/modal")
    public String Modal(Model model){
        model.addAttribute("titulo","Modal");
        model.addAttribute("link","/modal");
        return "sgda/dashboard/modal";
    }
    */
}
