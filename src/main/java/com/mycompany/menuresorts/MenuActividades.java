
package com.mycompany.menuresorts;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author avbre
 */
public class MenuActividades {
    static resort resort=new resort();
     public static void menu_actividades() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Añadir actividad");
            System.out.println("2. Listar actividades");
            System.out.println("3. Mostrar activida");
            System.out.println("0. Volver atrás");
            String s=MyInput.readString(); //almacena lo que lee en cadena tipo String y lo pasa a int
            
            System.out.print("Introduce una opcion: ");
            try{  
                   opcion= sc.nextInt(); //el try intenta pasarlo a int
            }catch(InputMismatchException e){  //si no se consigue pasar a int
                      System.out.println("No has introducido un numéro.");
                      opcion= -1;
            } 
            if(opcion<0 || opcion >6) {
                System.out.println("La opcion no es valda.");
            } else if (opcion == 0){
                System.out.println("Saliendo del progrma...");
            }else{    
                switch(opcion){
                    case 1:
                        
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

}
