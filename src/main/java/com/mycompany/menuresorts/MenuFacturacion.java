package com.mycompany.menuresorts;

import java.util.Date;

/**
 * Clase encargada de gestionar las facturas
 * @author avbre
 */
public class MenuFacturacion {

    /**
     * Metodo encargado del menu
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     */
    public Resort menu_facturacion(Resort ResortActual) {
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ FACTURACIÓN");
            System.out.println("1. Generar facturación");
            System.out.println("2. Facturas cliente");
            System.out.println("3. Mostrar factura");
            System.out.println("0. Volver atrás");
            
            // Leemos la opción del usuario
            System.out.print("Introduce una opción: ");
            String s=MyInput.readString();
            try{  
               opcion= Integer.parseInt(s);
            }catch(NumberFormatException ex){
                System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
                opcion = -999;
            }

            // Comprobamos la opción
            if (opcion < 0 || opcion > 3) {
                if (opcion != -999){
                    // Si la opción no es válida, lo avisamos
                    System.out.println("La opción no es válida.");
                }
            } else if (opcion == 0){
                //volver al main menuresorts
                System.out.println("Regresando al menu principal");
            }else{ 
                switch(opcion){
                    case 1 -> ResortActual = generarFactura(ResortActual);
                    
                    case 2 -> facturasCliente(ResortActual);
                    
                    case 3 -> mostarFactura(ResortActual);
                }
            }
        }while (opcion!=0);
        return ResortActual;
    }
    
    /**
     * Metodo encargado de crear las facturas y almacenarlas en el sistema
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     */
    public Resort generarFactura(Resort ResortActual){
        if (ResortActual.Reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!ResortActual.Reservas.isEmpty()){
            // Solicitamos la id de la reserva
            System.out.println("");
            System.out.print("Ingrese la id de la reserva a la que desea añadir la actividad: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si la reserva existe
            boolean existeReserva = false;
            int reservaAñadir = 0;
            for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                if (ResortActual.Reservas.get(i).ID == idReserva) {
                    existeReserva = true;
                    reservaAñadir = i;
                    break;
                }
            }

            // Si la reserva no existe, mostramos un mensaje de error
            if (!existeReserva) {
              System.out.println("La reserva con id " + idReserva + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeReserva){
                boolean existeFactura = false;
                for (int i = 0; i < ResortActual.Facturas.size(); i++) {
                    if (ResortActual.Facturas.get(i).Reserva.ID == idReserva) {
                        existeFactura = true;
                        break;
                    }
                }
                if (existeFactura) {
                    // Si a la reserva ya se le ha creado una factura, mostramos un mensaje de error
                    System.out.println("A la reserva con id " + idReserva + " ya se le ha creado una factura.");
                    System.out.println("Volviendo al menu...");
                } else if (!existeFactura){
                    Date fechaActual= new Date();
                    // Si es el dia del fin de la reserva o despues te permite hacer la factura (las fechas al guardarse con la hora 00, se puede hacer la factura si es el mismo dia)
                    if (ResortActual.Reservas.get(reservaAñadir).FechaFin.before(fechaActual)){
                        // Solicitamos la id de la factura para que el resort pueda usar el sistema de ids que crea adecuado
                        System.out.print("Ingrese la id de la factura: ");
                        int id = MyInput.readInt();
                        if (!ResortActual.Reservas.isEmpty()){
                            // Bucle para comprobar si la id ya existe
                            boolean existeId;
                            do {
                                // Comprobamos si la id ya existe
                                existeId = false;

                                for (int i = 0; i < ResortActual.Facturas.size(); i++) {
                                    if (ResortActual.Facturas.get(i).ID == id) {
                                        existeId = true;
                                        break;
                                    }
                                }

                                // Si la id ya existe, pedimos una nueva
                                if (existeId) {
                                    System.out.print("La id que ha introducido ya existe. Por favor, introduzca otra id: ");
                                    id = MyInput.readInt();
                                }
                            }while (existeId);
                        }
                        Reserva reserva = ResortActual.Reservas.get(reservaAñadir);
                        
                        int costeBungalo = 0;
                        
                        for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                            if (ResortActual.Bungalos.get(i).ID == reserva.IDBungalo) {
                                costeBungalo = ResortActual.Bungalos.get(i).Precio;
                                break;
                            }
                        }
                        
                        int coste = costeBungalo * reserva.Personas;
                        
                        if (!reserva.ActividadesReservadas.isEmpty()){
                            for (int i = 0; i < reserva.ActividadesReservadas.size(); i++) {
                                coste += reserva.ActividadesReservadas.get(i).Precio * reserva.ActividadesReservadas.get(i).Personas;
                            }
                        }
                        
                        Factura factura = new Factura(id, coste, fechaActual, reserva);
                        
                        ResortActual.Facturas.add(factura);
                        System.out.println("La reserva del cliente " + reserva.Cliente.NumeroFiscal + " se ha facturado con la id " + id + ".");
                        System.out.println("Coste total: " + coste + "€");
                        System.out.println("Volviendo al menu...");
                    } else {
                        // Si la reserva aun no ha finalizado, mostramos un mensaje de error
                        System.out.println("La reserva con id " + idReserva + " aun no ha finalizado.");
                        System.out.println("Volviendo al menu...");
                    }
                }
            }
        }
        // Guardado de datos por seguridad
        MyInput.serialize(ResortActual, "resort.dat");
        return ResortActual;
    }
    
    /**
     * Metodo encargado de mostrar las facturas de un cliente en concreto
     * @param ResortActual Almacen de datos del sistema
     */
    public void facturasCliente(Resort ResortActual){
        if (ResortActual.Facturas.isEmpty()){
            System.out.println("No hay ninguna factura almacenada en el sistema");
        } else if (!ResortActual.Facturas.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese el DNI/NIF del cliente: ");
            String numeroFiscal = MyInput.readString();

            // Comprobamos si la factura existe
            boolean existeFactura = false;
            for (int i = 0; i < ResortActual.Facturas.size(); i++) {
                if (ResortActual.Facturas.get(i).Reserva.Cliente.NumeroFiscal.equals(numeroFiscal)) {
                    existeFactura = true;
                    break;
                }
            }
        
            // Si la factura no existe, mostramos un mensaje de error
            if (!existeFactura) {
              System.out.println("El cliente con DNI/NIF " + numeroFiscal + " no tiene ninguna factura asociada.");
              System.out.println("Volviendo al menu...");
            } else if (existeFactura){
                // Mostramos la informacion de las facturas
                for (int i = 0; i < ResortActual.Facturas.size(); i++) {
                    if (ResortActual.Facturas.get(i).Reserva.Cliente.NumeroFiscal.equals(numeroFiscal)) {
                        System.out.println("");
                        System.out.println("ID Factura: " + ResortActual.Facturas.get(i).ID);
                        System.out.println("DNI/NIF: " + ResortActual.Facturas.get(i).Reserva.Cliente.NumeroFiscal);
                        System.out.println("Fecha de expedición: " + ResortActual.Facturas.get(i).FechaFact);
                    }
                }
            }
        }
    }
    
    /**
     * Metodo encargado de mostrar una factura en concreto
     * @param ResortActual Almacen de datos del sistema
     */
    public void mostarFactura(Resort ResortActual){
        if (ResortActual.Facturas.isEmpty()){
            System.out.println("No hay ninguna factura almacenada en el sistema");
        } else if (!ResortActual.Facturas.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese el DNI/NIF del cliente: ");
            String numeroFiscal = MyInput.readString();

            // Comprobamos si existen facturas de este cliente
            boolean existeFactura = false;
            for (int i = 0; i < ResortActual.Facturas.size(); i++) {
                if (ResortActual.Facturas.get(i).Reserva.Cliente.NumeroFiscal.equals(numeroFiscal)) {
                    existeFactura = true;
                    break;
                }
            }
        
            // Si la factura no existe, mostramos un mensaje de error
            if (!existeFactura) {
                System.out.println("El cliente con DNI/NIF " + numeroFiscal + " no tiene ninguna factura asociada.");
                System.out.println("Volviendo al menu...");
            } else if (existeFactura){
                System.out.println("");
                System.out.print("Ingrese la id de la factura: ");
                int id = MyInput.readInt();
                
                // Comprobamos si existe la factura de este cliente
                boolean existeFacturaCliente = false;
                int facturaCliente = 0;
                for (int i = 0; i < ResortActual.Facturas.size(); i++) {
                    if (ResortActual.Facturas.get(i).Reserva.Cliente.NumeroFiscal.equals(numeroFiscal) && ResortActual.Facturas.get(i).ID == id) {
                        existeFacturaCliente = true;
                        facturaCliente = i;
                        break;
                    }
                }
                if (!existeFacturaCliente) {
                    System.out.println("El cliente con DNI/NIF " + numeroFiscal + " no tiene ninguna factura asociada con la id " + id + ".");
                    System.out.println("Volviendo al menu...");
                } else if (existeFacturaCliente){
                    System.out.println("");
                    System.out.println("FACTURA");
                    System.out.println("    Nombre: " + ResortActual.Facturas.get(facturaCliente).Reserva.Cliente.Nombre);
                    System.out.println("    Apellidos: " + ResortActual.Facturas.get(facturaCliente).Reserva.Cliente.Apellidos);
                    System.out.println("    DNI/NIF: " + ResortActual.Facturas.get(facturaCliente).Reserva.Cliente.NumeroFiscal);
                    System.out.println("    Telefono: " + ResortActual.Facturas.get(facturaCliente).Reserva.Cliente.Telefono);
                    System.out.println("");
                    System.out.println("    ID Factura: " + ResortActual.Facturas.get(facturaCliente).ID);
                    System.out.println("    Fecha de facturación: " + ResortActual.Facturas.get(facturaCliente).FechaFact);
                    System.out.println("");
                    System.out.println("    ID Bungalo: " + ResortActual.Facturas.get(facturaCliente).Reserva.IDBungalo);
                    System.out.println("");
                    System.out.println("    ACTIVIDADES RESERVADAS");
                    if (ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.isEmpty()){
                        System.out.println("        No se reservaron actividades.");
                    } else if (!ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.isEmpty()){
                        for (int i = 0; i < ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.size(); i++) {
                            System.out.println("");
                            System.out.println("        ID Actividad: " + ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.get(i).IDActividad);
                            System.out.println("        Número de personas: " + ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.get(i).Personas);
                            System.out.println("        Fecha inicio: " + ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.get(i).FechaInicio);
                            System.out.println("        Fecha fin: " + ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.get(i).FechaFin);
                            System.out.println("        Descripción: " + ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.get(i).Descripcion);
                            System.out.println("        Precio: " + ResortActual.Facturas.get(facturaCliente).Reserva.ActividadesReservadas.get(i).Precio);
                        }
                    }
                    System.out.println("");
                    System.out.println("    Coste total: " + ResortActual.Facturas.get(facturaCliente).Coste + "€");
                }
            }
        }
    }
}
