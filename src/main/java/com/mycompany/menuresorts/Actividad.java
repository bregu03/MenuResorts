package com.mycompany.menuresorts;

import java.io.Serializable;

/**
 * Clase encargada de almacenar las actividades
 * @author Alejandro
 */
public class Actividad implements Serializable {
    public int ID;
    public String Descripcion;
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
