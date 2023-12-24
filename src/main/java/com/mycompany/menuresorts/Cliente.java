package com.mycompany.menuresorts;

import java.io.Serializable;

/**
 * Clase encargada de almacenar los clientes
 * @author avbre
 */
public class Cliente implements Serializable {
    public String Nombre;
    public String Apellidos;
    public String NumeroFiscal;
    public int Telefono;
    
    /**
     * Metodo encargado de crear un cliente
     * @param Nombre
     * @param Apellidos
     * @param NumeroFiscal
     * @param Telefono
     */
    public Cliente(String Nombre, String Apellidos, String NumeroFiscal, int Telefono){
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.NumeroFiscal=NumeroFiscal;
        this.Telefono=Telefono;
    }
}
