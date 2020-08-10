
package net.sgda.controlador;

import java.util.List;
import net.sgda.modelo.Categoria;
import net.sgda.servicio.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/sub/categoria")
public class SubCategoriaController {
    private String Listar = "sgda/subcategoria/listar";
    private String Formulario = "sgda/subcategoria/crear";
    private String Detalle = "sgda/subcategoria/detalle";
    private String Eliminar = "sgda/subcategoria/eliminar";
    private String Mensaje;
    
        @Autowired
    private ICategoriaServicio servicioCategoria;
    
    //@RequestMapping(value = "/listar",method = RequestMethod.GET)
    @GetMapping("/listar")
    public String ListarSubCategoria(Model model){
        model.addAttribute("titulo","Listar Sub Categoria");
        model.addAttribute("link","/sub/categoria/listar");
        
        List<Categoria> lista = servicioCategoria.buscarTodos();
        model.addAttribute("categorias",lista);
        
        return Listar;
    }
    
    //@RequestMapping(value = "/crear",method = RequestMethod.GET)
    @GetMapping("/crear")
    public String CrearSubCategoria(Model model){
        model.addAttribute("titulo","Crear Sub Categoria");
        model.addAttribute("link","/sub/categoria/crear");
        
        return Formulario;
    }
    
    @PostMapping("/guardar")
    public String GuardarCategoria(Categoria categoria,BindingResult result/*,Model model*/,RedirectAttributes attributes){
        Mensaje="Sub Categoria Guardado Exitosamente";
        //model.addAttribute("titulo","Listar Sub Categoria");
        //model.addAttribute("link","/sub/categoria/listar");
        //model.addAttribute("mesaje",Mensaje);
        if (result.hasErrors()) {
            return Formulario;
        }
        servicioCategoria.guardar(categoria);
        System.out.println("Categorias:"+categoria);
        attributes.addFlashAttribute("msg", Mensaje);
        
        return "redirect:/sub/categoria/listar";
    }
}
