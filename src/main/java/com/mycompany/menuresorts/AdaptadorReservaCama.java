/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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