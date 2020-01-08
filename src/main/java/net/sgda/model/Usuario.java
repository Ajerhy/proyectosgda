/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sgda.model;

/**
 *
 * @author Hp
 */
public class Usuario {
    private Integer ID_USUARIO;
    private String USUARIO;
    private String CLAVE;

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

    @Override
    public String toString() {
        return "Usuario{" + "ID_USUARIO=" + ID_USUARIO + ", USUARIO=" + USUARIO + ", CLAVE=" + CLAVE + '}';
    }
}
