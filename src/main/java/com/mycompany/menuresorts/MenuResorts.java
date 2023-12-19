package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuResorts {
    
    static resort resort = new resort();

    public static void main(String[] args) {
        
        resort = MyInput.deserialize("resort.dat");

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
                    case 1:
                        // Gestión de bungalós
                        MenuBungalos.menu_bungalos();
                        break;
                    case 2:
                        // Gestión de clientes
                        MenuClientes.menu_clientes();
                        break;
                    case 3:
                        // Gestión de las actividades
                        MenuActividades.menu_actividades();
                        break;
                    case 4:
                        // Gestión de reservas
                        MenuReservas.menu_reservas();
                        break;
                    case 5:
                        // Gestión de facturación
                        MenuFacturacion.menu_facturacion();
                        break;
                    case 6:
                        // Salvar datos
                        MyInput.serialize(resort, "resort.dat");
                        break;
                }
            }
        } while (opcion != 0);
    }
}
