/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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