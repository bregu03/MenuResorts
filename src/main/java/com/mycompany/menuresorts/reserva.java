
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */

import java.util.Date;

public class reserva {
    public static int idBungalo;
    public static int id;
    public static char nombre; 
    public static char apellidos;
    public static Date fechainicio;
    public static Date fechafin;
    
        public reserva(int idBungalo, int id, char nombre, char apellidos, Date fechainicio, Date fechafin){
            reserva.idBungalo=idBungalo;
            reserva.id=id;
            reserva.nombre=nombre;
            reserva.apellidos=apellidos;
            reserva.fechainicio=fechainicio;
            reserva.fechafin=fechafin;
        }
         
          
}
