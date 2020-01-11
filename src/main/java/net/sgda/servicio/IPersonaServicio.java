package net.sgda.servicio;

import java.util.List;
import net.sgda.modelo.Persona;

public interface IPersonaServicio {
    
    List<Persona> buscarTodos();
    Persona buscarIdPersona(Integer ID_PERSONA);
    Persona buscarCiPersona(Integer CI);
    
    void guardar(Persona persona);
}
