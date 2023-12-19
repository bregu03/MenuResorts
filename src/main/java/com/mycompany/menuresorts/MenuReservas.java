
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuReservas {
    public static void menu_reservas() {
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
                        
                    break;
                    
                    case 2:
                        
                    break;
                    
                    case 3:
                        
                    break;
                    
                    case 4:
                        
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

}
