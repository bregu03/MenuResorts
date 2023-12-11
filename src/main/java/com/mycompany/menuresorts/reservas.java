
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */

import java.util.Date;

public class reservas {
    private static int idBungalo;
    private static int id;
    private static char nombre; 
    private static char apellidos;
    private static Date fechainicio;
    private static Date fechafin;
    
        public reservas(int idBungalo, int id, char nombre, char apellidos, Date fechainicio, Date fechafin){
            reservas.idBungalo=idBungalo;
            reservas.id=id;
            reservas.nombre=nombre;
            reservas.apellidos=apellidos;
            reservas.fechainicio=fechainicio;
            reservas.fechafin=fechafin;
        }
         
          
}
