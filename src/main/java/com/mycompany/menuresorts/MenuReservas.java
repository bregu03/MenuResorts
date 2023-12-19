
package com.mycompany.menuresorts;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author avbre
 */
public class MenuReservas {
    public static void menu_reservas() throws ParseException {
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
                System.out.println("Regresando al menu principal");
            }else{ 
                switch(opcion){
                    case 1:
                        crearReserva();
                    break;

                    case 2:
                        eliminarReserva();
                    break;
                    
                    case 3:
                        añadirActividad();
                    break;
                    
                    case 4:
                        eliminarActividad();
                    break;
                    
                    case 5:
                        
                    break;
                    
                    case 6:
                        
                    break;
                    
                    case 0:
                        //volver al main menuresorts
                    break;
                     
                   
                }
            }
        }while (opcion!=0);
    }
    
    public static void crearReserva() throws ParseException{
        System.out.println("");
        // Solicitamos si el bungalo a de ser accesible para personas con discapacidad
        System.out.print("¿El bungalo tiene que ser adaptado? (S/N): ");
        String respuesta1 = MyInput.readString();
        
        boolean adaptado, siguiente1;
        adaptado = true;
        do {
            if ((respuesta1.equals("S")) || (respuesta1.equals("s"))){
                // Si la respuesta es afirmativa, buscamos bungalos adaptados
                adaptado = true;
                siguiente1 = true;
            } else if ((respuesta1.equals("N")) || (respuesta1.equals("n"))){
                // Si la respuesta es negativa, buscamos bungalos no adaptados
                adaptado = false;
                siguiente1 = true;
            } else{
                // Si no se reconoce la respuesta, repetimos la pregunta
                siguiente1 = false;
                System.out.println("Respuesta no valida, introduzca un valor valido");
                System.out.print("¿El bungalo tiene que ser adaptado? (S/N): ");
                respuesta1 = MyInput.readString();
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
        if (resort.bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!resort.bungalos.isEmpty()){
            System.out.println("");
            System.out.println("BUNGALOS DISPONIBLES");
            for (int i = 0; i < resort.bungalos.size(); i++) {
                if (resort.bungalos.get(i).adaptado == adaptado && resort.bungalos.get(i).capacidad == personas) {
                    if (!resort.reservas.isEmpty()){
                        for (int n = 0; n < resort.reservas.size(); n++) {
                            if (resort.bungalos.get(i).id == resort.reservas.get(n).idBungalo){
                                if (fechaFin.before(resort.reservas.get(n).fechaInicio) || fechaInicio.after(resort.reservas.get(n).fechaFin)) {
                                    // Bloque de código a ejecutar si los intervalos no se solapan
                                    System.out.println("");
                                    System.out.println("Capacidad: " + resort.bungalos.get(n).capacidad);
                                    System.out.println("Nombre: " + resort.bungalos.get(n).nombre);
                                    System.out.println("Precio: " + resort.bungalos.get(n).precio);
                                    System.out.println("Adaptado: " + resort.bungalos.get(n).adaptado);
                                    System.out.println("ID: " + resort.bungalos.get(n).id);
                                    disponible = true;
                                }
                            }
                        }
                    } else if (resort.reservas.isEmpty()){
                        System.out.println("");
                        System.out.println("Capacidad: " + resort.bungalos.get(i).capacidad);
                        System.out.println("Nombre: " + resort.bungalos.get(i).nombre);
                        System.out.println("Precio: " + resort.bungalos.get(i).precio);
                        System.out.println("Adaptado: " + resort.bungalos.get(i).adaptado);
                        System.out.println("ID: " + resort.bungalos.get(i).id);
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

                for (int i = 0; i < resort.bungalos.size(); i++) {
                    if (resort.bungalos.get(i).id == idBungalo && resort.bungalos.get(i).adaptado == adaptado && resort.bungalos.get(i).capacidad == personas) {
                        if (!resort.reservas.isEmpty()){
                            for (int n = 0; n < resort.reservas.size(); n++) {
                                if (resort.bungalos.get(i).id == resort.reservas.get(n).idBungalo){
                                    if (fechaFin.before(resort.reservas.get(n).fechaInicio) && fechaInicio.after(resort.reservas.get(n).fechaFin)) {
                                        disponibleId = true;
                                        break;
                                    }
                                }
                            }
                        } else if (resort.reservas.isEmpty()){
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
            
            boolean servicios = false;
            if (adaptado){
                System.out.print("¿Desea solicitar servicios especiales? (S/N): ");
                String respuesta = MyInput.readString();
                boolean siguiente;
                do {
                    if ((respuesta.equals("S")) || (respuesta.equals("s"))){
                        // Si la respuesta es afirmativa, seleccionamos servicios extra
                        siguiente = true;
                        servicios = true;
                    } else if ((respuesta.equals("N")) || (respuesta.equals("n"))){
                        // Si la respuesta es negativa, no seleccionamos servicios extra
                        siguiente = true;
                        servicios = false;
                    } else{
                        // Si no se reconoce la respuesta, repetimos la pregunta
                        System.out.println("Respuesta no valida, introduzca un valor valido");
                        System.out.print("¿Desea solicitar servicios especiales? (S/N): ");
                        respuesta = MyInput.readString();
                        siguiente = false;
                    }
                } while (!siguiente);
            } else if (!adaptado){
                servicios = false;
            }
            
            // Solicitamos el DNI/NIF del cliente
            System.out.print("Ingrese el DNI/NIF del cliente: ");
            String numeroFiscal = MyInput.readString();
            boolean existeCliente = false;
            String nombre = null;
            String apellidos = null;
            int telefono = 0;
            if (!resort.reservas.isEmpty()){
                // Bucle para comprobar si el DNI/NIF ya existe
                int numeroCliente = 0;
                // Comprobamos si el DNI/NIF ya existe
                existeCliente = false;

                for (int i = 0; i < resort.clientes.size(); i++) {
                    if (resort.clientes.get(i).numeroFiscal == numeroFiscal) {
                        existeCliente = true;
                        numeroCliente = i;
                        break;
                    }
                }

                // Si el DNI/NIF ya existe, rellenamos el resto de datos
                if (existeCliente) {
                    nombre = resort.clientes.get(numeroCliente).nombre;
                    apellidos = resort.clientes.get(numeroCliente).apellidos;
                    telefono = resort.clientes.get(numeroCliente).telefono;
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
            } else if (resort.reservas.isEmpty()){
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
            if (!resort.reservas.isEmpty()){
                // Bucle para comprobar si la id ya existe
                boolean existeId;
                do {
                    // Comprobamos si la id ya existe
                    existeId = false;

                    for (int i = 0; i < resort.reservas.size(); i++) {
                        if (resort.reservas.get(i).id == id) {
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
                if ((respuesta2.equals("S")) || (respuesta2.equals("s"))){
                    // Si la respuesta es afirmativa, guardamos los datos
                    reserva reserva = new reserva(idBungalo, id, nombre, apellidos, numeroFiscal, telefono, fechaInicio, fechaFin, personas, servicios);
                    if (!existeCliente){
                        cliente cliente = new cliente(nombre, apellidos, numeroFiscal, telefono);
                        resort.clientes.add(cliente);
                    }
                    // Añadimos la reserva a la lista de reservas del resort
                    resort.reservas.add(reserva);
                    // Mostramos un mensaje de confirmación
                    System.out.println("Los datos se han guardado correctamente.");
                    System.out.println("Volviendo al menu...");
                    siguiente2 = true;
                } else if ((respuesta2.equals("N")) || (respuesta2.equals("n"))){
                    // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                    System.out.println("Los datos no han sido guardados.");
                    System.out.println("Volviendo al menu...");
                    siguiente2 = true;
                } else{
                    // Si no se reconoce la respuesta, repetimos la pregunta
                    System.out.println("Respuesta no valida, introduzca un valor valido");
                    System.out.print("¿Son correctos estos datos? (S/N): ");
                    respuesta2 = MyInput.readString();
                    siguiente2 = false;
                }
            } while (!siguiente2);
        }else if (!disponible){
            System.out.println("No hay bungalos desponibles que cumplan estas condiciones");
            System.out.println("Volviendo al menu...");
        }
    }
    
    public static void eliminarReserva(){
        if (resort.reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!resort.reservas.isEmpty()){
            // Solicitamos la id de la reserva
            System.out.println("");
            System.out.print("Ingrese la id de la reserva que desea eliminar: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si la reserva existe
            boolean existeReserva = false;
            int reservaEliminar = 0;
            for (int i = 0; i < resort.reservas.size(); i++) {
                if (resort.reservas.get(i).id == idReserva) {
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
                if (resort.reservas.get(reservaEliminar).fechaInicio.before(fechaActual)) {
                    enEjecucion = true;
                }

                // Si la reserva esta en uso, mostramos un mensaje de error
                if (enEjecucion) {
                    System.out.println("La reservao con id " + idReserva + " está en ejecución. No se puede eliminar.");
                    System.out.println("Volviendo al menu...");
                } else if (!enEjecucion) {
                    // Imprime los datos de la reserva
                    System.out.println("");
                    System.out.println("ID Bungalo: " + resort.reservas.get(reservaEliminar).idBungalo);
                    System.out.println("ID: " + resort.reservas.get(reservaEliminar).id);
                    System.out.println("Nombre: " + resort.reservas.get(reservaEliminar).nombre);
                    System.out.println("Apellidos: " + resort.reservas.get(reservaEliminar).apellidos);
                    System.out.println("DNI/NIF: " + resort.reservas.get(reservaEliminar).numeroFiscal);
                    System.out.println("Telefono: " + resort.reservas.get(reservaEliminar).telefono);
                    System.out.println("Fecha inicio: " + resort.reservas.get(reservaEliminar).fechaInicio);
                    System.out.println("Fecha fin: " + resort.reservas.get(reservaEliminar).fechaFin);
                    System.out.println("Número de personas: " + resort.reservas.get(reservaEliminar).personas);
                    System.out.println("Servicios: " + resort.reservas.get(reservaEliminar).servicios);
                    System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                    String respuesta = MyInput.readString();
                    boolean siguiente;
                    do {
                        if ((respuesta.equals("S")) || (respuesta.equals("s"))){
                            // Si la respuesta es afirmativa, eliminamos la reserva del array
                            resort.reservas.remove(reservaEliminar);
                            System.out.println("La reserva con id " + idReserva + " ha sido eliminado correctamente.");
                            System.out.println("Volviendo al menu...");
                            siguiente = true;
                        } else if ((respuesta.equals("N")) || (respuesta.equals("n"))){
                            // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                            System.out.println("Los datos no han sido borrados.");
                            System.out.println("Volviendo al menu...");
                            siguiente = true;
                        } else{
                            // Si no se reconoce la respuesta, repetimos la pregunta
                            System.out.println("Respuesta no valida, introduzca un valor valido");
                            System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                            respuesta = MyInput.readString();
                            siguiente = false;
                        }
                    } while (!siguiente);
                }
            }
        }
    }
    
    public static void añadirActividad() throws ParseException{
        Date fechaInicio, fechaFin;
        int personas;
        if (resort.reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!resort.reservas.isEmpty()){
            // Solicitamos la id de la reserva
            System.out.println("");
            System.out.print("Ingrese la id de la reserva a la que desea añadir la actividad: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si la reserva existe
            boolean existeReserva = false;
            int reservaAñadir = 0;
            for (int i = 0; i < resort.reservas.size(); i++) {
                if (resort.reservas.get(i).id == idReserva) {
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
                if (resort.actividades.isEmpty()){
                    System.out.println("No hay ninguna actividad almacenada en el sistema");
                } else if (!resort.actividades.isEmpty()){
                    // Solicitamos la id de la actividad
                    System.out.println("");
                    System.out.print("Ingrese la id de la actividad que desea añadir: ");
                    int idActividad = MyInput.readInt();

                    // Comprobamos si la reserva existe
                    boolean existeActividad = false;
                    int actividadAñadir = 0;
                    for (int i = 0; i < resort.actividades.size(); i++) {
                        if (resort.reservas.get(i).id == idReserva) {
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
                        if (resort.actividades.get(actividadAñadir).descripcion.equals("restaurante")){
                            // Solicitamos si la fecha de inicio
                            System.out.print("Ingrese la fecha de la comida: ");
                            fechaInicio = MyInput.readDate();
                            fechaFin = fechaInicio;
                            boolean continuar = false;
                            do {
                                if (fechaFin.before(resort.reservas.get(reservaAñadir).fechaFin) && fechaInicio.after(resort.reservas.get(reservaAñadir).fechaInicio)) {
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
                                if (fechaFin.before(resort.reservas.get(reservaAñadir).fechaFin) && fechaInicio.after(resort.reservas.get(reservaAñadir).fechaInicio)) {
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
                                if (personas <= resort.reservas.get(reservaAñadir).personas || personas > 0) {
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
                        System.out.println("ID Actividad: " + resort.actividades.get(actividadAñadir).id);
                        System.out.println("Descripción: " + resort.actividades.get(actividadAñadir).descripcion);
                        System.out.println("Precio: " + resort.actividades.get(actividadAñadir).precio);
                        System.out.println("");
                        System.out.println("ID Reserva: " + resort.reservas.get(reservaAñadir).id);
                        System.out.println("Nombre: " + resort.reservas.get(reservaAñadir).nombre);
                        System.out.println("Apellidos: " + resort.reservas.get(reservaAñadir).apellidos);
                        System.out.println("DNI/NIF: " + resort.reservas.get(reservaAñadir).numeroFiscal);
                        System.out.println("Telefono: " + resort.reservas.get(reservaAñadir).telefono);
                        System.out.print("¿Desea añadir esta actividad a esta reserva? (S/N): ");
                        String respuesta = MyInput.readString();
                        boolean siguiente;
                        do {
                            if ((respuesta.equals("S")) || (respuesta.equals("s"))){
                                // Si la respuesta es afirmativa, guardamos la actividad reservada
                                actividadReservada actividadReservada = new actividadReservada(idActividad, personas, fechaInicio, fechaFin);
                                resort.reservas.get(reservaAñadir).actividadesReservadas.add(actividadReservada);
                                System.out.println("Operación realizada satisfactoriamente");
                                System.out.println("Volviendo al menu...");
                                siguiente = true;
                            } else if ((respuesta.equals("N")) || (respuesta.equals("n"))){
                                // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                                System.out.println("Los datos no han sido añadidos.");
                                System.out.println("Volviendo al menu...");
                                siguiente = true;
                            } else{
                                // Si no se reconoce la respuesta, repetimos la pregunta
                                System.out.println("Respuesta no valida, introduzca un valor valido");
                                System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                                respuesta = MyInput.readString();
                                siguiente = false;
                            }
                        } while (!siguiente);
                    }
                }
            }
        }
    }
    
    public static void eliminarActividad(){
        if (resort.reservas.isEmpty()){
            System.out.println("No hay ninguna reserva almacenada en el sistema");
        } else if (!resort.reservas.isEmpty()){
            // Solicitamos la id de la reserva
            System.out.println("");
            System.out.print("Ingrese la id de la reserva donde se encuentra la actividad que desea eliminar: ");
            int idReserva = MyInput.readInt();

            // Comprobamos si la reserva existe
            boolean existeReserva = false;
            int reservaEliminar = 0;
            for (int i = 0; i < resort.reservas.size(); i++) {
                if (resort.reservas.get(i).id == idReserva) {
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
                if (resort.reservas.get(reservaEliminar).actividadesReservadas.isEmpty()){
                    System.out.println("No hay ninguna actividad reservada en esta reserva");
                } else if (!resort.reservas.isEmpty()){
                    // Solicitamos la id de la reserva
                    System.out.println("");
                    System.out.print("Ingrese la id de la actividad que desea eliminar: ");
                    int idActividad = MyInput.readInt();

                    // Comprobamos si la reserva existe
                    boolean existeActividad = false;
                    int actividadEliminar = 0;
                    for (int i = 0; i < resort.reservas.get(reservaEliminar).actividadesReservadas.size(); i++) {
                        if (resort.reservas.get(reservaEliminar).actividadesReservadas.get(i).idActividad == idActividad) {
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
                        if (resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).fechaInicio.after(fechaActual)) {
                            System.out.println("La actividad con id " + idActividad + " está en ejecución. No se puede eliminar.");
                            System.out.println("Volviendo al menu...");
                        } else if (!resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).fechaInicio.after(fechaActual)) {
                            // Imprime los datos de la actividad reservada
                            System.out.println("");
                            System.out.println("ID Actividad: " + resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).idActividad);
                            System.out.println("Número de personas: " + resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).personas);
                            System.out.println("Fecha inicio: " + resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).fechaInicio);
                            System.out.println("Fecha fin: " + resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).fechaFin);
                            System.out.println("Descripción: " + resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).descripcion);
                            System.out.println("Precio: " + resort.reservas.get(reservaEliminar).actividadesReservadas.get(actividadEliminar).precio);
                            System.out.print("¿Desea eliminar esta actividad reservada? (S/N): ");
                            String respuesta = MyInput.readString();
                            boolean siguiente;
                            do {
                                if ((respuesta.equals("S")) || (respuesta.equals("s"))){
                                    // Si la respuesta es afirmativa, eliminamos la reserva del array
                                    resort.reservas.get(reservaEliminar).actividadesReservadas.remove(actividadEliminar);
                                    System.out.println("La actividad reservada con id " + idActividad + " ha sido eliminada correctamente.");
                                    System.out.println("Volviendo al menu...");
                                    siguiente = true;
                                } else if ((respuesta.equals("N")) || (respuesta.equals("n"))){
                                    // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                                    System.out.println("Los datos no han sido borrados.");
                                    System.out.println("Volviendo al menu...");
                                    siguiente = true;
                                } else{
                                    // Si no se reconoce la respuesta, repetimos la pregunta
                                    System.out.println("Respuesta no valida, introduzca un valor valido");
                                    System.out.print("¿Desea eliminar esta reserva? (S/N): ");
                                    respuesta = MyInput.readString();
                                    siguiente = false;
                                }
                            } while (!siguiente);
                        }
                    }
                }
            }
        }
    }
}
