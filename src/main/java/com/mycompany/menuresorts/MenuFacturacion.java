package com.mycompany.menuresorts;

/**
 * Clase encargada de gestionar las facturas
 * @author avbre
 */
public class MenuFacturacion {

    /**
     * Metodo encargado del menu
     * @param ResortActual
     * @return ResortActual
     */
    public Resort menu_facturacion(Resort ResortActual) {
        int opcion;
        do{
            System.out.println("");
            System.out.println("MENÚ FACTURACIÓN");
            System.out.println("1. Generar facturación");
            System.out.println("2. Facturas cliente");
            System.out.println("3. Mostrar factura");
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
                    case 1 -> ResortActual = generarFactura(ResortActual);
                    
                    case 2 -> facturasCliente(ResortActual);
                    
                    case 3 -> mostarFactura(ResortActual);
                }
            }
        }while (opcion!=0);
        return ResortActual;
    }
    
    public Resort generarFactura(Resort ResortActual){
        return ResortActual;
    }
    
    public void facturasCliente(Resort ResortActual){
        
    }
    
    public void mostarFactura(Resort ResortActual){
        
    }
}
