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
         persona1.setNACIMIENTO(dma.parse("01/01/2025"));
         persona1.setESTADO(true);
         
         Persona persona2 = new Persona();
         persona2.setID_PERSONA(2);
         persona2.setNOMBRE("Prisila");
         persona2.setPATERNO("Salas");
         persona2.setMATERNO("Nora");
         persona2.setCI(54321);
         persona2.setSEXO(false);
         persona2.setNACIMIENTO(dma.parse("01/01/2020"));
         persona2.setESTADO(false);
        
         Persona persona3 = new Persona();
         persona3.setID_PERSONA(3);
         persona3.setNOMBRE("Fenifer");
         persona3.setPATERNO("Flores");
         persona3.setMATERNO("Nakashima");
         persona3.setCI(12345);
         persona3.setSEXO(false);
         persona3.setNACIMIENTO(dma.parse("01/01/2015"));
         persona3.setESTADO(true);
        
         Persona persona4 = new Persona();
         persona4.setID_PERSONA(4);
            persona4.setNOMBRE("Jose");
         persona4.setPATERNO("Buely");
         persona4.setMATERNO("Natta");
         persona4.setCI(12345);
         persona4.setSEXO(false);
         persona4.setNACIMIENTO(dma.parse("01/01/2010"));
         persona4.setESTADO(true);
         
         Persona persona5 = new Persona();
         persona5.setID_PERSONA(5);
         persona5.setNOMBRE("Chin le");
         persona5.setPATERNO("Huan du");
         persona5.setMATERNO("Gonh");
         persona5.setCI(12345);
         persona5.setSEXO(true);
         persona5.setNACIMIENTO(dma.parse("01/01/2005"));
         persona5.setESTADO(false);
         
         Persona persona6 = new Persona();
         persona6.setID_PERSONA(6);
         persona6.setNOMBRE("Kali");
         persona6.setPATERNO("Mon");
         persona6.setMATERNO("Nima");
         persona6.setCI(12345);
         persona6.setSEXO(false);
         persona6.setNACIMIENTO(dma.parse("01/01/2000"));
         persona6.setESTADO(true);
         
         Persona persona7 = new Persona();
         persona7.setID_PERSONA(7);
         persona7.setNOMBRE("Ross");
         persona7.setPATERNO("Sossa");
         persona7.setMATERNO("Nakamura");
         persona7.setCI(12345);
         persona7.setSEXO(false);
         persona7.setNACIMIENTO(dma.parse("01/01/1995"));
         persona7.setESTADO(false);
         
         Persona persona8 = new Persona();
         persona8.setID_PERSONA(8);
         persona8.setNOMBRE("Ghone");
         persona8.setPATERNO("Potro");
         persona8.setMATERNO("Del");
         persona8.setCI(12345);
         persona8.setSEXO(true);
         persona8.setNACIMIENTO(dma.parse("01/01/1990"));
         persona8.setESTADO(true);
         
         lista.add(persona1);
         lista.add(persona2);
         lista.add(persona3);
         lista.add(persona4);
         lista.add(persona5);
         lista.add(persona6);
         lista.add(persona7);
         lista.add(persona8);

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
    for (Persona p: lista) {
            if(p.getID_PERSONA()==ID_PERSONA){
                return p;
            }
        }
        return null;
    }

    @Override
    public void guardar(Persona persona) {
        lista.add(persona);
    }
    
}
