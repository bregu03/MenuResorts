package com.mycompany.menuresorts;

/**
 * Clase encargada de añadir el servidio de aseo
 * @author Alejandro
 */
public class AdaptadorReservaAseo extends AdaptadorReserva {

    /**
     * Metodo de seleccion de la reserva
     * @param Reserva
     */
    public AdaptadorReservaAseo(Reserva Reserva) {
        super(Reserva);
    }

    /**
     * Metodo encargado de añadir las opciones
     * @param Servicios
     */
    @Override
    public void añadirServicios(String Servicios) {
        Servicios += " aseo |";
        Reserva.setServicios(Servicios);
    }
}
