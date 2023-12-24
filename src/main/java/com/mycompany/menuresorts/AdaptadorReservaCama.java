package com.mycompany.menuresorts;

/**
 * Clase encargada de añadir el servidio de cama articulada
 * @author Alejandro
 */
public class AdaptadorReservaCama extends AdaptadorReserva {

    /**
     * Metodo de seleccion de la reserva
     * @param Reserva Almacen de datos de una reserva
     */
    public AdaptadorReservaCama(Reserva Reserva) {
        super(Reserva);
    }

    /**
     * Metodo encargado de añadir las opciones
     * @param Servicios Servicios extra solicitados para el bungalo
     */
    @Override
    public void añadirServicios(String Servicios) {
        Servicios += " cama articulada |";
        Reserva.setServicios(Servicios);
    }
}