package com.mycompany.menuresorts;

/**
 *
 * @author Alejandro
 */
public abstract class AdaptadorReserva {

    static reserva reserva;

    public AdaptadorReserva(reserva reserva) {
        this.reserva = reserva;
    }

    public static void añadirServicios(String servicios){}
}