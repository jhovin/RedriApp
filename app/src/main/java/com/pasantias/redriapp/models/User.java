package com.pasantias.redriapp.models;

import com.orm.dsl.Table;


@Table
public class User {

    private Long id;
    private String supervisor;
    private String dnisupervisor;
    private String ubicacion;
    private String codigo;
    private String tecnico1;
    private String tecnico2;
    private String dnitec1;
    private String dnitec2;
    private String maquina;
    private String serie;
    private String modelo;



    public User() {
    }

    public User(String supervisor, String dnisupervisor, String ubicacion, String codigo, String tecnico1, String tecnico2, String dnitec1, String dnitec2, String maquina, String serie, String modelo) {
        this.supervisor = supervisor;
        this.dnisupervisor = dnisupervisor;
        this.ubicacion = ubicacion;
        this.codigo = codigo;
        this.tecnico1 = tecnico1;
        this.tecnico2 = tecnico2;
        this.dnitec1 = dnitec1;
        this.dnitec2 = dnitec2;
        this.maquina = maquina;
        this.serie = serie;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getDnisupervisor() {
        return dnisupervisor;
    }

    public void setDnisupervisor(String dnisupervisor) {
        this.dnisupervisor = dnisupervisor;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTecnico1() {
        return tecnico1;
    }

    public void setTecnico1(String tecnico1) {
        this.tecnico1 = tecnico1;
    }

    public String getTecnico2() {
        return tecnico2;
    }

    public void setTecnico2(String tecnico2) {
        this.tecnico2 = tecnico2;
    }

    public String getDnitec1() {
        return dnitec1;
    }

    public void setDnitec1(String dnitec1) {
        this.dnitec1 = dnitec1;
    }

    public String getDnitec2() {
        return dnitec2;
    }

    public void setDnitec2(String dnitec2) {
        this.dnitec2 = dnitec2;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", supervisor='" + supervisor + '\'' +
                ", dnisupervisor='" + dnisupervisor + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", codigo='" + codigo + '\'' +
                ", tecnico1='" + tecnico1 + '\'' +
                ", tecnico2='" + tecnico2 + '\'' +
                ", dnitec1='" + dnitec1 + '\'' +
                ", dnitec2='" + dnitec2 + '\'' +
                ", maquina='" + maquina + '\'' +
                ", serie='" + serie + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}