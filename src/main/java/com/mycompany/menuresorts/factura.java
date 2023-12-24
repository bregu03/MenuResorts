package com.mycompany.menuresorts;

import java.util.Date;

/**
 *
 * @author avbre
 */
public class factura {
    public static int id;
    public static int coste;
    public static Date fechafact;
    
    public factura(){
        factura.fechafact=new Date();
    }
}
