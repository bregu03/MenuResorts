package com.mycompany.menuresorts;

/**
 * Clase encargada de gestionar los bungalos
 * @author avbre
 */
public class MenuBungalos {

    /**
     * Metodo encargado del menu
     * @param ResortActual
     * @return ResortActual
     */
    public Resort menu_bungalos(Resort ResortActual) {
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
                //volver al main menuresorts
                System.out.println("Regresando al menu principal");
            }else{ 
                switch(opcion){
                    case 1 -> ResortActual = crearBungalo(ResortActual);
                    
                    case 2 -> ResortActual = eliminarBungalo(ResortActual);
                    
                    case 3 -> listarAdaptados(ResortActual);
                    
                    case 4 -> listarNoadaptados(ResortActual);
                    
                    case 5 -> mostrarInfo(ResortActual);
                }
            }
        }while (opcion!=0);
        return ResortActual;
    }
    
    /**
     * Metodo encargado de añadir un bungalo al sistema
     * @param ResortActual
     * @return ResortActual
     */
    public Resort crearBungalo(Resort ResortActual){
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

        // Solicitamos si el bungalo es accesible para personas con discapacidad
        System.out.print("¿El bungalo es accesible para personas con discapacidad? (S/N): ");
        String respuesta1 = MyInput.readString();
        boolean adaptado, siguiente1;
        adaptado = true;
        do {
            switch (respuesta1) {
                case "S", "s" -> {
                    // Si la respuesta es afirmativa, cambiamos la variable adaptado a true
                    adaptado = true;
                    siguiente1 = true;
                }
                case "N", "n" -> {
                    // Si la respuesta es negativa, cambiamos la variable adaptado a false
                    adaptado = false;
                    siguiente1 = true;
                }
                default -> {
                    // Si no se reconoce la respuesta, repetimos la pregunta
                    siguiente1 = false;
                    System.out.println("Respuesta no valida, introduzca un valor valido");
                    System.out.print("¿El bungalo es accesible para personas con discapacidad? (S/N): ");
                    respuesta1 = MyInput.readString();
                }
            }
        } while (!siguiente1);
        
        // Solicitamos la id del bungalo
        System.out.print("Ingrese la id del bungalo: ");
        int id = MyInput.readInt();
        if (!ResortActual.Bungalos.isEmpty()){
            // Bucle para comprobar si la id ya existe
            boolean existeId;
            do {
                // Comprobamos si la id ya existe
                existeId = false;
                for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                    if (ResortActual.Bungalos.get(i).ID == id) {
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
                    Bungalo bungalo = new Bungalo(capacidad, nombre, precio, adaptado, id);
                    // Añadimos el bungalo a la lista de bungalos del resort
                    ResortActual.Bungalos.add(bungalo);
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
        return ResortActual;
    }
    
    /**
     * Metodo encargado de eliminar un bungalo del sistema
     * @param ResortActual
     * @return ResortActual
     */
    public Resort eliminarBungalo(Resort ResortActual){
        if (ResortActual.Bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!ResortActual.Bungalos.isEmpty()){
            // Solicitamos la id del bungalo
            System.out.println("");
            System.out.print("Ingrese la id del bungalo que desea eliminar: ");
            int idBungalo = MyInput.readInt();

            // Comprobamos si el bungalo existe
            boolean existeBungalo = false;
            int bungaloEliminar = 0;
            for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                if (ResortActual.Bungalos.get(i).ID == idBungalo) {
                    existeBungalo = true;
                    bungaloEliminar = i;
                    break;
                }
            }

            // Si el bungalo no existe, mostramos un mensaje de error
            if (!existeBungalo) {
              System.out.println("El bungalo con id " + idBungalo + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeBungalo){
                // Comprobamos si el bungalo está reservado
                boolean estaReservado = false;
                if (ResortActual.Reservas.get(bungaloEliminar).IDBungalo == idBungalo) {
                    estaReservado = true;
                }

                // Si el bungalo está reservado, mostramos un mensaje de error
                if (estaReservado) {
                    System.out.println("El bungalo con id " + idBungalo + " está reservado. No se puede eliminar.");
                    System.out.println("Volviendo al menu...");
                } else if (!estaReservado) {
                    // Imprime los datos del bungalo
                    System.out.println("");
                    System.out.println("Capacidad: " + ResortActual.Bungalos.get(bungaloEliminar).Capacidad);
                    System.out.println("Nombre: " + ResortActual.Bungalos.get(bungaloEliminar).Nombre);
                    System.out.println("Precio: " + ResortActual.Bungalos.get(bungaloEliminar).Precio);
                    System.out.println("Adaptado: " + ResortActual.Bungalos.get(bungaloEliminar).Adaptado);
                    System.out.println("ID: " + ResortActual.Bungalos.get(bungaloEliminar).ID);
                    System.out.print("¿Desea eliminar este bungalo? (S/N): ");
                    String respuesta = MyInput.readString();
                    boolean siguiente;
                    do {
                        switch (respuesta) {
                            case "S", "s" -> {
                                // Si la respuesta es afirmativa, eliminamos el bungalo del array
                                ResortActual.Bungalos.remove(bungaloEliminar);
                                System.out.println("El bungalo con id " + idBungalo + " ha sido eliminado correctamente.");
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
                                System.out.print("¿Desea eliminar este bungalo? (S/N): ");
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
     * Metodo encargado de listar los bungalos adaptados
     * @param ResortActual
     */
    public void listarAdaptados(Resort ResortActual){
        if (ResortActual.Bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!ResortActual.Bungalos.isEmpty()){
            System.out.println("");
            System.out.println("BUNGALOS ADAPTADOS");
            for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                if (ResortActual.Bungalos.get(i).Adaptado == true) {
                    System.out.println("");
                    System.out.println("ID: " + ResortActual.Bungalos.get(i).ID);
                    System.out.println("Capacidad: " + ResortActual.Bungalos.get(i).Capacidad);
                }
            }
        }
    }
    
    /**
     * Metodo encargado de listar los bungalos no adaptados
     * @param ResortActual
     */
    public void listarNoadaptados(Resort ResortActual){
        if (ResortActual.Bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!ResortActual.Bungalos.isEmpty()){
            System.out.println("");
            System.out.println("BUNGALOS NO ADAPTADOS");
            for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                if (ResortActual.Bungalos.get(i).Adaptado == false) {
                    System.out.println("");
                    System.out.println("ID: " + ResortActual.Bungalos.get(i).ID);
                    System.out.println("Capacidad: " + ResortActual.Bungalos.get(i).Capacidad);
                }
            }
        }
    }
    
    /**
     * Metodo encargado de mostrar la informacion de un bungalo en concreto
     * @param ResortActual
     */
    public void mostrarInfo(Resort ResortActual){
        if (ResortActual.Bungalos.isEmpty()){
            System.out.println("No hay ningun bungalo almacenado en el sistema");
        } else if (!ResortActual.Bungalos.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese la id del bungalo que desea buscar: ");
            int idBungalo = MyInput.readInt();

            // Comprobamos si el bungalo existe
            boolean existeBungalo = false;
            int bungaloMostrar = 0;
            for (int i = 0; i < ResortActual.Bungalos.size(); i++) {
                if (ResortActual.Bungalos.get(i).ID == idBungalo) {
                    existeBungalo = true;
                    bungaloMostrar = i;
                    break;
                }
            }
        
            // Si el bungalo no existe, mostramos un mensaje de error
            if (!existeBungalo) {
              System.out.println("El bungalo con id " + idBungalo + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeBungalo){
                // Mostramos la informacion del bungalo
                System.out.println("");
                System.out.println("Capacidad: " + ResortActual.Bungalos.get(bungaloMostrar).Capacidad);
                System.out.println("Nombre: " + ResortActual.Bungalos.get(bungaloMostrar).Nombre);
                System.out.println("Precio: " + ResortActual.Bungalos.get(bungaloMostrar).Precio);
                System.out.println("Adaptado: " + ResortActual.Bungalos.get(bungaloMostrar).Adaptado);
                System.out.println("ID: " + ResortActual.Bungalos.get(bungaloMostrar).ID);
            }
        }
    }
}

