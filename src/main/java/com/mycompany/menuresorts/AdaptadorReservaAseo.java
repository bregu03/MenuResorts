package com.mycompany.menuresorts;

/**
 *
 * @author Alejandro
 */
public class AdaptadorReservaAseo extends AdaptadorReserva {

    public AdaptadorReservaAseo(reserva reserva) {
        super(reserva);
    }

    public static void añadirServicios(String servicios) {
        servicios += " aseo |";
        reserva.setServicios(servicios);
    }
}
