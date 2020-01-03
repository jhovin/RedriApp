package com.pasantias.redriapp.models;

public class Proyecto {

    private Long id_proyectos;
    private String imagen;
    private String nombre_proyectos;
    private String nivel;
    private String maquina;
    private String area;
    private String observacion;

    public Long getId_proyectos() {
        return id_proyectos;
    }

    public void setId_proyectos(Long id_proyectos) {
        this.id_proyectos = id_proyectos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre_proyectos() {
        return nombre_proyectos;
    }

    public void setNombre_proyectos(String nombre_proyectos) {
        this.nombre_proyectos = nombre_proyectos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id_proyectos=" + id_proyectos +
                ", imagen='" + imagen + '\'' +
                ", nombre_proyectos='" + nombre_proyectos + '\'' +
                ", nivel='" + nivel + '\'' +
                ", maquina='" + maquina + '\'' +
                ", area='" + area + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
