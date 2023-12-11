package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class bungalo {
    private static int capacidad;
    private static char nombre;
    private static int precio;
    private static boolean adaptado;
    private static int id;
    
        public bungalo(int capacidad, char nombre, int precio, boolean adaptado, int id){
            bungalo.capacidad=capacidad;
            bungalo.nombre=nombre;
            bungalo.precio=precio;
            bungalo.adaptado=adaptado;
            bungalo.id=id;
        }
}