package com.formacion.models;

public class Curso {
    private int codCurso;
    private String nombre;
    private int duracion;
    private double precio;

    public Curso() {
        super();
    }

    public Curso(int codCurso, String nombre, int duracion, double precio) {
        super();
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }
    public int getCodCurso() {
        return codCurso;
    }
    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
