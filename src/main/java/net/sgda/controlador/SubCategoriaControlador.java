
package net.sgda.controlador;

import java.util.List;
import net.sgda.modelo.Categoria;
import net.sgda.modelo.SubCategoria;
import net.sgda.servicio.ICategoriaServicio;
import net.sgda.servicio.ISubCategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value = "/sub/categoria")
public class SubCategoriaControlador {
    private String Listar = "sgda/subcategoria/listar";
    private String Formulario = "sgda/subcategoria/crear";
    private String Detalle = "sgda/subcategoria/detalle";
    private String Eliminar = "sgda/subcategoria/eliminar";
    private String Mensaje;
    
    @Autowired
    private ISubCategoriaServicio servicioSubCategoria;
    
    @Autowired
    private ICategoriaServicio servicioCategoria;
    
    
    
    //@RequestMapping(value = "/listar",method = RequestMethod.GET)
    @GetMapping("/listar")
    public String ListarSubCategoria(Model model){
        model.addAttribute("titulo","Listar Sub Categoria");
        model.addAttribute("link","/sub/categoria/listar");
        
        List<SubCategoria> lista = servicioSubCategoria.buscarTodos();
        model.addAttribute("subcategorias",lista);
        
        return Listar;
    }
    
    //@RequestMapping(value = "/crear",method = RequestMethod.GET)
    @GetMapping("/crear")
    public String CrearSubCategoria(Model model){
        model.addAttribute("titulo","Crear Sub Categoria");
        model.addAttribute("link","/sub/categoria/crear");
        
        model.addAttribute("subcategoria", new SubCategoria());
        
        model.addAttribute("categorias",servicioCategoria.buscarTodos());
        return Formulario;
    }
    
    @PostMapping("/guardar")
    public String GuardarCategoria(@ModelAttribute SubCategoria subCategoria,BindingResult result,RedirectAttributes attributes){
        /*,Model model*/
        Mensaje="Sub Categoria Guardado Exitosamente";
        /*
        if (result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio Un Error:"+error.getDefaultMessage());
            }
            return Formulario;
        }
        servicioSubCategoria.guardar(subCategoria);
        */System.out.println("Sub Categorias:"+subCategoria);
                attributes
                .addFlashAttribute("msg", Mensaje)
                .addFlashAttribute("tag", "alert alert-success alert-dismissible");
        //attributes.addFlashAttribute("msg", Mensaje);
        
        return "redirect:/sub/categoria/listar";
    }
}
