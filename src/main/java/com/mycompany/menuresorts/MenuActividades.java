
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuActividades {
    public static void menu_actividades() {
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
                System.out.println("Regresando al menu principal");
            }else{    
                switch(opcion){
                    case 1:
                        añadirActividad();
                    break;
                    
                    case 2:
                        listarActividades();
                    break;
                    
                    case 3:
                        mostrarActividad();
                    break;
     
                    case 0:
                        //volver al main menuresorts
                    break;
                     
                   
                }
            }
        }while (opcion !=0);
    }
    
    public static void añadirActividad(){
        System.out.println("");
        // Solicitamos la id de la actividad
        System.out.print("Ingrese la id de la actividad: ");
        int id = MyInput.readInt();
        if (!resort.actividades.isEmpty()){
            // Bucle para comprobar si la id ya existe
            boolean existeId;
            do {
                // Comprobamos si la id ya existe
                existeId = false;

                for (int i = 0; i < resort.actividades.size(); i++) {
                    if (resort.actividades.get(i).id == id) {
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
        System.out.print("Introduzca una descripción de la actividad: ");
        String descripcion = MyInput.readString();

        // Solicitamos el precio de la actividad por persona y dia
        System.out.print("Ingrese el precio de la actividad por persona y dia: ");
        int precio = MyInput.readInt();

        // Solicitamos confirmación para guardar los datos
        System.out.print("¿Son correctos estos datos? (S/N): ");
        String respuesta = MyInput.readString();
        boolean siguiente;
        do {
            if ((respuesta.equals("S")) || (respuesta.equals("s"))){
                // Si la respuesta es afirmativa, guardamos los datos
                actividad actividad = new actividad(id, descripcion, precio);
                // Añadimos la actividad a la lista de actividades del resort
                resort.actividades.add(actividad);
                // Mostramos un mensaje de confirmación
                System.out.println("Los datos se han guardado correctamente.");
                System.out.println("Volviendo al menu...");
                siguiente = true;
            } else if ((respuesta.equals("N")) || (respuesta.equals("n"))){
                // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                System.out.println("Los datos no han sido guardados.");
                System.out.println("Volviendo al menu...");
                siguiente = true;
            } else{
                // Si no se reconoce la respuesta, repetimos la pregunta
                System.out.println("Respuesta no valida, introduzca un valor valido");
                System.out.print("¿Son correctos estos datos? (S/N): ");
                respuesta = MyInput.readString();
                siguiente = false;
            }
        } while (!siguiente);
    }
    
    public static void listarActividades(){
        if (resort.actividades.isEmpty()){
            System.out.println("No hay ninguna actividad almacenada en el sistema");
        } else if (!resort.actividades.isEmpty()){
            System.out.println("");
            System.out.println("ACTIVIDADES");
            for (int i = 0; i < resort.actividades.size(); i++) {
                System.out.println("");
                System.out.println("ID: " + resort.actividades.get(i).id);
                System.out.println("Descripción: " + resort.actividades.get(i).descripcion);
            }
        }
    }
    
    public static void mostrarActividad(){
        if (resort.actividades.isEmpty()){
            System.out.println("No hay ninguna actividad almacenada en el sistema");
        } else if (!resort.actividades.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese la id de la actividad que desea buscar: ");
            int idActividad = MyInput.readInt();

            // Comprobamos si la actividad existe
            boolean existeActividad = false;
            int actividadMostrar = 0;
            for (int i = 0; i < resort.actividades.size(); i++) {
                if (resort.actividades.get(i).id == idActividad) {
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
                System.out.println("ID: " + resort.actividades.get(actividadMostrar).id);
                System.out.println("Descripción: " + resort.actividades.get(actividadMostrar).descripcion);
                System.out.println("Precio: " + resort.actividades.get(actividadMostrar).precio);
            }
        }
    }
}
