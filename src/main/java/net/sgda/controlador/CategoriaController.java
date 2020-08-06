
package net.sgda.controlador;

import java.util.Date;
import java.util.List;
import net.sgda.modelo.Categoria;
import net.sgda.servicio.ICategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
        
        return Formulario;
    }
    
    //@GetMapping("/guardar")
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String GuardarCategoria(Categoria categoria,Model model){
        Mensaje="Categoria Guardado Exitosamente";
        model.addAttribute("titulo","Listar Categoria");
        model.addAttribute("link","/categoria/listar");
        model.addAttribute("mesaje",Mensaje);
        
        servicioCategoria.guardar(categoria);
        System.out.println("Categorias:"+categoria);
        
        ///
        List<Categoria> lista = servicioCategoria.buscarTodos();
        model.addAttribute("categorias",lista);
        //
        return Listar;
    }

    @GetMapping("/detalle/{id}")
    public String DetalleCategoria(
            @PathVariable("id")int idCategoria,
            Model model){
        model.addAttribute("titulo","Detalle Categoria");
        model.addAttribute("link","/categoria/detalle/"+idCategoria);
        
        Categoria categoria = servicioCategoria.buscarIdCategoria(idCategoria);
        model.addAttribute("categoria", categoria);
        
        System.out.println("PathVariable ID:"+idCategoria);
        model.addAttribute("idCategoria",idCategoria);
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
