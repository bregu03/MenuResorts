/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class resort implements Serializable {
    static ArrayList<bungalo> bungalos;
    static ArrayList<actividad> actividades;
    static ArrayList<actividadReservada> actividadesReservadas;
    static ArrayList<reserva> reservas;
    static ArrayList<cliente> clientes;
    static ArrayList<factura> factura;

    public resort() {
        bungalos = new ArrayList<>();
        actividades = new ArrayList<>();
        actividadesReservadas = new ArrayList<>();
        reservas = new ArrayList<>();
        clientes = new ArrayList<>();
        factura = new ArrayList<>();
    }
}
