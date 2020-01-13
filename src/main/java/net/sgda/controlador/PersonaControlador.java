package net.sgda.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/persona")
public class PersonaControlador {
    
    @Autowired
    private IPersonaServicio servicioPersona;
    
    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public String ListarPersona(Model model){
        model.addAttribute("titulo","Listar Persona");
        model.addAttribute("link","/persona/listar");
        List<Persona> lista = servicioPersona.buscarTodos();
        model.addAttribute("personas",lista);
        return "sgda/persona/listar";
    }
    
    @RequestMapping(value = "/crear", method=RequestMethod.GET)
    public String CrearPersona(Model model){
        model.addAttribute("titulo","Crear Persona");
        model.addAttribute("link","/persona/crear");
        return "sgda/persona/crear";
    }
    
    @PostMapping("/guardar")   
    public String GuardarPersona(Persona persona,BindingResult result,Model model){
        model.addAttribute("titulo","Listar Persona");
        
        if(result.hasErrors()){
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio Un Error:"+error.getDefaultMessage());
            }
            return "sgda/persona/crear";
        }
        //Configurar de String a Date
        servicioPersona.guardar(persona);
        System.out.println("Usuarios:"+persona);
        return "sgda/persona/listpersona";
        //return "sgda/usuario/listar";
    }
    
    @GetMapping("/detalle/{id}")
    public String DetallePersona(@PathVariable("ID") int ID_PERSONA, Model model) {
        Persona persona = servicioPersona.buscarIdPersona(ID_PERSONA);
        System.out.println("Vacante: " + persona);
        model.addAttribute("titulo","Detalle Persona");
        model.addAttribute("persona", persona);
        return "sgda/persona/detalle";
    }
    
    @GetMapping("/eliminar")
    public String EliminarPersona(@RequestParam("ID") int ID_PERSONA, Model model) {
        System.out.println("Borrando Persona con ID: " + ID_PERSONA);
        model.addAttribute("titulo","Eliminar Persona");
        model.addAttribute("ID", ID_PERSONA);
        return "sgda/persona/eliminar";
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
