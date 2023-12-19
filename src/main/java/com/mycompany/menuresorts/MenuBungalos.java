
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuBungalos {
     public static void menu_bungalos() {
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ BUNGALOS");
            System.out.println("1. Dar de alta");
            System.out.println("2. Dar de baja");
            System.out.println("3. Listar adaptados");
            System.out.println("4. Listar no adaptados");
            System.out.println("5. Mostrar información");
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
            if (opcion < 0 || opcion > 5) {
                if (opcion != -999){
                    // Si la opción no es válida, lo avisamos
                    System.out.println("La opción no es válida.");
                }
            } else if (opcion == 0){
                System.out.println("Regresando al menu principal");
            }else{ 
                switch(opcion){
                    case 1:
                        crearBungalo();
                    break;
                    
                    case 2:
                        eliminarBungalo();
                    break;
                    
                    case 3:
                        listarAdaptados();
                    break;
                    
                    case 4:
                        listarNoadaptados();
                    break;
                    
                    case 5:
                        mostrarInfo();
                    break;
                    
                    case 0:
                        //volver al main menuresorts
                    break;
                     
                   
                }
            }
          
        }while (opcion!=0);
    }
    
    public static void crearBungalo(){
        System.out.println("");
        // Solicitamos la capacidad del bungalo
        System.out.print("Ingrese la capacidad del bungalo: ");
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
        boolean adaptado;
        if ((respuesta1.equals("S")) || (respuesta1.equals("s"))){
            // Si la respuesta es afirmativa, cambiamos la variable adaptado a true
            adaptado = true;
        } else if ((respuesta1.equals("N")) || (respuesta1.equals("n"))){
            // Si la respuesta es negativa, cambiamos la variable adaptado a false
            adaptado = false;
        } else{
            // Si no se reconoce la respuesta, cambiamos la variable adaptado a false por defecto
            adaptado = false;
        }
        
        // Solicitamos la id del bungalow
        System.out.print("Ingrese la id del bungalo: ");
        int id = MyInput.readInt();
        if (resort.bungalos.isEmpty()){
            // Bucle para comprobar si la id ya existe
            boolean existeId;
            do {
                // Comprobamos si la id ya existe
                existeId = false;

                for (int i = 0; i < resort.bungalos.size(); i++) {
                    if (resort.bungalos.get(i).id == id) {
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
        if ((respuesta2.equals("S")) || (respuesta2.equals("s"))){
            // Si la respuesta es afirmativa, guardamos los datos
            bungalo bungalo = new bungalo(capacidad, nombre, precio, adaptado, id);
            // Añadimos el bungalo a la lista de bungalows del resort
            resort.bungalos.add(bungalo);
            // Mostramos un mensaje de confirmación
            System.out.println("Los datos se han guardado correctamente.");
            System.out.println("Volviendo al menu...");
        } else if ((respuesta2.equals("N")) || (respuesta2.equals("n"))){
            // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
            System.out.println("Los datos no han sido guardados.");
            System.out.println("Volviendo al menu...");
        } else{
            // Si no se reconoce la respuesta, mostramos un mensage indicando que se ha guardado y la id por si lo desea borrar
            System.out.println("Respuesta no valida, los datos han sido guardados por precaución.");
            System.out.println("En caso de querer eliminarlo, la id es: "+ id);
            System.out.println("Volviendo al menu...");
        }
    }
    
    public static void eliminarBungalo(){
        if (resort.bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!resort.bungalos.isEmpty()){
            // Solicitamos la id del bungalo
            System.out.println("");
            System.out.print("Ingrese la id del bungalo que desea eliminar: ");
            int idBungalo = MyInput.readInt();

            // Comprobamos si el bungalo existe
            boolean existeBungalo = false;
            int bungaloeliminar = 0;
            for (int i = 0; i < resort.bungalos.size(); i++) {
                if (resort.bungalos.get(i).id == idBungalo) {
                    existeBungalo = true;
                    bungaloeliminar = i;
                    break;
                }
            }

            // Si el bungalo no existe, mostramos un mensaje de error
            if (!existeBungalo) {
              System.out.println("El bungalow con id " + idBungalo + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeBungalo){
                // Comprobamos si el bungalo está reservado
                boolean estaReservado = false;
                for (int i = 0; i < resort.reservas.size(); i++) {
                    if (resort.reservas.get(i).idBungalo == idBungalo) {
                        estaReservado = true;
                        break;
                    }
                }

                // Si el bungalo está reservado, mostramos un mensaje de error
                if (estaReservado) {
                    System.out.println("El bungalow con id " + idBungalo + " está reservado. No se puede eliminar.");
                    System.out.println("Volviendo al menu...");
                } else if (!estaReservado) {
                    // Imprime los datos del bungalo
                    System.out.println("");
                    System.out.println("Capacidad: " + resort.bungalos.get(bungaloeliminar).capacidad);
                    System.out.println("Nombre: " + resort.bungalos.get(bungaloeliminar).nombre);
                    System.out.println("Precio: " + resort.bungalos.get(bungaloeliminar).precio);
                    System.out.println("Adaptado: " + resort.bungalos.get(bungaloeliminar).adaptado);
                    System.out.println("ID: " + resort.bungalos.get(bungaloeliminar).id);
                    System.out.print("¿Desea eliminar este bungalo? (S/N): ");
                    String respuesta = MyInput.readString();
                    if ((respuesta.equals("S")) || (respuesta.equals("s"))){
                        // Si la respuesta es afirmativa, eliminamos el bungalo del array
                        resort.bungalos.remove(bungaloeliminar);
                        System.out.println("El bungalow con id " + idBungalo + " ha sido eliminado correctamente.");
                        System.out.println("Volviendo al menu...");
                    } else if ((respuesta.equals("N")) || (respuesta.equals("n"))){
                        // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                        System.out.println("Los datos no han sido borrados.");
                        System.out.println("Volviendo al menu...");
                    } else{
                        // Si no se reconoce la respuesta, mostramos un mensage indicando que no se ha borrado
                        System.out.println("Respuesta no valida, los datos no han sido borrados por precaución.");
                        System.out.println("Volviendo al menu...");
                    }
                }
            }
        }
    }
    
    public static void listarAdaptados(){
        if (resort.bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!resort.bungalos.isEmpty()){
            System.out.println("");
            System.out.println("BUNGALOS ADAPTADOS");
            for (int i = 0; i < resort.bungalos.size(); i++) {
                if (resort.bungalos.get(i).adaptado == true) {
                    System.out.println("");
                    System.out.println("ID: " + resort.bungalos.get(i).id);
                    System.out.println("Capacidad: " + resort.bungalos.get(i).capacidad);
                }
            }
        }
    }
    
    public static void listarNoadaptados(){
        if (resort.bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!resort.bungalos.isEmpty()){
            System.out.println("");
            System.out.println("BUNGALOS NO ADAPTADOS");
            for (int i = 0; i < resort.bungalos.size(); i++) {
                if (resort.bungalos.get(i).adaptado == false) {
                    System.out.println("");
                    System.out.println("ID: " + resort.bungalos.get(i).id);
                    System.out.println("Capacidad: " + resort.bungalos.get(i).capacidad);
                }
            }
        }
    }
    
    public static void mostrarInfo(){
        if (resort.bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!resort.bungalos.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese la id del bungalo que desea buscar: ");
            int idBungalo = MyInput.readInt();

            // Comprobamos si el bungalo existe
            boolean existeBungalo = false;
            int bungalomostrar = 0;
            for (int i = 0; i < resort.bungalos.size(); i++) {
                if (resort.bungalos.get(i).id == idBungalo) {
                    existeBungalo = true;
                    bungalomostrar = i;
                    break;
                }
            }
        
            // Si el bungalo no existe, mostramos un mensaje de error
            if (!existeBungalo) {
              System.out.println("El bungalow con id " + idBungalo + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeBungalo){
                // Mostramos la informacion de bungalo
                System.out.println("");
                System.out.println("Capacidad: " + resort.bungalos.get(bungalomostrar).capacidad);
                System.out.println("Nombre: " + resort.bungalos.get(bungalomostrar).nombre);
                System.out.println("Precio: " + resort.bungalos.get(bungalomostrar).precio);
                System.out.println("Adaptado: " + resort.bungalos.get(bungalomostrar).adaptado);
                System.out.println("ID: " + resort.bungalos.get(bungalomostrar).id);
            }
        }
    }
}

