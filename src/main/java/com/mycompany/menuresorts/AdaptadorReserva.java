package com.mycompany.menuresorts;

/**
 * Clase abstracta del patron decorator
 * @author Alejandro
 */
public abstract class AdaptadorReserva {

    /**
     * Variable almacen de los datos de una reserva
     */
    Reserva Reserva;

    /**
     * Metodo de seleccion de la reserva
     * @param Reserva Almacen de datos de una reserva
     */
    public AdaptadorReserva(Reserva Reserva) {
        this.Reserva = Reserva;
    }

    /**
     * Metodo encargado de añadir las opciones
     * @param Servicios Servicios extra solicitados para el bungalo
     */
    public abstract void añadirServicios(String Servicios);
}