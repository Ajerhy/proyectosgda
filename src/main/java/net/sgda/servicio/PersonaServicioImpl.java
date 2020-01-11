package net.sgda.servicio;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import net.sgda.modelo.Persona;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicioImpl implements IPersonaServicio{
    
    private List<Persona> lista = null;

    public PersonaServicioImpl() {
        SimpleDateFormat dma = new SimpleDateFormat("dd/MM/yyyy");
        lista = new LinkedList<Persona>();
        
        try {
         Persona persona1 = new Persona();
         persona1.setID_PERSONA(1);
         persona1.setNOMBRE("Perry");
         persona1.setPATERNO("Casa");
         persona1.setMATERNO("Lora");
         persona1.setCI(98760);
         persona1.setSEXO(true);
         persona1.setNACIMIENTO(dma.parse("01/01/2020"));
         persona1.setESTADO(true);
         
         Persona persona2 = new Persona();
         persona2.setID_PERSONA(2);
         persona2.setNOMBRE("Prisila");
         persona2.setPATERNO("Salas");
         persona2.setMATERNO("Nora");
         persona2.setCI(54321);
         persona2.setSEXO(false);
         persona2.setNACIMIENTO(dma.parse("01/01/2000"));
         persona2.setESTADO(false);
        
         Persona persona3 = new Persona();
         persona3.setID_PERSONA(3);
         persona3.setNOMBRE("Fenifer");
         persona3.setPATERNO("Flores");
         persona3.setMATERNO("Nakashima");
         persona3.setCI(12345);
         persona3.setSEXO(false);
         persona3.setNACIMIENTO(dma.parse("01/01/2010"));
         persona3.setESTADO(true);
         
         lista.add(persona1);
         lista.add(persona2);
         lista.add(persona3);

        } catch (Exception e) {
            System.out.println("Error:"+ e.getMessage());
        }
    }

    @Override
    public List<Persona> buscarTodos() {
        return lista;
    }

    @Override
     public Persona buscarCiPersona(Integer CI) {
        for (Persona p: lista) {
            if(p.getCI()==CI){
                return p;
            }
        }
        return null;
    }

    @Override
    public Persona buscarIdPersona(Integer ID_PERSONA) {
    for (Persona u: lista) {
            if(u.getID_PERSONA()==ID_PERSONA){
                return u;
            }
        }
        return null;
    }

    @Override
    public void guardar(Persona persona) {
        lista.add(persona);
    }
    
}
