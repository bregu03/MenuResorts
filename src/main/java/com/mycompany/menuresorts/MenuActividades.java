
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
                        
                    break;
                    
                    case 3:
                        
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
        int capacidad = MyInput.readInt();

        // Solicitamos el nombre del bungalo
        System.out.print("Ingrese el nombre del bungalo: ");
        String nombre = MyInput.readString();

        // Solicitamos el precio del bungalo
        System.out.print("Ingrese el precio del bungalo: ");
        int precio = MyInput.readInt();

        // Solicitamos si el bungalow es accesible para personas con discapacidad
        System.out.print("¿El bungalow es accesible para personas con discapacidad? (S/N): ");
        String respuesta1 = MyInput.readString();
        boolean adaptado, siguiente1;
        adaptado = true;
        do {
            if ((respuesta1.equals("S")) || (respuesta1.equals("s"))){
                // Si la respuesta es afirmativa, cambiamos la variable adaptado a true
                adaptado = true;
                siguiente1 = true;
            } else if ((respuesta1.equals("N")) || (respuesta1.equals("n"))){
                // Si la respuesta es negativa, cambiamos la variable adaptado a false
                adaptado = false;
                siguiente1 = true;
            } else{
                // Si no se reconoce la respuesta, repetimos la pregunta
                siguiente1 = false;
                System.out.println("Respuesta no valida, introduzca un valor valido");
                System.out.print("¿El bungalow es accesible para personas con discapacidad? (S/N): ");
                respuesta1 = MyInput.readString();
            }
        } while (!siguiente1);

        // Solicitamos confirmación para guardar los datos
        System.out.print("¿Son correctos estos datos? (S/N): ");
        String respuesta2 = MyInput.readString();
        boolean siguiente2;
        do {
            if ((respuesta2.equals("S")) || (respuesta2.equals("s"))){
                // Si la respuesta es afirmativa, guardamos los datos
                bungalo bungalo = new bungalo(capacidad, nombre, precio, adaptado, id);
                // Añadimos el bungalo a la lista de bungalos del resort
                resort.bungalos.add(bungalo);
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
    }
}
