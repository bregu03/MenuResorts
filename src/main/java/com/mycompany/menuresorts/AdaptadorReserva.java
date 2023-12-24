package com.mycompany.menuresorts;

/**
 * Clase abstracta del patron decorator
 * @author Alejandro
 */
public abstract class AdaptadorReserva {

    Reserva Reserva;

    /**
     * Metodo de seleccion de la reserva
     * @param Reserva
     */
    public AdaptadorReserva(Reserva Reserva) {
        this.Reserva = Reserva;
    }

    /**
     * Metodo encargado de añadir las opciones
     * @param Servicios
     */
    public abstract void añadirServicios(String Servicios);
}