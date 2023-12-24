package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase encargada de almacenar las facturas
 * @author avbre
 */
public class Factura implements Serializable {

    /**
     * Variable encargada del identificador de la factura
     */
    public int ID;

    /**
     * Variable del coste de la factura
     */
    public int Coste;

    /**
     * Variable de la fecha de la factura
     */
    public Date FechaFact;
    
    Reserva Reserva;
    
    /**
     *
     * @param ID
     * @param Coste
     * @param FechaFact
     * @param Reserva */
    public Factura(int ID, int Coste, Date FechaFact, Reserva Reserva){
        this.ID=ID;
        this.Coste=Coste;
        this.FechaFact=FechaFact;
        this.Reserva=Reserva;
    }
}
