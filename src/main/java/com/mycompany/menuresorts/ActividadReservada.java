package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase encargada de almacenar las actividades almacenadas
 * @author avbre
 */
public class ActividadReservada implements Serializable {

    /**
     * Variable del identificador de la actividad reservada
     */
    public int IDActividad;

    /**
     * Variable del numero de personas que tomaran parte en la actividad
     */
    public int Personas;

    /**
     * Variable de la fecha de inicio de la actividad
     */
    public Date FechaInicio;

    /**
     * Variable de la fecha de finalizacion de la actividad
     */
    public Date FechaFin;

    /**
     * Variable de la descripcion de la actividad reservada
     */
    public String Descripcion;

    /**
     * Variable del precio de la actividad
     */
    public int Precio;
    
    /**
     * Constructor para crear una actividad reservada
     * @param IDActividad Variable del identificador de la actividad reservada
     * @param Personas Variable del numero de personas que tomaran parte en la actividad
     * @param FechaInicio Variable de la fecha de inicio de la actividad
     * @param FechaFin Variable de la fecha de finalizacion de la actividad
     * @param ResortActual Almacen de datos del sistema
     */
    public ActividadReservada(int IDActividad, int Personas, Date FechaInicio, Date FechaFin, Resort ResortActual){
        this.IDActividad=IDActividad;
        this.Personas=Personas;
        this.FechaInicio=FechaInicio;
        this.FechaFin=FechaFin;
        for (int i = 0; i < ResortActual.Actividades.size(); i++) {
            if (ResortActual.Actividades.get(i).ID == IDActividad) {
                this.Descripcion = ResortActual.Actividades.get(i).Descripcion;
                this.Precio = ResortActual.Actividades.get(i).Precio;
                break;
            }
        }
    }
}
