
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuReservas {
     public static void menu_reservas() {
        int opcion=7;
        while(opcion==7){
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Dar de alta");
            System.out.println("2. Dar de baja");
            System.out.println("3. Añadir actividad");
            System.out.println("4. Eliminar actividad");
            System.out.println("5. Listar reservas");
            System.out.println("6. Mostrar reservas");
            System.out.println("0. Volver atrás");
            String s=MyInput.readString(); //almacena lo que lee en cadena tipo String y lo pasa a int
            try{  
                   opcion= Integer.parseInt(s); //el try intenta pasarlo a int
            }catch(NumberFormatException ex){  //si no se consigue pasar a int
                      System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
                      opcion=7;
            } 
            if((opcion>=0)&&(opcion<=6)){
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
            else if ((opcion<0)||(opcion>6)){
                    System.out.println("opción no válida. Inténtelo de nuevo");
                    opcion=7;
            }
        }
    }

}
