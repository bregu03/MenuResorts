
package com.mycompany.menuresorts;

/**
 * Clase encargada de la gestion de las actividades
 * @author avbre
 */
public class MenuActividades {

    /**
     * Metodo encargado del menu
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     */
    public Resort menu_actividades(Resort ResortActual) {
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ ACTIVIDADES");
            System.out.println("1. Añadir actividad");
            System.out.println("2. Listar actividades");
            System.out.println("3. Mostrar actividad");
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
                    case 1 -> ResortActual = agregarActividad(ResortActual);
                    
                    case 2 -> listarActividades(ResortActual);
                    
                    case 3 -> mostrarActividad(ResortActual); 
                }
            }
        }while (opcion !=0);
        return ResortActual;
    }
    
    /**
     * Metodo encargado de añadir una actividad al sistema
     * @param ResortActual Almacen de datos del sistema
     * @return ResortActual
     */
    public Resort agregarActividad(Resort ResortActual){
        System.out.println("");
        // Solicitamos la id de la actividad
        System.out.print("Ingrese la id de la actividad: ");
        int id = MyInput.readInt();
        if (!ResortActual.Actividades.isEmpty()){
            // Bucle para comprobar si la id ya existe
            boolean existeId;
            do {
                // Comprobamos si la id ya existe
                existeId = false;

                for (int i = 0; i < ResortActual.Actividades.size(); i++) {
                    if (ResortActual.Actividades.get(i).ID == id) {
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
        
        // Solicitamos la descripción de la actividad
        System.out.print("Introduzca una descripción de la actividad (en caso de ser del restaurante, escriba 'restaurante'): ");
        String descripcion = MyInput.readString();

        // Solicitamos el precio de la actividad por persona y dia
        System.out.print("Ingrese el precio de la actividad por persona y dia: ");
        int precio = MyInput.readInt();

        // Solicitamos confirmación para guardar los datos
        System.out.print("¿Son correctos estos datos? (S/N): ");
        String respuesta = MyInput.readString();
        boolean siguiente;
        do {
            switch (respuesta) {
                case "S", "s" -> {
                    // Si la respuesta es afirmativa, guardamos los datos
                    Actividad actividad = new Actividad(id, descripcion, precio);
                    // Añadimos la actividad a la lista de actividades del resort
                    ResortActual.Actividades.add(actividad);
                    // Mostramos un mensaje de confirmación
                    System.out.println("Los datos se han guardado correctamente.");
                    System.out.println("Volviendo al menu...");
                    siguiente = true;
                }
                case "N", "n" -> {
                    // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                    System.out.println("Los datos no han sido guardados.");
                    System.out.println("Volviendo al menu...");
                    siguiente = true;
                }
                default -> {
                    // Si no se reconoce la respuesta, repetimos la pregunta
                    System.out.println("Respuesta no valida, introduzca un valor valido");
                    System.out.print("¿Son correctos estos datos? (S/N): ");
                    respuesta = MyInput.readString();
                    siguiente = false;
                }
            }
        } while (!siguiente);
        // Guardado de datos por seguridad
        MyInput.serialize(ResortActual, "resort.dat");
        return ResortActual;
    }
    
    /**
     * Metodo encargado de mostrar las actividades almacenadas en el sistema
     * @param ResortActual Almacen de datos del sistema
     */
    public void listarActividades(Resort ResortActual){
        if (ResortActual.Actividades.isEmpty()){
            System.out.println("No hay ninguna actividad almacenada en el sistema");
        } else if (!ResortActual.Actividades.isEmpty()){
            System.out.println("");
            System.out.println("ACTIVIDADES");
            for (int i = 0; i < ResortActual.Actividades.size(); i++) {
                System.out.println("");
                System.out.println("ID: " + ResortActual.Actividades.get(i).ID);
                System.out.println("Descripción: " + ResortActual.Actividades.get(i).Descripcion);
            }
        }
    }
    
    /**
     * Metodo encargado de mostrar los datos de una actividad en concreto
     * @param ResortActual Almacen de datos del sistema
     */
    public void mostrarActividad(Resort ResortActual){
        if (ResortActual.Actividades.isEmpty()){
            System.out.println("No hay ninguna actividad almacenada en el sistema");
        } else if (!ResortActual.Actividades.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese la id de la actividad que desea buscar: ");
            int idActividad = MyInput.readInt();

            // Comprobamos si la actividad existe
            boolean existeActividad = false;
            int actividadMostrar = 0;
            for (int i = 0; i < ResortActual.Actividades.size(); i++) {
                if (ResortActual.Actividades.get(i).ID == idActividad) {
                    existeActividad = true;
                    actividadMostrar = i;
                    break;
                }
            }
        
            // Si la actividad existe, mostramos un mensaje de error
            if (!existeActividad) {
              System.out.println("La actividad con id " + idActividad + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeActividad){
                // Mostramos la informacion de la actividad
                System.out.println("");
                System.out.println("ID: " + ResortActual.Actividades.get(actividadMostrar).ID);
                System.out.println("Descripción: " + ResortActual.Actividades.get(actividadMostrar).Descripcion);
                System.out.println("Precio: " + ResortActual.Actividades.get(actividadMostrar).Precio);
            }
        }
    }
}
