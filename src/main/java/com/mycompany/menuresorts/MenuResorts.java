package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuResorts {

    public static void main(String[] args) {
        int opcion=7;
        while(opcion==7){
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Gestión de bungalós");
            System.out.println("2. Gestión de clientes");
            System.out.println("3. Gestión de las actividades");
            System.out.println("4. Gestión de reservas");
            System.out.println("5. Gestión de facturación");
            System.out.println("6. Salvar datos");
            System.out.println("0. Salir del programa");
            String s=MyInput.readString(); //almacena lo que lee en cadena tipo String y lo pasa a int
            try{  
                   opcion= Integer.parseInt(s); //el try intenta pasarlo a int
            }catch(NumberFormatException ex){  //si no se consigue pasar a int
                      System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
                      opcion=7;
            } 
            if ((opcion<0)||(opcion>6)){
                    System.out.println("opción no válida. Inténtelo de nuevo");
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
                        System.out.println("Gracias por usar nuestro programa");
                    break;
                     
                   
                }
            }
        }
    }
}
