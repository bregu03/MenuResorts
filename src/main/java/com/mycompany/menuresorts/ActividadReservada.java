package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase encargada de almacenar las actividades almacenadas
 * @author avbre
 */
public class ActividadReservada implements Serializable {
    public int IDActividad;
    public int Personas;
    public Date FechaInicio;
    public Date FechaFin;
    public String Descripcion;
    public int Precio;
    
    /**
     * Constructor para crear una actividad reservada
     * @param IDActividad
     * @param Personas
     * @param FechaInicio
     * @param FechaFin
     * @param ResortActual
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
