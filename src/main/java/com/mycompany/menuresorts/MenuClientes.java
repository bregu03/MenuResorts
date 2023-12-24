package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuClientes {
    public static void menu_clientes() {
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ CLIENTES");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Mostrar cliente");
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
                    case 1 -> añadirCliente();
                    
                    case 2 -> listarClientes();
                    
                    case 3 -> mostrarCliente();
                }
            }
        }while (opcion!=0);
    }
    
    public static void añadirCliente(){
        System.out.println("");
        // Solicitamos el nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = MyInput.readString();
        
        // Solicitamos los apellidos del cliente
        System.out.print("Ingrese los apellidos del cliente: ");
        String apellidos = MyInput.readString();

        // Solicitamos el DNI/NIF
        System.out.print("Ingrese el DNI/NIF del cliente: ");
        String numeroFiscal = MyInput.readString();
        boolean continuar = true;
        if (!resort.clientes.isEmpty()){
            // Bucle para comprobar si el cliente ya existe
            boolean existeCliente;
            do {
                // Comprobamos si la id ya existe
                existeCliente = false;

                for (int i = 0; i < resort.clientes.size(); i++) {
                    if (resort.clientes.get(i).numeroFiscal.equals(numeroFiscal)) {
                        existeCliente = true;
                        break;
                    }
                }

                // Si la id ya existe, pedimos una nueva
                if (existeCliente) {
                    System.out.println("El DNI/NIF que ha introducido ya existe.");
                    System.out.print("¿Desea continuar con el registro e introducir otro DNI/NIF? (S/N): ");
                    String respuesta1 = MyInput.readString();
                    boolean siguiente1;
                    do {
                        switch (respuesta1) {
                            case "S", "s" -> {
                                // Si la respuesta es afirmativa, continuamos con el registro
                                System.out.print("Por favor, introduzca otro DNI/NIF: ");
                                numeroFiscal = MyInput.readString();
                                continuar = true;
                                siguiente1 = true;
                            }
                            case "N", "n" -> {
                                // Si la respuesta es negativa, mostramos un mensage y volvemos al menu
                                System.out.println("Se ha abortado el prodeso de registro.");
                                System.out.println("Volviendo al menu...");
                                existeCliente = false;
                                continuar = false;
                                siguiente1 = true;
                            }
                            default -> {
                                // Si no se reconoce la respuesta, repetimos la pregunta
                                System.out.println("Respuesta no valida, introduzca un valor valido");
                                System.out.print("¿Desea continuar con el registro e introducir otro DNI/NIF? (S/N): ");
                                respuesta1 = MyInput.readString();
                                siguiente1 = false;
                            }
                        }
                    } while (!siguiente1);
                }
            }while (existeCliente);
        }
        
        if (continuar) {
            // Solicitamos el telefono del cliente
            System.out.print("Ingrese el telefono del cliente: ");
            int telefono = MyInput.readInt();

            // Solicitamos confirmación para guardar los datos
            System.out.print("¿Son correctos estos datos? (S/N): ");
            String respuesta2 = MyInput.readString();
            boolean siguiente2;
            do {
                switch (respuesta2) {
                    case "S", "s" -> {
                        // Si la respuesta es afirmativa, guardamos los datos
                        cliente cliente = new cliente(nombre, apellidos, numeroFiscal, telefono);
                        // Añadimos el cliente a la lista de clientes del resort
                        resort.clientes.add(cliente);
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
        }
    }
    
    public static void listarClientes(){
        if (resort.clientes.isEmpty()){
            System.out.println("No hay ningun cliente almacenado en el sistema");
        } else if (!resort.clientes.isEmpty()){
            System.out.println("");
            System.out.println("CLIENTES");
            for (int i = 0; i < resort.clientes.size(); i++) {
                System.out.println("");
                System.out.println("Nombre: " + resort.clientes.get(i).nombre);
                System.out.println("DNI/NIF: " + resort.clientes.get(i).numeroFiscal);
            }
        }
    }
    
    public static void mostrarCliente(){
        if (resort.clientes.isEmpty()){
            System.out.println("No hay ningun cliente almacenado en el sistema");
        } else if (!resort.clientes.isEmpty()){
            System.out.println("");
            System.out.print("Ingrese el DNI/NIF del cliente que desea buscar: ");
            String numeroFiscal = MyInput.readString();

            // Comprobamos si el cliente existe
            boolean existeCliente = false;
            int clienteMostrar = 0;
            for (int i = 0; i < resort.clientes.size(); i++) {
                if (resort.clientes.get(i).numeroFiscal.equals(numeroFiscal)) {
                    existeCliente = true;
                    clienteMostrar = i;
                    break;
                }
            }
        
            // Si el cliente no existe, mostramos un mensaje de error
            if (!existeCliente) {
              System.out.println("El cliente con DNI/NIF " + numeroFiscal + " no existe.");
              System.out.println("Volviendo al menu...");
            } else if (existeCliente){
                // Mostramos la informacion del cliente
                System.out.println("");
                System.out.println("Nombre: " + resort.clientes.get(clienteMostrar).nombre);
                System.out.println("Apellidos: " + resort.clientes.get(clienteMostrar).apellidos);
                System.out.println("DNI/NIF: " + resort.clientes.get(clienteMostrar).numeroFiscal);
                System.out.println("Telefono: " + resort.clientes.get(clienteMostrar).telefono);
            }
        }
    }
}
