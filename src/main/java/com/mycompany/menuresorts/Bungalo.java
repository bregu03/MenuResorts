package com.mycompany.menuresorts;

import java.io.Serializable;

/**
 * Clase encargada de almacenar los bungalos
 * @author avbre
 */
public class Bungalo implements Serializable {
    public int Capacidad;
    public String Nombre;
    public int Precio;
    public boolean Adaptado;
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