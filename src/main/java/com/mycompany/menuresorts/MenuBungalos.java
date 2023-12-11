
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuBungalos {
     public static void menu_bungalos() {
        int opcion=6;
        while(opcion==6){
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Dar de alta");
            System.out.println("2. Dar de baja");
            System.out.println("3. Listar adaptados");
            System.out.println("4. Listar no adaptados");
            System.out.println("5. Mostrar información");
            System.out.println("0. Volver atrás");
            String s=MyInput.readString(); //almacena lo que lee en cadena tipo String y lo pasa a int
            try{  
                   opcion= Integer.parseInt(s); //el try intenta pasarlo a int
            }catch(NumberFormatException ex){  //si no se consigue pasar a int
                      System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
                      opcion=6;
            } 
            if((opcion>=0)&&(opcion<=5)){
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
            else if ((opcion<0)||(opcion>5)){
                    System.out.println("opción no válida. Inténtelo de nuevo");
                    opcion=6;
            }
        }
    }
}

