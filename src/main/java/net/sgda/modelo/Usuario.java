package net.sgda.modelo;

import java.util.Date;

public class Usuario {
    private Integer ID_USUARIO;
    private String USUARIO;
    private String CLAVE;
    private boolean ESTADO;
    private String IMAGEN="no-image.png";
    //private MultipartFile file
    
    private String DETALLE;
    
    private Date REGISTRO;
    private Date MODIFICACION;

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

    public String getDETALLE() {
        return DETALLE;
    }

    public void setDETALLE(String DETALLE) {
        this.DETALLE = DETALLE;
    }

    public Integer getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(Integer ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public void setUSUARIO(String USUARIO) {
        this.USUARIO = USUARIO;
    }

    public String getCLAVE() {
        return CLAVE;
    }

    public void setCLAVE(String CLAVE) {
        this.CLAVE = CLAVE;
    }

    public boolean isESTADO() {
        return ESTADO;
    }

    public void setESTADO(boolean ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getIMAGEN() {
        return IMAGEN;
    }

    public void setIMAGEN(String IMAGEN) {
        this.IMAGEN = IMAGEN;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID_USUARIO=" + ID_USUARIO + ", USUARIO=" + USUARIO + ", CLAVE=" + CLAVE + ", ESTADO=" + ESTADO + ", IMAGEN=" + IMAGEN + ", DETALLE=" + DETALLE + ", REGISTRO=" + REGISTRO + ", MODIFICACION=" + MODIFICACION + '}';
    }
    
}