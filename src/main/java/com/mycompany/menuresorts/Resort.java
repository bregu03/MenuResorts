package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase encargada del almacenamiento de todos los datos del sistema
 * @author Alejandro
 */
public class Resort implements Serializable {
    
    /**
     * Variable almacen de los datos de los bungalos
     */
    ArrayList<Bungalo> Bungalos;
    
    /**
     * Variable almacen de los datos de las actividades
     */
    ArrayList<Actividad> Actividades;
    
    /**
     * Variable almacen de los datos de las reservas
     */
    ArrayList<Reserva> Reservas;
    
    /**
     * Variable almacen de los datos de los clientes
     */
    ArrayList<Cliente> Clientes;
    
    /**
     * Variable almacen de los datos de las facturas
     */
    ArrayList<Factura> Facturas;
    
    /**
     * Variable almacen de la fecha de creación de la estructura
     */
    public Date FechaCreacion;

    /**
     * Metodo encargado de crear un almacen de datos nuevo
     */
    public Resort() {
        Bungalos = new ArrayList<>();
        Actividades = new ArrayList<>();
        Reservas = new ArrayList<>();
        Clientes = new ArrayList<>();
        Facturas = new ArrayList<>();
        FechaCreacion = new Date();
    }
}
