package com.pasantias.redriapp.models;

import com.orm.dsl.Table;

import java.util.Date;

@Table
public class User {

    private Long id;
    private String fullname;
    private String email;
    private String password;
    private String codigo;
    private String tecnico1;
    private String tecnico2;
    private String dnitec1;
    private String dnitec2;




    public User() {
    }

    public User(String fullname, String email, String password, String codigo, String tecnico1, String tecnico2, String dnitec1, String dnitec2) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.codigo = codigo;
        this.tecnico1 = tecnico1;
        this.tecnico2 = tecnico2;
        this.dnitec1 = dnitec1;
        this.dnitec2 = dnitec2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", codigo='" + codigo + '\'' +
                ", tecnico1='" + tecnico1 + '\'' +
                ", tecnico2='" + tecnico2 + '\'' +
                ", dnitec1='" + dnitec1 + '\'' +
                ", dnitec2='" + dnitec2 + '\'' +
                '}';
    }
}