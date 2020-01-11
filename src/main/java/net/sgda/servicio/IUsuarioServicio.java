package net.sgda.servicio;

import java.util.List;
import net.sgda.modelo.Usuario;

public interface IUsuarioServicio {
    
    List<Usuario> buscarTodos();
    Usuario buscarIdUsuario(Integer ID_USUARIO);
    
    void guardar(Usuario usuario);
}
