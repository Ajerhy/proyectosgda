package net.sgda.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import net.sgda.modelo.Persona;
import net.sgda.servicio.IPersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/persona")
public class PersonaControlador {
    
    private String Listar = "sgda/persona/listar";
    private String Formulario = "sgda/persona/crear";
    private String Editar = "sgda/persona/editar";
    private String Eliminar = "sgda/persona/eliminar";
    private String Detalle = "sgda/persona/detalle";
    private String Mensaje;
    
    @Autowired
    private IPersonaServicio servicioPersona;
    
    //@RequestMapping(value = "/listar", method=RequestMethod.GET)
    @GetMapping("/listar")
    public String ListarPersona(Model model){
        model.addAttribute("titulo","Listar Persona");
        model.addAttribute("link","/persona/listar");
        
        List<Persona> lista = servicioPersona.buscarTodos();
        model.addAttribute("personas",lista);
        return Listar;
    }
    
    //@RequestMapping(value = "/crear", method=RequestMethod.GET)
    @GetMapping("/crear")
    public String CrearPersona(Model model){
        model.addAttribute("titulo","Crear Persona");
        model.addAttribute("link","/persona/crear");
        
        model.addAttribute("persona", new Persona());
        
        return Formulario;
    }
    
    //@PostMapping("/guardar")
    @RequestMapping(value="/guardar", method=RequestMethod.POST)
    public String GuardarPersona(@ModelAttribute Persona persona,BindingResult result,RedirectAttributes attributes){
        /*@Valid, Model model,*/
        Mensaje="Usuario Guardado Exitosamente";
        
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio Un Error:"+error.getDefaultMessage());
            }
            return Formulario;
        }
        //Configurar de String a Date
        servicioPersona.guardar(persona);
        System.out.println("Usuarios:"+persona);
        
        attributes
                .addFlashAttribute("msg", Mensaje)
                .addFlashAttribute("tag", "alert alert-success alert-dismissible");
        //attributes.addFlashAttribute("msg", Mensaje);
        return "redirect:/persona/listar";
    }
    
    @GetMapping("/detalle/{ID}")
    public String DetallePersona(@PathVariable("ID") int ID_PERSONA, Model model) {
        Persona persona = servicioPersona.buscarIdPersona(ID_PERSONA);
        System.out.println("Detalle Persona: " + persona);
        model.addAttribute("titulo","Detalle Persona");
        model.addAttribute("link","/persona/detalle/"+ID_PERSONA);
        
        model.addAttribute("persona", persona);
        return Detalle;
    }
    
    @GetMapping("/eliminar/{ID}")
    public String EliminarPersona(@PathVariable("ID") int ID_PERSONA, Model model) {
        System.out.println("Borrando Persona con ID: " + ID_PERSONA);
        model.addAttribute("titulo","Eliminar Persona");
        model.addAttribute("link","/persona/eliminar/"+ID_PERSONA);
        
        model.addAttribute("ID", ID_PERSONA);
        return Eliminar;
    }
    //@RequestParam("ID")
    
    
    @GetMapping("/editar/{ID}")
    public String EditarPersona(@PathVariable("ID") int ID_PERSONA, Model model) {
        model.addAttribute("titulo","Editar Persona");
        model.addAttribute("link","/persona/detalle/"+ID_PERSONA);
        
        Persona persona = servicioPersona.buscarIdPersona(ID_PERSONA);
        
        System.out.println("Editar Persona: " + persona);
        model.addAttribute("persona", persona);
        return Formulario;
    }
    

    
    
    
    //@RequestMapping(value = "/modificar", method=RequestMethod.POST)
    //RequestParam
    @PostMapping("/modificar")
    public String ModificarUsuario(@RequestParam("ID") int ID_PERSONA, Model model){
        model.addAttribute("titulo"," Modificar Usuario");
        //model.addAttribute("link","/persona/modificar");
        model.addAttribute("link","/persona/listar");
        
        Persona persona = servicioPersona.buscarIdPersona(ID_PERSONA);

        System.out.println("ID PathVariable: " + ID_PERSONA);
        model.addAttribute("persona", persona);
        return Editar;
    }
    
    @PostMapping("/editar")
    public String actualizarPersona(@ModelAttribute Persona persona, RedirectAttributes attributes) {
        /*@Valid, Model model,*/
        Mensaje="Usuario Actualizado Exitosamente";
        //productosRepository.save(producto);
        attributes
                .addFlashAttribute("msg", Mensaje)
                .addFlashAttribute("tag", "alert alert-info alert-dismissible");
        return "redirect:/persona/listar";
    }
    
    
    
    
    
    @RequestMapping(value = "/modalpersona", method=RequestMethod.GET)
    public String ModalPersona(Model model){
        model.addAttribute("titulo","Modal Persona");
        model.addAttribute("link","/persona/form");
        return "sgda/persona/form";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
}
