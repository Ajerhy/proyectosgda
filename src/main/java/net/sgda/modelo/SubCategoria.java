package net.sgda.modelo;

import java.util.Date;

public class SubCategoria{
    private Integer ID_SUBCATEGORIA;
    private Integer CATEGORIA;
    private String NOMBRE;
    private boolean ESTADO;
    private Date REGISTRO;
    private Date MODIFICACION;

    public Integer getID_SUBCATEGORIA() {
        return ID_SUBCATEGORIA;
    }

    public void setID_SUBCATEGORIA(Integer ID_SUBCATEGORIA) {
        this.ID_SUBCATEGORIA = ID_SUBCATEGORIA;
    }

    public Integer getCATEGORIA() {
        return CATEGORIA;
    }

    public void setCATEGORIA(Integer CATEGORIA) {
        this.CATEGORIA = CATEGORIA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public boolean isESTADO() {
        return ESTADO;
    }

    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    public Date getREGISTRO() {
        return REGISTRO;
    }

    public void setREGISTRO(Date REGISTRO) {
        this.REGISTRO = REGISTRO;
    }

    public Date getMODIFICACION() {
        return MODIFICACION;
    }

    public void setMODIFICACION(Date MODIFICACION) {
        this.MODIFICACION = MODIFICACION;
    }

    
    
}
