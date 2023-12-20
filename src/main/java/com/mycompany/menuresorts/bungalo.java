package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class bungalo {
    public static int capacidad;
    public static String nombre;
    public static int precio;
    public static boolean adaptado;
    public static int id;
    
    public bungalo(int capacidad, String nombre, int precio, boolean adaptado, int id){
        bungalo.capacidad=capacidad;
        bungalo.nombre=nombre;
        bungalo.precio=precio;
        bungalo.adaptado=adaptado;
        bungalo.id=id;
    }
}