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
    static ArrayList<actividades> actividades;
    static ArrayList<actividadesReservadas> actividadesReservadas;
    static ArrayList<reservas> reservas;
    static ArrayList<clientes> clientes;
    static ArrayList<factura> factura;
    static ArrayList<servicios> servicios;

    public void Resort() {
        bungalos = new ArrayList<>();
        actividades = new ArrayList<>();
        actividadesReservadas = new ArrayList<>();
        reservas = new ArrayList<>();
        clientes = new ArrayList<>();
        factura = new ArrayList<>();
        servicios = new ArrayList<>();
    }
}
