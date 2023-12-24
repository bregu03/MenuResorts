package com.mycompany.menuresorts;

import java.util.Date;

/**
 *
 * @author avbre
 */
public class actividadReservada{
    public static int idActividad;
    public static int personas;
    public static Date fechaInicio;
    public static Date fechaFin;
    public static String descripcion;
    public static int precio;
    
    public actividadReservada(int idActividad, int personas, Date fechaInicio, Date fechaFin){
        actividadReservada.idActividad=idActividad;
        actividadReservada.personas=personas;
        actividadReservada.fechaInicio=fechaInicio;
        actividadReservada.fechaFin=fechaFin;
        for (int i = 0; i < resort.actividades.size(); i++) {
            if (resort.actividades.get(i).id == idActividad) {
                actividadReservada.descripcion = resort.actividades.get(i).descripcion;
                actividadReservada.precio = resort.actividades.get(i).precio;
                break;
            }
        }
    }
}
