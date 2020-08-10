package net.sgda.modelo;

import java.util.Date;

public class Categoria{

    private Integer ID_CATEGORIA;
    private String NOMBRE;
    private String SIGLA;
    private boolean ESTADO;
    private Date REGISTRO;
    private Date MODIFICACION;

    public Integer getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(Integer ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getSIGLA() {
        return SIGLA;
    }

    public void setSIGLA(String SIGLA) {
        this.SIGLA = SIGLA;
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
