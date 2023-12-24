package com.mycompany.menuresorts;

import java.io.Serializable;

/**
 * Clase encargada de almacenar los bungalos
 * @author avbre
 */
public class Bungalo implements Serializable {

    /**
     * Variable de la capacidad del bungalo
     */
    public int Capacidad;

    /**
     * Variable del nombre del bungalo
     */
    public String Nombre;

    /**
     * Variable del precio del bungalo
     */
    public int Precio;

    /**
     * Variable que define si un bungalo es adaptado o no
     */
    public boolean Adaptado;

    /**
     * Variable del identificador del bungalo
     */
    public int ID;
    
    /**
     * Metodo encargado de crear un bungalo
     * @param Capacidad
     * @param Nombre
     * @param Precio
     * @param Adaptado
     * @param ID
     */
    public Bungalo(int Capacidad, String Nombre, int Precio, boolean Adaptado, int ID){
        this.Capacidad=Capacidad;
        this.Nombre=Nombre;
        this.Precio=Precio;
        this.Adaptado=Adaptado;
        this.ID=ID;
    }
}