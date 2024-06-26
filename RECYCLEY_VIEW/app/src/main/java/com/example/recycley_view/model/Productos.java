package com.example.recycley_view.model;

public class Productos {
    private String Nombre;
    private int Precio;
    private String Descripcion;

    public Productos(String nombre, int precio, String descripcion) {
        Nombre = nombre;
        Precio = precio;
        Descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
