
package net.sgda.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {
    
    private String Listar = "sgda/categoria/listar";
    private String Formulario = "sgda/categoria/crear";
    private String Detalle = "sgda/categoria/detalle";
    
    
    //@GetMapping("/listar")
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String ListarCategoria(Model model){
        model.addAttribute("titulo","Listar Categoria");
        model.addAttribute("link","/categoria/listar");
        return Listar;
    }
    
    //@GetMapping("/crear")
    @RequestMapping(value = "/crear",method = RequestMethod.GET)
    public String CrearCategoria(Model model){
        model.addAttribute("titulo","Crear Categoria");
        model.addAttribute("link","/categoria/crear");
        
        return Formulario;
    }
    
    //@GetMapping("/guardar")
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String GuardarCategoria(Model model){
        return Listar;
    }

    @GetMapping("/detalle/{id}")
    public String DetalleCategoria(@PathVariable("id")int idCategoria){
        System.out.println("PathVariable:"+idCategoria);
        return Detalle;
    }
        
        
    /*    
    //@GetMapping("/eliminar")
    @RequestMapping(value = "/eliminar",method = RequestMethod.DELETE)
        public String EliminarCategoria(Model model){
        return "";
    }
    
    //@GetMapping("/actualizar")
    @RequestMapping(value = "/actualizar",method = RequestMethod.PUT)
        public String ActualizarCategoria(Model model){
        return "";
    }
    */
    
}
