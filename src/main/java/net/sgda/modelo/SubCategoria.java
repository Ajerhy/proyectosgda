package net.sgda.modelo;

import java.util.Date;

public class SubCategoria{
    private Integer id_subcategoria;
    private Categoria categoria;
    private String nombre;
    private boolean estado;
    private Date registro;
    private Date modificacion;

    public Integer getId_subcategoria() {
        return id_subcategoria;
    }

    public void setId_subcategoria(Integer id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public Date getModificacion() {
        return modificacion;
    }

    public void setModificacion(Date modificacion) {
        this.modificacion = modificacion;
    }

    @Override
    public String toString() {
        return "SubCategoria{" + "id_subcategoria=" + id_subcategoria + ", categoria=" + categoria + ", nombre=" + nombre + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion + '}';
    }
    
}
