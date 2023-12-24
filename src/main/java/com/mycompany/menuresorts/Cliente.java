package com.mycompany.menuresorts;

import java.io.Serializable;

/**
 * Clase encargada de almacenar los clientes
 * @author avbre
 */
public class Cliente implements Serializable {

    /**
     * Variable del nombre del cliente
     */
    public String Nombre;

    /**
     * Variable de los apellidos del cliente
     */
    public String Apellidos;

    /**
     * Variable del DNI/NIF del cliente
     */
    public String NumeroFiscal;

    /**
     * Variable del numero de telefono del cliente
     */
    public int Telefono;
    
    /**
     * Metodo encargado de crear un cliente
     * @param Nombre Variable del nombre del cliente
     * @param Apellidos Variable de los apellidos del cliente
     * @param NumeroFiscal Variable del DNI/NIF del cliente
     * @param Telefono Variable del numero de telefono del cliente
     */
    public Cliente(String Nombre, String Apellidos, String NumeroFiscal, int Telefono){
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.NumeroFiscal=NumeroFiscal;
        this.Telefono=Telefono;
    }
}
