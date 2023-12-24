package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase encargada del almacenamiento de todos los datos del sistema
 * @author Alejandro
 */
public class Resort implements Serializable {
    ArrayList<Bungalo> Bungalos;
    ArrayList<Actividad> Actividades;
    ArrayList<Reserva> Reservas;
    ArrayList<Cliente> Clientes;
    ArrayList<Factura> Facturas;
    Date FechaCreacion;

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
