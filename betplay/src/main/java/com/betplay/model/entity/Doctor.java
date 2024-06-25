package com.betplay.model.entity;

public class Doctor extends Person {
    private String titulo;
    private int expYear;
    private String codigoEquipo;
    
    public Doctor(){

    }
    public Doctor(String titulo, int expYear) {
        this.titulo = titulo;
        this.expYear = expYear;
    }
    public Doctor(int id, String nombre, String apellido, int edad, String titulo, int expYear, String codigoEquipo) {
        super(id, nombre, apellido, edad);
        this.titulo = titulo;
        this.expYear = expYear;
        this.codigoEquipo = codigoEquipo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getExpYear() {
        return expYear;
    }
    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }
    public String getCodigoEquipo() {
        return codigoEquipo;
    }
    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }
    @Override
    public String toString() {
        return "Doctor" + getNombre() + " " + getApellido() + ", que cuenta con " + getExpYear() + " años de experiencia y cuenta con el titulo de " + getTitulo() + " ";
    }
    
}
