package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase encargada de almacenar las facturas
 * @author avbre
 */
public class Factura implements Serializable {
    public int ID;
    public int Coste;
    public Date FechaFact;
    
    public Factura(){
        this.FechaFact=new Date();
    }
}
