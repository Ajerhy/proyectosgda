package net.sgda.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sgda.modelo.Usuario;
import net.sgda.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioControlador {
    
    //Metodos de ServicioImpl
    @Autowired
    private IUsuarioServicio servicioUsuario;
    
    //@GetMapping("usuario/listar")
    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public String ListarUsuario(Model model){
        model.addAttribute("titulo","Listar Usuario");
        model.addAttribute("link","/usuario/listar");
        //List<Usuario> lista = getUsuarios();
        List<Usuario> lista = servicioUsuario.buscarTodos();
        model.addAttribute("usuarios",lista);
        return "sgda/usuario/listar";
    }
    
    //@GetMapping("usuario/crear")
    @RequestMapping(value = "/crear", method=RequestMethod.GET)
    public String CrearUsuario(Model model){
        model.addAttribute("titulo","Crear Usuario");
        model.addAttribute("link","/usuario/crear");
        return "sgda/usuario/crear";
    }
    
    //@GetMapping("usuario/guardar")
    //@RequestMapping(value = "/guardar", method=RequestMethod.POST)
    @PostMapping("/guardar")   
    public String GuardarUsuario(Usuario usuario,Model model){
        //Configurar de String a Date
        servicioUsuario.guardar(usuario);
        model.addAttribute("titulo","Listar Usuario");
        System.out.println("Usuarios:"+usuario);
        //model.addAttribute("usuario",Usuario);
        //return "sgda/usuario/detalle";
        return "sgda/usuario/listusuario";
        //return "sgda/usuario/listar";
    }
    
    
    
    
    //*/Lockscreen
    @GetMapping("/perfil")
    public String PerfilUsuario(Model model){
        model.addAttribute("titulo","Perfil Usuario");
        model.addAttribute("link","/perfil");
        return "sgda/usuario/perfil";
    }
    
    
    
    
    
    
    
    
    //@GetMapping("usuario/guardar")
    @RequestMapping(value = "/guardar1", method=RequestMethod.POST)
    //public String GuardarUsuario(){
    public String GuardarUsuario1(
            @RequestParam("USUARIO") String Usuario,@RequestParam("CLAVE") String Clave,@RequestParam("ESTADO") boolean Estado,Model model){
        
        model.addAttribute("titulo","Listar Usuario");
        System.out.println("Usuario:"+Usuario+"/n Password:"+Clave+"/n Estado:"+Estado);
        //model.addAttribute("usuario",Usuario);
        //return "sgda/usuario/detalle";
        return "sgda/usuario/listusuario";
        //return "sgda/usuario/listar";
    }
    
    //@RequestMapping(value = "usuario/eliminar/{ID}", method=RequestMethod.POST)
    @GetMapping("/eliminar")
    public String EliminarUsuario(@RequestParam("ID") int ID_USUARIO, Model model){
        model.addAttribute("titulo","Eliminar Usuario");
        model.addAttribute("link","/usuario/eliminar");
        model.addAttribute("ID_USUARIO",ID_USUARIO);
        System.out.print("ID PathVariable: " + ID_USUARIO);
        return "sgda/usuario/eliminar";
    }
    
    //@RequestMapping(value = "usuario/detalle/{ID}", method=RequestMethod.POST)
    @GetMapping("/detalle/{ID}")
    public String DetalleUsuario(@PathVariable("ID") Integer ID_USUARIO, Model model){
        model.addAttribute("titulo","Detalle Usuario");
        model.addAttribute("link","/usuario/detalle");
        
        //model.addAttribute("ID_USUARIO",ID_USUARIO);
        Usuario usuario1 = servicioUsuario.buscarIdUsuario(ID_USUARIO);
        
        System.out.print("ID PathVariable: " + ID_USUARIO);
        model.addAttribute("usuario", usuario1);
        return "sgda/usuario/detalle";
    }
    
    @GetMapping("/detalles")
    public String verDetalle(@RequestParam("ID") int ID_USUARIO, Model model){
    // Procesamiento del parámetro. Aquí, ya se hizo la conversión a String a int.
        model.addAttribute("titulo","Detalles Usuario");
        model.addAttribute("link","/usuario/detalles");
        
        //model.addAttribute("ID_USUARIO",ID_USUARIO);
        Usuario usuarioq =servicioUsuario.buscarIdUsuario(ID_USUARIO);
        
        System.out.println("RequestParam: " + ID_USUARIO);
        model.addAttribute("usuario", usuarioq);
        return "sgda/usuario/detalle";
    }
    
    @GetMapping("/prueba")
    public String pruebaUsuario(Model model){
        model.addAttribute("informacion","Detalle Usuario");
        model.addAttribute("link","/usuario/detalle");
        Usuario usuarios = new Usuario();
        
        usuarios.setUSUARIO("Pillow");
        usuarios.setCLAVE("Color");
        model.addAttribute("usuarios",usuarios);
        
        return "sgda/usuario/prueba";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
}
