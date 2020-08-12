
package net.sgda.controlador;

import java.util.Date;
import java.util.List;
import net.sgda.modelo.Categoria;
import net.sgda.servicio.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaControlador {
    
    private String Listar = "sgda/categoria/listar";
    private String Formulario = "sgda/categoria/crear";
    private String Detalle = "sgda/categoria/detalle";
    private String Eliminar = "sgda/categoria/eliminar";
    private String Mensaje;
    
    @Autowired
    private ICategoriaServicio servicioCategoria;
    
    
    
    //@GetMapping("/listar")
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String ListarCategoria(Model model){
        model.addAttribute("titulo","Listar Categoria");
        model.addAttribute("link","/categoria/listar");
        
        List<Categoria> lista = servicioCategoria.buscarTodos();
        model.addAttribute("categorias",lista);
        
        return Listar;
    }
    
    //@GetMapping("/crear")
    @RequestMapping(value = "/crear",method = RequestMethod.GET)
    public String CrearCategoria(Model model){
        model.addAttribute("titulo","Crear Categoria");
        model.addAttribute("link","/categoria/crear");
        
        model.addAttribute("categoria", new Categoria());
        
        return Formulario;
    }
    
    //@GetMapping("/guardar")
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String GuardarCategoria(@ModelAttribute Categoria categoria,BindingResult result,RedirectAttributes attributes){
        /*,Model model*/
        Mensaje="Categoria Guardado Exitosamente";
        if (result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio Un Error:"+error.getDefaultMessage());
            }
            return Formulario;
        }
        servicioCategoria.guardar(categoria);
        System.out.println("Categorias:"+categoria);
        attributes
                .addFlashAttribute("msg", Mensaje)
                .addFlashAttribute("tag", "alert alert-success alert-dismissible");
        //attributes.addFlashAttribute("msg", Mensaje);
        return "redirect:/categoria/listar";
    }

    @GetMapping("/detalle/{ID}")
    public String DetalleCategoria(
            @PathVariable("ID")int ID_CATEGORIA,
            Model model){
        model.addAttribute("titulo","Detalle Categoria");
        model.addAttribute("link","/categoria/detalle/"+ID_CATEGORIA);
        
        Categoria categoria = servicioCategoria.buscarIdCategoria(ID_CATEGORIA);
        model.addAttribute("categoria", categoria);
        
        System.out.println("PathVariable ID:"+ID_CATEGORIA);
        model.addAttribute("idCategoria",ID_CATEGORIA);
        return Detalle;
    }
    
    @GetMapping("/detalle/{id}/{fecha}")
    public String DetalleCategoriaFecha(
            @PathVariable("id") int idCategoria,
            @PathVariable("fecha") Date fecha,
            Model model){
        
        model.addAttribute("titulo","Detalle Categoria");
        model.addAttribute("link","/categoria/detalle/"+idCategoria+"/"+fecha);
        
        System.out.println("PathVariable ID:"+idCategoria);
        model.addAttribute("id",idCategoria);
        System.out.println("PathVariable FECHA:"+fecha);
        model.addAttribute("fecha",fecha);
        return Detalle;
    }
    
    
    
    @GetMapping("/eliminar/{id}")
    public String EliminarCategoria(
            @PathVariable("id")int idCategoria,
            Model model){
        model.addAttribute("titulo","Eliminar Categoria");
        model.addAttribute("link","/categoria/eliminar/"+idCategoria);
        
        Categoria categoria = servicioCategoria.buscarIdCategoria(idCategoria);
        model.addAttribute("categoria", categoria);
        
        System.out.println("PathVariable ID:"+idCategoria);
        model.addAttribute("idCategoria",idCategoria);
        return Eliminar;
    }
      
    
    
    @GetMapping("/editar/{id}")
    public String EditarCategoria(
            @PathVariable("id")int idCategoria,
            Model model){
        model.addAttribute("titulo","Editar Categoria");
        model.addAttribute("link","/categoria/editar/"+idCategoria);
        
        Categoria categoria = servicioCategoria.buscarIdCategoria(idCategoria);
        model.addAttribute("categoria", categoria);
        
        System.out.println("PathVariable ID:"+idCategoria);
        model.addAttribute("idCategoria",idCategoria);
        return Formulario;
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
