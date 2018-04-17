package com.example.rafaj.fragmentapp;

import java.io.Serializable;

public class auto implements Serializable{
    //clase auto serializada
    String nombre;
    String ano;
    String veloc;
    String imagen;




    public auto(String nombre, String ano, String veloc, String imagen) {
        this.nombre = nombre;
        this.ano = ano;
        this.veloc = veloc;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getVeloc() {
        return veloc;
    }

    public void setVeloc(String veloc) {
        this.veloc = veloc;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
