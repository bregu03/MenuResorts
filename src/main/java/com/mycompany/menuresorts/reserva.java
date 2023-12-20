
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */

import java.util.ArrayList;
import java.util.Date;

public class reserva {
    public static int idBungalo;
    public static int id;
    public static String nombre;
    public static String apellidos;
    public static String numeroFiscal;
    public static int telefono;
    public static Date fechaInicio;
    public static Date fechaFin;
    public static int personas;
    public static String servicios;
    static ArrayList<actividadReservada> actividadesReservadas;
    
        public reserva(int idBungalo, int id, String nombre, String apellidos, String numeroFiscal, int telefono, Date fechaInicio, Date fechaFin, int personas){
            reserva.idBungalo=idBungalo;
            reserva.id=id;
            reserva.nombre=nombre;
            reserva.apellidos=apellidos;
            reserva.numeroFiscal=numeroFiscal;
            reserva.telefono=telefono;
            reserva.fechaInicio=fechaInicio;
            reserva.fechaFin=fechaFin;
            reserva.personas=personas;
            reserva.servicios=null;
            reserva.actividadesReservadas = new ArrayList<>();
        }
        
    public static void setServicios(String servicios) {
        reserva.servicios = servicios;
    }

    public static String getServicios() {
        return reserva.servicios;
    }
}
