package com.mycompany.menuresorts;

import java.io.Serializable;

/**
 * Clase encargada de almacenar las actividades
 * @author Alejandro
 * 
 */
public class Actividad implements Serializable {

    /**
     * Variable del identificador de la actividad
     */
    public int ID;

    /**
     * Variable de la descripcion de la actividad
     */
    public String Descripcion;

    /**
     * Variable del precio de la actividad
     */
    public int Precio;
    
    /**
     * Constructor para crear una actividad
     * @param ID
     * @param Descripcion
     * @param Precio
     */
    public Actividad(int ID, String Descripcion, int Precio){
        this.ID=ID;
        this.Descripcion=Descripcion;
        this.Precio=Precio;
    }
}
