package net.sgda.modelo;

import java.util.Date;

public class Persona {
    private Integer ID_PERSONA;
    private String NOMBRE;
    private String PATERNO;
    private String MATERNO;
    private Integer CI;
    private Date NACIMIENTO;
    private boolean SEXO;
    private boolean ESTADO;
    
    private Date REGISTRO;
    private Date MODIFICACION;

    public Integer getID_PERSONA() {
        return ID_PERSONA;
    }

    public void setID_PERSONA(Integer ID_PERSONA) {
        this.ID_PERSONA = ID_PERSONA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getPATERNO() {
        return PATERNO;
    }

    public void setPATERNO(String PATERNO) {
        this.PATERNO = PATERNO;
    }

    public String getMATERNO() {
        return MATERNO;
    }

    public void setMATERNO(String MATERNO) {
        this.MATERNO = MATERNO;
    }

    public Integer getCI() {
        return CI;
    }

    public void setCI(Integer CI) {
        this.CI = CI;
    }

    public Date getNACIMIENTO() {
        return NACIMIENTO;
    }

    public void setNACIMIENTO(Date NACIMIENTO) {
        this.NACIMIENTO = NACIMIENTO;
    }

    public boolean isSEXO() {
        return SEXO;
    }

    public void setSEXO(boolean SEXO) {
        this.SEXO = SEXO;
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

    @Override
    public String toString() {
        return "Persona{" + "ID_PERSONA=" + ID_PERSONA + ", NOMBRE=" + NOMBRE + ", PATERNO=" + PATERNO + ", MATERNO=" + MATERNO + ", CI=" + CI + ", NACIMIENTO=" + NACIMIENTO + ", SEXO=" + SEXO + ", ESTADO=" + ESTADO + ", REGISTRO=" + REGISTRO + ", MODIFICACION=" + MODIFICACION + '}';
    }

}
