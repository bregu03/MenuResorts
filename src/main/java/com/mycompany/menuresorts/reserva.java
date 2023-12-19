
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */

import java.util.Date;

public class reserva {
    public static int idBungalo;
    public static int id;
    public static String cliente;
    public static Date fechaInicio;
    public static Date fechaFin;
    public static boolean servicios;
    
        public reserva(int idBungalo, int id, String cliente, Date fechaInicio, Date fechaFin, boolean servicios){
            reserva.idBungalo=idBungalo;
            reserva.id=id;
            reserva.cliente=cliente;
            reserva.fechaInicio=fechaInicio;
            reserva.fechaFin=fechaFin;
            reserva.servicios=servicios;
        }
         
          
}
