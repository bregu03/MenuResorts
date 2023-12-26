package com.mycompany.menuresorts;

import java.text.ParseException;

/**
 * Clase encargada del menu principal, almacenamiento y carga de los datos
 * @author avbre
 */
public class MenuResorts {

    /**
     * Metodo encargado del menu principal, carga y guardado de datos
     * @param args Parametro encargado de almacenar todas las variables del programa durante su ejecucion
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        
        Resort ResortActual = new Resort();
        
        Resort ResortCargado;
        ResortCargado = MyInput.deserialize("resort.dat");
        
        if (ResortCargado != null){
            // Si ResortCargado contiene datos
            if (MyInput.getYear(ResortActual.FechaCreacion) == MyInput.getYear(ResortCargado.FechaCreacion) + 1){
                // Si el año actual es igual al año de creacion de los datos mas 1, creamos el historico del año anterior
                MyInput.serialize(ResortCargado, "Históricos/" + MyInput.getYear(ResortCargado.FechaCreacion) + ".dat");
                System.out.println("Historico del año " + MyInput.getYear(ResortCargado.FechaCreacion) + " creado satisfactoriamente.");
            } else {
                // Si no, copiamos los datos de ResortCargado a ResortActual
                ResortActual = ResortCargado;
                System.out.println("Datos cargados satisfactoriamente.");
            }
        }

        int opcion;

        do {
            // Imprimimos el menú
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Gestión de bungalós");
            System.out.println("2. Gestión de clientes");
            System.out.println("3. Gestión de las actividades");
            System.out.println("4. Gestión de reservas");
            System.out.println("5. Gestión de facturación");
            System.out.println("6. Salvar datos");
            System.out.println("0. Salir del programa");

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
            } else if (opcion == 0) {
                // Si el usuario selecciona la opción 0, salimos del programa
                System.out.println("Saliendo del programa...");
            } else {
                // Si la opción es válida, la ejecutamos
                switch (opcion) {
                    case 1 -> {
                        // Crear una instancia de MenuBungalos y llamar a su método no estático
                        MenuBungalos menuBungalos = new MenuBungalos();
                        ResortActual = menuBungalos.menu_bungalos(ResortActual);
                    }
                    case 2 -> {
                        // Crear una instancia de MenuClientes y llamar a su método no estático
                        MenuClientes menuClientes = new MenuClientes();
                        ResortActual = menuClientes.menu_clientes(ResortActual);
                    }
                    case 3 -> {
                        // Crear una instancia de MenuActividades y llamar a su método no estático
                        MenuActividades menuActividades = new MenuActividades();
                        ResortActual = menuActividades.menu_actividades(ResortActual);
                    }
                    case 4 -> {
                        // Crear una instancia de MenuReservas y llamar a su método no estático
                        MenuReservas menuReservas = new MenuReservas();
                        ResortActual = menuReservas.menu_reservas(ResortActual);
                    }
                    case 5 -> {
                        // Crear una instancia de MenuFacturacion y llamar a su método no estático
                        MenuFacturacion menuFacturacion = new MenuFacturacion();
                        ResortActual = menuFacturacion.menu_facturacion(ResortActual);
                    }
                    case 6 -> // Salvar datos
                        MyInput.serialize(ResortActual, "resort.dat");
                }
            }
        } while (opcion != 0);
    }
}