package net.sgda.controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.sgda.util.Utileria;

import net.sgda.modelo.Usuario;
import net.sgda.servicio.IUsuarioServicio;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioControlador {
    
    private String Listar = "sgda/usuario/listar";
    private String Formulario = "sgda/usuario/crear";
    private String Editar = "sgda/usuario/editar";
    private String Detalle = "sgda/usuario/detalle";
    private String Eliminar = "sgda/usuario/eliminar";
    private String Mensaje;
    	
    //Metodos de ServicioImpl
    @Autowired
    private IUsuarioServicio servicioUsuario;
    
    //@RequestMapping(value = "/listar", method=RequestMethod.GET)
    @GetMapping("/listar")
    public String ListarUsuario(Model model){
        model.addAttribute("titulo","Listar Usuario");
        model.addAttribute("link","/usuario/listar");
        //List<Usuario> lista = getUsuarios();
        List<Usuario> lista = servicioUsuario.buscarTodos();
        model.addAttribute("usuarios",lista);
        return Listar;
    }
    
    //@RequestMapping(value = "/crear", method=RequestMethod.GET)
    @GetMapping("/crear")
    public String CrearUsuario(Model model){
        model.addAttribute("titulo","Crear Usuario");
        model.addAttribute("link","/usuario/crear");
        
        model.addAttribute("usuario", new Usuario());
        
        return Formulario;
    }
    
    //@GetMapping("/guardar")
    //@RequestMapping(value = "/guardar", method=RequestMethod.POST)
    @PostMapping("/guardar")   
    public String GuardarUsuario(Usuario usuario,BindingResult result/*,Model model*/,RedirectAttributes attributes){
        Mensaje="Usuario Guardado Exitosamente";
        
        //Configurar de String a Date
        if (result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio Un Error:"+error.getDefaultMessage());
            }
            return Formulario;
        }
        servicioUsuario.guardar(usuario);
        System.out.println("Usuarios:"+usuario);
                attributes
                .addFlashAttribute("msg", Mensaje)
                .addFlashAttribute("tag", "alert alert-success alert-dismissible");
        //attributes.addFlashAttribute("msg", Mensaje);
        return "redirect:/usuario/listar";
    }
    
    @PostMapping("/archivo")
    public String ArchivoUsuario(
            @ModelAttribute("usuario") Usuario usuario, 
            BindingResult result, 
            RedirectAttributes attributes, 
            @RequestParam("IMAGEN") MultipartFile multipart){
        System.out.println("Archivo:"+multipart);
        Mensaje="Usuario Guardado Exitosamente";
        //Configurar de String a Date
        if (result.hasErrors()) {
            for(ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio Un Error:"+error.getDefaultMessage());
            }
            return Formulario;
        }
        
        if (!multipart.isEmpty()) {
            //String ruta = "/Desarrollo/Java/proyectosgda/src/main/resourcesL/static/img"; //Linux
            //String ruta = "d:/Desarrollo/Java/proyectosgda/src/main/resourcesL/static/img/"; //Windows
            String ruta = "c:/proyectosgda/img/";
            String nombreImagen = Utileria.guardarArchivo(multipart,ruta);
            if (nombreImagen != null) { //Se Subio la Imagem
                usuario.setIMAGEN(nombreImagen);
            }
        }
        
        //servicioUsuario.guardar(usuario);
        System.out.println("Usuarios:"+usuario);
                attributes
                .addFlashAttribute("msg", Mensaje)
                .addFlashAttribute("tag", "alert alert-success alert-dismissible");
        //attributes.addFlashAttribute("msg", Mensaje);
        return "redirect:/usuario/listar";
    }
    
    
    @PostMapping("/archivo1")
    public String Archivo1(@ModelAttribute("usuario") 
            Usuario usuario, 
            BindingResult result, 
            RedirectAttributes attributes, 
            @RequestParam("IMAGEN") MultipartFile multipart) throws IOException {
        
        if (multipart == null || multipart.isEmpty()) {
            attributes.addFlashAttribute("msg", "Por favor Seleccione un Archivo");
            return "redirect:/usuario/crear";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(System.getProperty("user.home"));
        builder.append(File.separator);
        builder.append("spring_imagen_ejemplo");
        builder.append(File.separator);
        builder.append(multipart.getOriginalFilename());

        byte[] fileBytes = multipart.getBytes();
        Path path = Paths.get(builder.toString());
        Files.write(path, fileBytes);
        attributes.addFlashAttribute("msg", "Archivo Subido [" + builder.toString() + "]");
        return "redirect:/usuario/crear";
    }
    
    
    //@RequestMapping(value = "/eliminar/{ID}", method=RequestMethod.POST)
    @GetMapping("/eliminar/{ID}")
    public String EliminarUsuario(@PathVariable("ID") int ID_USUARIO, Model model){
        model.addAttribute("titulo","Eliminar Usuario");
        model.addAttribute("link","/usuario/eliminar");
        
        model.addAttribute("ID_USUARIO",ID_USUARIO);
        System.out.println("ID PathVariable: " + ID_USUARIO);
        return Eliminar;
    }
    
    //@RequestMapping(value = "usuario/detalle/{ID}", method=RequestMethod.POST)
    @GetMapping("/detalle/{ID}")
    public String DetalleUsuario(@PathVariable("ID") Integer ID_USUARIO, Model model){
        model.addAttribute("titulo","Detalle Usuario");
        model.addAttribute("link","/usuario/detalle"+ID_USUARIO);
        
        Usuario usuario = servicioUsuario.buscarIdUsuario(ID_USUARIO);
        
        System.out.println("ID PathVariable: " + ID_USUARIO);
        model.addAttribute("usuario", usuario);
        return Detalle;
    }
    
    @GetMapping("/editar/{ID}")
    public String EditarUsuario(@PathVariable("ID") int ID_USUARIO,Model model){
        model.addAttribute("titulo","Editar Usuario");
        model.addAttribute("link","/usuario/editar/"+ID_USUARIO);
        
        Usuario usuario = servicioUsuario.buscarIdUsuario(ID_USUARIO);
        model.addAttribute("usuario", usuario);
        
        System.out.println("PathVariable ID:"+ID_USUARIO);
        return Formulario;
    }
    
    //@RequestMapping(value = "/modificar", method=RequestMethod.POST)
    //RequestParam
    @PostMapping("/modificar")
    public String ModificarUsuario(@RequestParam("ID") int ID_USUARIO, Model model){
        model.addAttribute("titulo"," Modificar Usuario");
        //model.addAttribute("link","/usuario/modificar");
        model.addAttribute("link","/usuario/listar");
        
        Usuario usuario = servicioUsuario.buscarIdUsuario(ID_USUARIO);

        System.out.println("ID PathVariable: " + ID_USUARIO);
        model.addAttribute("usuario", usuario);
        return Editar;
    }
    
    
    /*
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
    }*/
    
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
    
    
    
    
    
    
    
    
    
        
    //*/Lockscreen
    @GetMapping("/perfil")
    public String PerfilUsuario(Model model){
        model.addAttribute("titulo","Perfil Usuario");
        model.addAttribute("link","/usuario/perfil");
        return "sgda/usuario/perfil";
    }
    
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));
    }
        /*
    @GetMapping("/listar")
    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    @GetMapping("/guardar")
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    REST FULL WEBSERVICE
    @GetMapping("/eliminar")
    @RequestMapping(value = "/eliminar",method = RequestMethod.DELETE)
    @GetMapping("/actualizar")
    @RequestMapping(value = "/actualizar",method = RequestMethod.PUT)
    */
}
