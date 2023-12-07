
package com.mycompany.menuresorts;

/**
 *
 * @author avbre
 */
public class MenuFacturacion {
     public static void menu_facturacion() {
        int opcion=4;
        while(opcion==4){
            System.out.println("");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1. Generar facturación");
            System.out.println("2. Facturas cliente");
            System.out.println("3. Mostrar factura");
            System.out.println("0. Volver atrás");
            String s=MyInput.readString(); //almacena lo que lee en cadena tipo String y lo pasa a int
            try{  
                   opcion= Integer.parseInt(s); //el try intenta pasarlo a int
            }catch(NumberFormatException ex){  //si no se consigue pasar a int
                      System.out.println("La entrada no tiene formato de número. Inténtelo de nuevo");
                      opcion=4;
            } 
            if((opcion>=0)&&(opcion<=3)){
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
            else if ((opcion<0)||(opcion>3)){
                    System.out.println("opción no válida. Inténtelo de nuevo");
                    opcion=4;
            }
        }
    }

}
