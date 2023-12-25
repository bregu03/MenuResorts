package com.mycompany.menuresorts;

import java.text.ParseException;
import java.util.Date;

/**
 * Clase encargada de gestionar las reservas
 * @author avbre
 */
public class MenuReservas {

    /**
     * Metodo encargado del menu
     * @param ResortActual  Almacen de datos del sistema
     * @return ResortActual
     * @throws ParseException
     */
    public Resort menu_reservas(Resort ResortActual) throws ParseException {
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ RESERVAS");
            System.out.println("1. Dar de alta");
            System.out.println("2. Dar de baja");
            System.out.println("3. Añadir actividad");
            System.out.println("4. Eliminar actividad");
            System.out.println("5. Listar reservas");
            System.out.println("6. Mostrar reservas");
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
            if (opcion < 0 || opcion > 6) {
                if (opcion != -999){
                    // Si la opción no es válida, lo avisamos
                    System.out.println("La opción no es válida.");
                }
            } else if (opcion == 0){
                //volver al main menuresorts
                System.out.println("Regresando al menu principal");
            }else{ 
                switch(opcion){
                    case 1 -> ResortActual = crearReserva(ResortActual);

                    case 2 -> ResortActual = eliminarReserva(ResortActual);
                    
                    case 3 -> ResortActual = agregarActividad(ResortActual);
                    
                    case 4 -> ResortActual = eliminarActividad(ResortActual);
                    
                    case 5 -> listarReservas(ResortActual);
                    
                    case 6 -> mostrarReserva(ResortActual);
                }
            }
        }while (opcion!=0);
        return ResortActual;
    }
    
    /**
     * Metodo encargado de añadir una reserva al sistema
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     * @throws ParseException
     */
    public Resort crearReserva(Resort ResortActual) throws ParseException{
        System.out.println("");
        // Solicitamos si el bungalo a de ser accesible para personas con discapacidad
        System.out.print("¿El bungalo tiene que ser adaptado? (S/N): ");
        String respuesta1 = MyInput.readString();
        
        boolean adaptado, siguiente1;
        adaptado = true;
        do {
            switch (respuesta1) {
                case "S", "s" -> {
                    // Si la respuesta es afirmativa, buscamos bungalos adaptados
                    adaptado = true;
                    siguiente1 = true;
                }
                case "N", "n" -> {
                    // Si la respuesta es negativa, buscamos bungalos no adaptados
                    adaptado = false;
                    siguiente1 = true;
                }
                default -> {
                    // Si no se reconoce la respuesta, repetimos la pregunta
                    siguiente1 = false;
                    System.out.println("Respuesta no valida, introduzca un valor valido");
                    System.out.print("¿El bungalo tiene que ser adaptado? (S/N): ");
                    respuesta1 = MyInput.readString();
                }
            }
        } while (!siguiente1);
        
        // Solicitamos si la fecha de inicio
        System.out.print("Ingrese la fecha de inicio: ");
        Date fechaInicio = MyInput.readDate();
        
        // Solicitamos si la fecha de fin
        System.out.print("Ingrese la fecha de fin: ");
        Date fechaFin = MyInput.readDate();
        
        // Solicitamos el número de personas
        System.out.print("Ingrese el número de personas: ");
        int personas = MyInput.readInt();
        
        boolean disponible = false;
        if (ResortActual.Bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!ResortActual.Bungalos.isEmpty()){
            System.out.println("");
            System.out.println("BUNGALOS DISPONIBLES");
            for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                if (ResortActual.Bungalos.get(i).Adaptado == adaptado && ResortActual.Bungalos.get(i).Capacidad == personas) {
                    if (!ResortActual.Reservas.isEmpty()){
                        for (int n = 0; n < ResortActual.Reservas.size(); n++) {
                            if (ResortActual.Bungalos.get(i).ID == ResortActual.Reservas.get(n).IDBungalo){
                                if (fechaFin.before(ResortActual.Reservas.get(n).FechaInicio) || fechaInicio.after(ResortActual.Reservas.get(n).FechaFin)) {
                                    // Bloque de código a ejecutar si los intervalos no se solapan
                                    System.out.println("");
                                    System.out.println("ID: " + ResortActual.Bungalos.get(n).ID);
                                    System.out.println("Capacidad: " + ResortActual.Bungalos.get(n).Capacidad);
                                    System.out.println("Nombre: " + ResortActual.Bungalos.get(n).Nombre);
                                    System.out.println("Precio: " + ResortActual.Bungalos.get(n).Precio);
                                    System.out.println("Adaptado: " + ResortActual.Bungalos.get(n).Adaptado);
                                    disponible = true;
                                }
                            }
                        }
                    } else if (ResortActual.Reservas.isEmpty()){
                        System.out.println("");
                        System.out.println("ID: " + ResortActual.Bungalos.get(i).ID);
                        System.out.println("Capacidad: " + ResortActual.Bungalos.get(i).Capacidad);
                        System.out.println("Nombre: " + ResortActual.Bungalos.get(i).Nombre);
                        System.out.println("Precio: " + ResortActual.Bungalos.get(i).Precio);
                        System.out.println("Adaptado: " + ResortActual.Bungalos.get(i).Adaptado);
                        disponible = true;
                    }
                }
            }
        }
        
        if (disponible){
            // Solicitamos la id del bungalo
            System.out.print("Ingrese la id del bungalo: ");
            int idBungalo = MyInput.readInt();// Bucle para comprobar si la id esta disponible
            boolean disponibleId;
            do {
                // Comprobamos si la id esta disponible
                disponibleId = false;

                for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                    if (ResortActual.Bungalos.get(i).ID == idBungalo && ResortActual.Bungalos.get(i).Adaptado == adaptado && ResortActual.Bungalos.get(i).Capacidad == personas) {
                        if (!ResortActual.Reservas.isEmpty()){
                            for (int n = 0; n < ResortActual.Reservas.size(); n++) {
                                if (ResortActual.Bungalos.get(i).ID == ResortActual.Reservas.get(n).IDBungalo){
                                    if (fechaFin.before(ResortActual.Reservas.get(n).FechaInicio) && fechaInicio.after(ResortActual.Reservas.get(n).FechaFin)) {
                                        disponibleId = true;
                                        break;
                                    }
                                }
                            }
                        } else if (ResortActual.Reservas.isEmpty()){
                            disponibleId = true;
                            break;
                        }
                    }
                }

                // Si la id no esta disponible, pedimos una nueva
                if (!disponibleId) {
                    System.out.print("La id que ha introducido no esta disponible. Por favor, introduzca otra id: ");
                    idBungalo = MyInput.readInt();
                }
            }while (!disponibleId);
            
            boolean cama = false;
            if (adaptado){
                System.out.print("¿Desea solicitar cama articulada? (S/N): ");
                String respuesta = MyInput.readString();
                boolean siguiente = false;
                do {
                    switch (respuesta) {
                        case "S", "s" -> {
                            // Si la respuesta es afirmativa, seleccionamos cama articulada
                            siguiente = true;
                            cama = true;
                        }
                        case "N", "n" -> {
                            // Si la respuesta es negativa, no seleccionamos cama articulada
                            siguiente = true;
                            cama = false;
                        }
                        default -> {
                            // Si no se reconoce la respuesta, repetimos la pregunta
                            System.out.println("Respuesta no valida, introduzca un valor valido");
                            System.out.print("¿Desea solicitar cama articulada? (S/N): ");
                            respuesta = MyInput.readString();
                        }
                    }
                } while (!siguiente);
            }
            
            boolean aseo = false;
            if (adaptado){
                System.out.print("¿Desea solicitar aseo asistido? (S/N): ");
                String respuesta = MyInput.readString();
                boolean siguiente = false;
                do {
                    switch (respuesta) {
                        case "S", "s" -> {
                            // Si la respuesta es afirmativa, seleccionamos aseo asistido
                            siguiente = true;
                            aseo = true;
                        }
                        case "N", "n" -> {
                            // Si la respuesta es negativa, no seleccionamos aseo asistido
                            siguiente = true;
                            aseo = false;
                        }
                        default -> {
                            // Si no se reconoce la respuesta, repetimos la pregunta
                            System.out.println("Respuesta no valida, introduzca un valor valido");
                            System.out.print("¿Desea solicitar aseo asistido? (S/N): ");
                            respuesta = MyInput.readString();
                        }
                    }
                } while (!siguiente);
            }
            
            // Solicitamos el DNI/NIF del cliente
            System.out.print("Ingrese el DNI/NIF del cliente: ");
            String numeroFiscal = MyInput.readString();
            boolean existeCliente = false;
            String nombre = null;
            String apellidos = null;
            int telefono = 0;
            if (!ResortActual.Clientes.isEmpty()){
                // Bucle para comprobar si el DNI/NIF ya existe
                int numeroCliente = 0;
                // Comprobamos si el DNI/NIF ya existe
                existeCliente = false;

                for (int i = 0; i < ResortActual.Clientes.size(); i++) {
                    if (ResortActual.Clientes.get(i).NumeroFiscal.equals(numeroFiscal)) {
                        existeCliente = true;
                        numeroCliente = i;
                        break;
                    }
                }

                // Si el DNI/NIF ya existe, rellenamos el resto de datos
                if (existeCliente) {
                    nombre = ResortActual.Clientes.get(numeroCliente).Nombre;
                    apellidos = ResortActual.Clientes.get(numeroCliente).Apellidos;
                    telefono = ResortActual.Clientes.get(numeroCliente).Telefono;
                } else if (!existeCliente){
                    // Solicitamos el nombre del cliente
                    System.out.print("Ingrese el nombre del cliente: ");
                    nombre = MyInput.readString();

                    // Solicitamos los apellidos del cliente
                    System.out.print("Ingrese los apellidos del cliente: ");
                    apellidos = MyInput.readString();
                    
                    // Solicitamos el telefono del cliente
                    System.out.print("Ingrese el telefono del cliente: ");
                    telefono = MyInput.readInt();
                }
            } else if (ResortActual.Clientes.isEmpty()){
                // Solicitamos el nombre del cliente
                existeCliente = false;
                System.out.print("Ingrese el nombre del cliente: ");
                nombre = MyInput.readString();

                // Solicitamos los apellidos del cliente
                System.out.print("Ingrese los apellidos del cliente: ");
                apellidos = MyInput.readString();

                // Solicitamos el telefono del cliente
                System.out.print("Ingrese el telefono del cliente: ");
                telefono = MyInput.readInt();
            }
            
            // Solicitamos la id de la reserva
            System.out.print("Ingrese la id de la reserva: ");
            int id = MyInput.readInt();
            if (!ResortActual.Reservas.isEmpty()){
                // Bucle para comprobar si la id ya existe
                boolean existeId;
                do {
                    // Comprobamos si la id ya existe
                    existeId = false;

                    for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                        if (ResortActual.Reservas.get(i).ID == id) {
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
            
            // Solicitamos confirmación para guardar los datos
            System.out.print("¿Son correctos estos datos? (S/N): ");
            String respuesta2 = MyInput.readString();
            boolean siguiente2;
            do {
                switch (respuesta2) {
                    case "S", "s" -> {
                        // Si la respuesta es afirmativa, guardamos los datos
                        Reserva reserva = new Reserva(idBungalo, id, nombre, apellidos, numeroFiscal, telefono, fechaInicio, fechaFin, personas);
                        if (!existeCliente){
                            Cliente cliente = new Cliente(nombre, apellidos, numeroFiscal, telefono);
                            ResortActual.Clientes.add(cliente);
                        } if (cama){
                            AdaptadorReservaCama ReservaCama = new AdaptadorReservaCama(reserva);
                            ReservaCama.añadirServicios(reserva.getServicios());
                        } if (aseo){
                            AdaptadorReservaAseo ReservaAseo = new AdaptadorReservaAseo(reserva);
                            ReservaAseo.añadirServicios(reserva.getServicios());
                        }   // Añadimos la reserva a la lista de reservas del resort
                        ResortActual.Reservas.add(reserva);
                        // Mostramos un mensaje de confirmación
                        System.out.println("Los datos se han guardado correctamente.");
                        System.out.println("Volviendo al menu...");
                        siguiente2 = true;
                    }
                    case "N", "n" -> {
                        // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                        System.out.println("Los datos no han sido guardados.");
                        System.out.println("Volviendo al menu...");
                        siguiente2 = true;
                    }
                    default -> {
                        // Si no se reconoce la respuesta, repetimos la pregunta
                        System.out.println("Respuesta no valida, introduzca un valor valido");
                        System.out.print("¿Son correctos estos datos? (S/N): ");
                        respuesta2 = MyInput.readString();
                        siguiente2 = false;
                    }
                }
            } while (!siguiente2);
        }else if (!disponible){
            System.out.println("No hay bungalos desponibles que cumplan estas condiciones");
            System.out.println("Volviendo al menu...");
        }
        return ResortActual;
    }
    
    /**
     * Metodo encargado de eliminar una reserva del sistema
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     */
    public Resort eliminarReserva(Resort ResortActual){
        if (ResortActual.Reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!ResortActual.Reservas.isEmpty()){
            // Solicitamos la id de la reserva
            System.out.println("");
            System.out.print("Ingrese la id de la reserva que desea eliminar: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si la reserva existe
            boolean existeReserva = false;
            int reservaEliminar = 0;
            for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                if (ResortActual.Reservas.get(i).ID == idReserva) {
                    existeReserva = true;
                    reservaEliminar = i;
                    break;
                }
            }

            // Si la reserva no existe, mostramos un mensaje de error
            if (!existeReserva) {
              System.out.println("La reserva con id " + idReserva + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeReserva){
                Date fechaActual = new Date();
                // Comprobamos si la reserva ya ha iniciado
                boolean enEjecucion = false;
                if (ResortActual.Reservas.get(reservaEliminar).FechaInicio.before(fechaActual)) {
                    enEjecucion = true;
                }

                // Si la reserva esta en uso, mostramos un mensaje de error
                if (enEjecucion) {
                    System.out.println("La reservao con id " + idReserva + " está en ejecución. No se puede eliminar.");
                    System.out.println("Volviendo al menu...");
                } else if (!enEjecucion) {
                    // Imprime los datos de la reserva
                    System.out.println("");
                    System.out.println("ID Bungalo: " + ResortActual.Reservas.get(reservaEliminar).IDBungalo);
                    System.out.println("ID: " + ResortActual.Reservas.get(reservaEliminar).ID);
                    System.out.println("Nombre: " + ResortActual.Reservas.get(reservaEliminar).Cliente.Nombre);
                    System.out.println("Apellidos: " + ResortActual.Reservas.get(reservaEliminar).Cliente.Apellidos);
                    System.out.println("DNI/NIF: " + ResortActual.Reservas.get(reservaEliminar).Cliente.NumeroFiscal);
                    System.out.println("Telefono: " + ResortActual.Reservas.get(reservaEliminar).Cliente.Telefono);
                    System.out.println("Fecha inicio: " + ResortActual.Reservas.get(reservaEliminar).FechaInicio);
                    System.out.println("Fecha fin: " + ResortActual.Reservas.get(reservaEliminar).FechaFin);
                    System.out.println("Número de personas: " + ResortActual.Reservas.get(reservaEliminar).Personas);
                    System.out.println("Servicios: " + ResortActual.Reservas.get(reservaEliminar).Servicios);
                    System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                    String respuesta = MyInput.readString();
                    boolean siguiente;
                    do {
                        switch (respuesta) {
                            case "S", "s" -> {
                                // Si la respuesta es afirmativa, eliminamos la reserva del array
                                ResortActual.Reservas.remove(reservaEliminar);
                                System.out.println("La reserva con id " + idReserva + " ha sido eliminado correctamente.");
                                System.out.println("Volviendo al menu...");
                                siguiente = true;
                            }
                            case "N", "n" -> {
                                // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                                System.out.println("Los datos no han sido borrados.");
                                System.out.println("Volviendo al menu...");
                                siguiente = true;
                            }
                            default -> {
                                // Si no se reconoce la respuesta, repetimos la pregunta
                                System.out.println("Respuesta no valida, introduzca un valor valido");
                                System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                                respuesta = MyInput.readString();
                                siguiente = false;
                            }
                        }
                    } while (!siguiente);
                }
            }
        }
        return ResortActual;
    }
    
    /**
     * Metodo encargado de añadir una actividad a la reserva
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     * @throws ParseException
     */
    public Resort agregarActividad(Resort ResortActual) throws ParseException{
        Date fechaInicio, fechaFin;
        int personas;
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
                if (ResortActual.Actividades.isEmpty()){
                    System.out.println("No hay ninguna actividad almacenada en el sistema");
                } else if (!ResortActual.Actividades.isEmpty()){
                    // Solicitamos la id de la actividad
                    System.out.println("");
                    System.out.print("Ingrese la id de la actividad que desea añadir: ");
                    int idActividad = MyInput.readInt();

                    // Comprobamos si la actividad existe
                    boolean existeActividad = false;
                    int actividadAñadir = 0;
                    for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                        if (ResortActual.Reservas.get(i).ID == idReserva) {
                            existeActividad = true;
                            actividadAñadir = i;
                            break;
                        }
                    }

                    // Si la actividad no existe, mostramos un mensaje de error
                    if (!existeActividad) {
                      System.out.println("La actividad con id " + idActividad + " no existe.");
                      System.out.println("Volviendo al menu...");
                    } else if (existeActividad){
                        if (ResortActual.Actividades.get(actividadAñadir).Descripcion.equals("restaurante")){
                            // Solicitamos si la fecha de inicio
                            System.out.print("Ingrese la fecha de la comida: ");
                            fechaInicio = MyInput.readDate();
                            fechaFin = fechaInicio;
                            boolean continuar = false;
                            do {
                                if (fechaFin.before(ResortActual.Reservas.get(reservaAñadir).FechaFin) && fechaInicio.after(ResortActual.Reservas.get(reservaAñadir).FechaInicio)) {
                                    continuar = true;
                                }else{
                                    System.out.println("Fecha no valida, introduzca una fecha valida");
                                    System.out.print("Ingrese la fecha de la comida: ");
                                    fechaInicio = MyInput.readDate();
                                    fechaFin = fechaInicio;
                                }
                            } while (!continuar);
                            personas = 1;
                        }else{
                            // Solicitamos si la fecha de inicio
                            System.out.print("Ingrese la fecha de inicio: ");
                            fechaInicio = MyInput.readDate();

                            // Solicitamos si la fecha de fin
                            System.out.print("Ingrese la fecha de fin: ");
                            fechaFin = MyInput.readDate();
                            
                            boolean continuar = false;
                            do {
                                if (fechaFin.before(ResortActual.Reservas.get(reservaAñadir).FechaFin) && fechaInicio.after(ResortActual.Reservas.get(reservaAñadir).FechaInicio)) {
                                    continuar = true;
                                }else{
                                    System.out.println("Fechas no validas, introduzca fechas validas");
                                    // Solicitamos si la fecha de inicio
                                    System.out.print("Ingrese la fecha de inicio: ");
                                    fechaInicio = MyInput.readDate();

                                    // Solicitamos si la fecha de fin
                                    System.out.print("Ingrese la fecha de fin: ");
                                    fechaFin = MyInput.readDate();
                                }
                            } while (!continuar);

                            // Solicitamos el número de personas
                            System.out.print("Ingrese el número de personas que van a participar: ");
                            personas = MyInput.readInt();
                            
                            continuar = false;
                            do {
                                if (personas <= ResortActual.Reservas.get(reservaAñadir).Personas || personas > 0) {
                                    continuar = true;
                                }else{
                                    System.out.println("Número de personas no valido, introduzca un número valido");
                                    // Solicitamos el número de personas
                                    System.out.print("Ingrese el número de personas que van a participar: ");
                                    personas = MyInput.readInt();
                                }
                            } while (!continuar);
                            
                            
                        }
                        System.out.println("");
                        System.out.println("ID Actividad: " + ResortActual.Actividades.get(actividadAñadir).ID);
                        System.out.println("Descripción: " + ResortActual.Actividades.get(actividadAñadir).Descripcion);
                        System.out.println("Precio: " + ResortActual.Actividades.get(actividadAñadir).Precio);
                        System.out.println("");
                        System.out.println("ID Reserva: " + ResortActual.Reservas.get(reservaAñadir).ID);
                        System.out.println("Nombre: " + ResortActual.Reservas.get(reservaAñadir).Cliente.Nombre);
                        System.out.println("Apellidos: " + ResortActual.Reservas.get(reservaAñadir).Cliente.Apellidos);
                        System.out.println("DNI/NIF: " + ResortActual.Reservas.get(reservaAñadir).Cliente.NumeroFiscal);
                        System.out.println("Telefono: " + ResortActual.Reservas.get(reservaAñadir).Cliente.Telefono);
                        System.out.print("¿Desea añadir esta actividad a esta reserva? (S/N): ");
                        String respuesta = MyInput.readString();
                        boolean siguiente;
                        do {
                            switch (respuesta) {
                                case "S", "s" -> {
                                    // Si la respuesta es afirmativa, guardamos la actividad reservada
                                    ActividadReservada actividadReservada = new ActividadReservada(idActividad, personas, fechaInicio, fechaFin, ResortActual);
                                    ResortActual.Reservas.get(reservaAñadir).ActividadesReservadas.add(actividadReservada);
                                    System.out.println("Operación realizada satisfactoriamente");
                                    System.out.println("Volviendo al menu...");
                                    siguiente = true;
                                }
                                case "N", "n" -> {
                                    // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                                    System.out.println("Los datos no han sido añadidos.");
                                    System.out.println("Volviendo al menu...");
                                    siguiente = true;
                                }
                                default -> {
                                    // Si no se reconoce la respuesta, repetimos la pregunta
                                    System.out.println("Respuesta no valida, introduzca un valor valido");
                                    System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                                    respuesta = MyInput.readString();
                                    siguiente = false;
                                }
                            }
                        } while (!siguiente);
                    }
                }
            }
        }
        return ResortActual;
    }
    
    /**
     * Metodo encargado de eliminar una actividad reservada de una reserva
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     */
    public Resort eliminarActividad(Resort ResortActual){
        if (ResortActual.Reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!ResortActual.Reservas.isEmpty()){
            // Solicitamos la id de la reserva
            System.out.println("");
            System.out.print("Ingrese la id de la reserva donde se encuentra la actividad que desea eliminar: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si la reserva existe
            boolean existeReserva = false;
            int reservaEliminar = 0;
            for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                if (ResortActual.Reservas.get(i).ID == idReserva) {
                    existeReserva = true;
                    reservaEliminar = i;
                    break;
                }
            }

            // Si la reserva no existe, mostramos un mensaje de error
            if (!existeReserva) {
              System.out.println("La reserva con id " + idReserva + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeReserva){
                if (ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.isEmpty()){
                    System.out.println("No hay ninguna actividad reservada en esta reserva");
                } else if (!ResortActual.Reservas.isEmpty()){
                    // Solicitamos la id de la reserva
                    System.out.println("");
                    System.out.print("Ingrese la id de la actividad que desea eliminar: ");
                    int idActividad = MyInput.readInt();

                    // Comprobamos si la reserva existe
                    boolean existeActividad = false;
                    int actividadEliminar = 0;
                    for (int i = 0; i < ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.size(); i++) {
                        if (ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(i).IDActividad == idActividad) {
                            existeActividad = true;
                            actividadEliminar = i;
                            break;
                        }
                    }
                    if (!existeActividad) {
                        System.out.println("La actividad con id " + idActividad + " no existe.");
                        System.out.println("Volviendo al menu...");
                    } else if (existeActividad){
                        Date fechaActual = new Date();
                        // Si la actividad esta en uso, mostramos un mensaje de error
                        if (ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).FechaInicio.after(fechaActual)) {
                            System.out.println("La actividad con id " + idActividad + " está en ejecución. No se puede eliminar.");
                            System.out.println("Volviendo al menu...");
                        } else if (!ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).FechaInicio.after(fechaActual)) {
                            // Imprime los datos de la actividad reservada
                            System.out.println("");
                            System.out.println("ID Actividad: " + ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).IDActividad);
                            System.out.println("Número de personas: " + ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).Personas);
                            System.out.println("Fecha inicio: " + ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).FechaInicio);
                            System.out.println("Fecha fin: " + ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).FechaFin);
                            System.out.println("Descripción: " + ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).Descripcion);
                            System.out.println("Precio: " + ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.get(actividadEliminar).Precio);
                            System.out.print("¿Desea eliminar esta actividad reservada? (S/N): ");
                            String respuesta = MyInput.readString();
                            boolean siguiente;
                            do {
                                switch (respuesta) {
                                    case "S", "s" -> {
                                        // Si la respuesta es afirmativa, eliminamos la reserva del array
                                        ResortActual.Reservas.get(reservaEliminar).ActividadesReservadas.remove(actividadEliminar);
                                        System.out.println("La actividad reservada con id " + idActividad + " ha sido eliminada correctamente.");
                                        System.out.println("Volviendo al menu...");
                                        siguiente = true;
                                    }
                                    case "N", "n" -> {
                                        // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                                        System.out.println("Los datos no han sido borrados.");
                                        System.out.println("Volviendo al menu...");
                                        siguiente = true;
                                    }
                                    default -> {
                                        // Si no se reconoce la respuesta, repetimos la pregunta
                                        System.out.println("Respuesta no valida, introduzca un valor valido");
                                        System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                                        respuesta = MyInput.readString();
                                        siguiente = false;
                                    }
                                }
                            } while (!siguiente);
                        }
                    }
                }
            }
        }
        return ResortActual;
    }
    
    /**
     * Metodo encargado de mostrar las reservas de un bungalo
     * @param ResortActual Almacen de datos del sistema
     */
    public void listarReservas(Resort ResortActual){
        if (ResortActual.Bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!ResortActual.Bungalos.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese la id del bungalo que desea buscar: ");
            int idBungalo = MyInput.readInt();

            // Comprobamos si el bungalo existe
            boolean existeBungalo = false;
            for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                if (ResortActual.Bungalos.get(i).ID == idBungalo) {
                    existeBungalo = true;
                    break;
                }
            }
        
            // Si el bungalo no existe, mostramos un mensaje de error
            if (!existeBungalo) {
              System.out.println("El bungalo con id " + idBungalo + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeBungalo){
                if (ResortActual.Reservas.isEmpty()){
                    System.out.println("No hay ninguna reserva almacenada en el sistema");
                } else if (!ResortActual.Reservas.isEmpty()){
                    for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                        if (ResortActual.Reservas.get(i).IDBungalo == idBungalo) {
                            System.out.println("RESERVAS DEL BUNGALO "+idBungalo);
                            System.out.println("");
                            System.out.println("ID Bungalo: " + ResortActual.Reservas.get(i).IDBungalo);
                            System.out.println("ID: " + ResortActual.Reservas.get(i).ID);
                            System.out.println("Nombre: " + ResortActual.Reservas.get(i).Cliente.Nombre);
                            System.out.println("Apellidos: " + ResortActual.Reservas.get(i).Cliente.Apellidos);
                            System.out.println("DNI/NIF: " + ResortActual.Reservas.get(i).Cliente.NumeroFiscal);
                            System.out.println("Telefono: " + ResortActual.Reservas.get(i).Cliente.Telefono);
                            System.out.println("Fecha inicio: " + ResortActual.Reservas.get(i).FechaInicio);
                            System.out.println("Fecha fin: " + ResortActual.Reservas.get(i).FechaFin);
                            System.out.println("Número de personas: " + ResortActual.Reservas.get(i).Personas);
                            System.out.println("Servicios: " + ResortActual.Reservas.get(i).Servicios);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Metodo encargado de mostrar una reserva en concreto
     * @param ResortActual Almacen de datos del sistema
     */
    public void mostrarReserva(Resort ResortActual){
        if (ResortActual.Reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!ResortActual.Reservas.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese la id de la reserva que desea buscar: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si el bungalo existe
            boolean existeReserva = false;
            int reservaMostrar = 0;
            for (int i = 0; i < ResortActual.Reservas.size(); i++) {
                if (ResortActual.Reservas.get(i).ID == idReserva) {
                    existeReserva = true;
                    reservaMostrar = i;
                    break;
                }
            }
        
            // Si la reserva no existe, mostramos un mensaje de error
            if (!existeReserva) {
              System.out.println("La reserva con id " + idReserva + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeReserva){
                // Mostramos la informacion de la reserva
                System.out.println("");
                System.out.println("ID Bungalo: " + ResortActual.Reservas.get(reservaMostrar).IDBungalo);
                System.out.println("ID: " + ResortActual.Reservas.get(reservaMostrar).ID);
                System.out.println("Nombre: " + ResortActual.Reservas.get(reservaMostrar).Cliente.Nombre);
                System.out.println("Apellidos: " + ResortActual.Reservas.get(reservaMostrar).Cliente.Apellidos);
                System.out.println("DNI/NIF: " + ResortActual.Reservas.get(reservaMostrar).Cliente.NumeroFiscal);
                System.out.println("Telefono: " + ResortActual.Reservas.get(reservaMostrar).Cliente.Telefono);
                System.out.println("Fecha inicio: " + ResortActual.Reservas.get(reservaMostrar).FechaInicio);
                System.out.println("Fecha fin: " + ResortActual.Reservas.get(reservaMostrar).FechaFin);
                System.out.println("Número de personas: " + ResortActual.Reservas.get(reservaMostrar).Personas);
                System.out.println("Servicios: " + ResortActual.Reservas.get(reservaMostrar).Servicios);
            }
        }
    }
}
