package com.mycompany.menuresorts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase encargada de almacenar las reservas
 * @author avbre
 */
public class Reserva implements Serializable {

    /**
     * Variable del identificador del bungalo
     */
    public int IDBungalo;

    /**
     * Variable del identificador de la reserva
     */
    public int ID;

    Cliente Cliente;

    /**
     * Variable de la fecha de inicio de la reserva
     */
    public Date FechaInicio;

    /**
     * Variable de la fecha de finalización de la reserva
     */
    public Date FechaFin;

    /**
     * Variable del numero de personas
     */
    public int Personas;

    /**
     * Variable de los servicios especiales del bungalo
     */
    public String Servicios;
    ArrayList<ActividadReservada> ActividadesReservadas;
    
    /**
     * Metodo encargado de crear una reserva
     * @param IDBungalo Variable del identificador del bungalo
     * @param ID Variable del identificador de la reserva
     * @param Nombre Variable del nombre del cliente
     * @param Apellidos Variable de los apellidos del cliente
     * @param NumeroFiscal Variable del DNI/NIF del cliente
     * @param Telefono Variable del telefono del cliente
     * @param FechaInicio Variable de la fecha de inicio de la reserva
     * @param FechaFin Variable de la fecha de finalización de la reserva
     * @param Personas Variable del numero de personas
     */
    public Reserva(int IDBungalo, int ID, String Nombre, String Apellidos, String NumeroFiscal, int Telefono, Date FechaInicio, Date FechaFin, int Personas){
        this.IDBungalo=IDBungalo;
        this.ID=ID;
        this.Cliente = new Cliente(Nombre, Apellidos, NumeroFiscal, Telefono);
        this.FechaInicio=FechaInicio;
        this.FechaFin=FechaFin;
        this.Personas=Personas;
        this.ActividadesReservadas = new ArrayList<>();
        this.Servicios = "| ";
    }
        
    /**
     * Metodo encargado de añadir los servicios especiales
     * @param Servicios Servicios extra solicitados para el bungalo
     */
    public void setServicios(String Servicios) {
        this.Servicios = Servicios;
    }

    /**
     * Metodo encargado de enviar los servicios especiales actualmente solicitados
     * @return Reserva.Servicios
     */
    public String getServicios() {
        return this.Servicios;
    }
}
