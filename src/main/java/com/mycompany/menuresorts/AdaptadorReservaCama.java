package com.mycompany.menuresorts;

/**
 *
 * @author Alejandro
 */
public class AdaptadorReservaCama extends AdaptadorReserva {

    public AdaptadorReservaCama(reserva reserva) {
        super(reserva);
    }

    public static void añadirServicios(String servicios) {
        servicios += " cama articulada |";
        reserva.setServicios(servicios);
    }
}