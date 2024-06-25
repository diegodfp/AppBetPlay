package com.betplay.model.entity;

public class Player extends Person {
    private int dorsal;
    private String posicion;
    private String codigoEquipo;


    public Player() {
        super();
    }
    public Player(int dorsal, String posicion) {
        this.dorsal = dorsal;
        this.posicion = posicion;
    }
    public Player(int id, String nombre, String apellido, int edad, int dorsal, String posicion, String codigoEquipo) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.codigoEquipo = codigoEquipo;
    }


    public int getDorsal() {
        return dorsal;
    }
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    public String getCodigoEquipo() {
        return codigoEquipo;
    }
    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }

    public String toString() {
        return "Jugador " + getId() +
                " : '" + getNombre() +" "+ getApellido() + '\'' +
                ", tiene la dorsal #" + dorsal +
                ", y juega en la posicion de '" + posicion + '\'' ;
    }
   
    
}
