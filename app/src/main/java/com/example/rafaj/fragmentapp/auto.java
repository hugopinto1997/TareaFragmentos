package com.example.rafaj.fragmentapp;

public class auto {
    String nombre, año, velocidad;
    int imagen;

    public auto(String nombre, String año, String velocidad, int imagen) {
        this.nombre = nombre;
        this.año = año;
        this.velocidad = velocidad;
        this.imagen = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}
