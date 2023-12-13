
package com.mycompany.menuresorts;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author avbre
 */
public class MenuBungalos {
    static resort resort=new resort();
     public static void menu_bungalos() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Dar de alta");
            System.out.println("2. Dar de baja");
            System.out.println("3. Listar adaptados");
            System.out.println("4. Listar no adaptados");
            System.out.println("5. Mostrar información");
            System.out.println("0. Volver atrás");
            
            System.out.print("Introduce una opcion: ");
            try{  
                   opcion= sc.nextInt(); //el try intenta pasarlo a int
            }catch(InputMismatchException e){  //si no se consigue pasar a int
                      System.out.println("No has introducido un numero.");
                      opcion=-1;
            } 
            if(opcion<0 || opcion>5){
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
                    
                    case 4:
                        
                    break;
                    
                    case 5:
                        
                    break;
                    
                    case 0:
                        //volver al main menuresorts
                    break;
                     
                   
                }
            }
          
        }while (opcion!=0);
    }
}

