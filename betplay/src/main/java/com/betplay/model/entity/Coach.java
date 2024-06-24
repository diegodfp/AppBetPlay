package com.betplay.model.entity;

public class Coach extends Person {
    private int idFederacion;
    private String codigoEquipo;
    public Coach(){
        super();
    }

    public Coach(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public Coach(int id, String nombre, String apellido, int edad, int idFederacion, String codigoEquipo) {
        super(id, nombre, apellido, edad);
        this.idFederacion = idFederacion;
        this.codigoEquipo = codigoEquipo;
    }

    public int getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public String getCodigoEquipo() {
        return codigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    @Override
    public String toString() {
        return " Entrenador: " + getNombre() + " " + getApellido() + " de la federaacion # " + getIdFederacion() ;
    }
    
    
}
