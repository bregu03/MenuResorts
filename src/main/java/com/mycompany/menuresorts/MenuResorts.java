package com.mycompany.menuresorts;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author avbre
 */
public class MenuResorts {
    
    static resort resort = new resort();

    public static void main(String[] args) {
        
        resort loadedResort = MyInput.deserialize("resort.dat");
        
        Scanner sc = new Scanner(System.in);

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
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                // Si el usuario no introduce un número, lo avisamos
                System.out.println("No has introducido un número.");
                opcion = -1;
            }

            // Comprobamos la opción
            if (opcion < 0 || opcion > 6) {
                // Si la opción no es válida, lo avisamos
                System.out.println("La opción no es válida.");
            } else if (opcion == 0) {
                // Si el usuario selecciona la opción 0, salimos del programa
                System.out.println("Saliendo del programa...");
            } else {
                // Si la opción es válida, la ejecutamos
                switch (opcion) {
                    case 1:
                        // Gestión de bungalós
                        break;
                    case 2:
                        // Gestión de clientes
                        break;
                    case 3:
                        // Gestión de las actividades
                        break;
                    case 4:
                        // Gestión de reservas
                        break;
                    case 5:
                        // Gestión de facturación
                        break;
                    case 6:
                        // Salvar datos
                        break;
                }
            }
        } while (opcion != 0);
        MyInput.serialize(resort, "resort.dat");
    }
}
