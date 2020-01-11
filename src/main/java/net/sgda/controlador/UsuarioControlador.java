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
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
    
    //@GetMapping("usuario/guardar")
    @RequestMapping(value = "/guardar1", method=RequestMethod.POST)
    //public String GuardarUsuario(){
    public String GuardarUsuario1(
            @RequestParam("USUARIO") String Usuario,
            @RequestParam("CLAVE") String Clave,
            @RequestParam("ESTADO") boolean Estado,
            Model model){
        
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
        
        
        /*
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de Sistemas");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendenro");
        lista.add("Arquitecto");
        model.addAttribute("empleos", lista);
        */
        
        return "sgda/usuario/prueba";
    }
    
    /*
    private List<Usuario> getUsuarios(){
        List<Usuario> lista = new LinkedList<Usuario>();
        
        try {
         Usuario usuario1 = new Usuario();
         usuario1.setID_USUARIO(1);
         usuario1.setUSUARIO("ajerhy");
         usuario1.setCLAVE("alvarado 123");
         usuario1.setESTADO(true);
         usuario1.setIMAGEN("avatar1.png");
         
         Usuario usuario2 = new Usuario();
         usuario2.setID_USUARIO(2);
         usuario2.setUSUARIO("feliciano");
         usuario2.setCLAVE("pessoa 123");
         usuario2.setESTADO(false);
         
         Usuario usuario3 = new Usuario();
         usuario3.setID_USUARIO(3);
         usuario3.setUSUARIO("alejandro");
         usuario3.setCLAVE("abrego 123");
         usuario3.setESTADO(true);
         usuario3.setIMAGEN("avatar3.png");
         
         Usuario usuario4 = new Usuario();
         usuario4.setID_USUARIO(4);
         usuario4.setUSUARIO("alfresco");
         usuario4.setCLAVE("arce 123");
         usuario4.setESTADO(true);
         usuario4.setIMAGEN("avatar4.png");
         
         Usuario usuario5 = new Usuario();
         usuario5.setID_USUARIO(5);
         usuario5.setUSUARIO("gustavo");
         usuario5.setCLAVE("soto 123");
         usuario5.setESTADO(false);
         usuario5.setIMAGEN("avatar5.png");
         
         lista.add(usuario1);
         lista.add(usuario2);
         lista.add(usuario3);
         lista.add(usuario4);
         lista.add(usuario5);

         
        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return lista;
    }
    */
}
