package com.mycompany.menuresorts;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase con utilidades para la entrada de datos desde teclado y fichero 
 * @author jvalvarez
 */
public class MyInput {
    
    
    // Lee una cadena de caracteres desde el teclado

    /**
     * Método que permite leer una cadena de caracteres del teclado
     * @return retorna una cadena de caracteres
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1);
        String  string="";
        try {
                string = br.readLine();
        } catch (IOException ex) {
                System.out.println(ex);
        }
        return string;
    }
    
    
    // Lee un dato tipo int desde el teclado

    /**
     * Método que permite leer un número entero de simple precisión por teclado
     * @return retorna un número entero de precisión simple
     */
    public static int readInt(){
	return Integer.parseInt(readString());
    }
    

    // Lee un dato tipo double desde el teclado

    /**
     * Método que permite leer número real por teclado.
     * @return retorna un número de doble precisión.
     */
    public static double readDouble() {
	return Double.parseDouble(readString());
    }
    
    
    // Lee un dato tipo byte desde el teclado

    /**
     * Método que permite leer un número entero por teclado.
     * @return retorna un número entero comprendido entre -128 y 127 
     */
    public static byte readByte() {
	return Byte.parseByte(readString());
    }
    
    
    // Lee un dato tipo short desde el teclado

    /**
     * Método que permite leer un número entero por teclado.
     * @return retorna un número entero comprendido entre -32768 y 32767 
     */
    public static short readShort() {
	return Short.parseShort(readString());
    }
    
    
    // Lee un dato tipo long desde el teclado

    /**
     * Método que permite leer un número entero de doble precisión por teclado
     * @return retorna un número entero de doble precisión.
     */
    public static long readLong() {
	return Long.parseLong(readString());
    }
    
    
    // Lee un dato tipo date desde el teclado

    /**
     * Método que permite leer una fecha por teclado
     * @return retorna una fecha.
     * @throws java.text.ParseException
     */
    public static Date readDate() throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	return formatoFecha.parse(readString());
    }
    
    
    //Lee un dato tipo float desde el teclado

    /**
     * Método que permite leer número real por teclado
     * @return retorna un número de precisión simple
     */
    public static float readFloat() {
	return Float.parseFloat(readString());
    }

    
    //Almacena una clase en un fichero

    /**
     * Método que permite almacenar una clase en un fichero
     * @param <A>
     * @param a
     * @param nombreFichero
     */
    public static <A> void serialize(A a, String nombreFichero) {
        try {
            FileOutputStream fos = new FileOutputStream(nombreFichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
        } catch (IOException e) {
                System.err.println("Problem: "+e);
        }
    }
    
    
    //Carga una clase con los datos de un fichero

    /**
     * Método que permite cargar una clase con los datos de un fichero
     * @param <A>
     * @param nombreFichero
     * @return retorna los datos de la clase
     */
    public static <A> A deserialize(String nombreFichero) {
        try {
            FileInputStream fis = new FileInputStream(nombreFichero);
            ObjectInputStream iis = new ObjectInputStream(fis);
            return (A) iis.readObject();
        } catch (IOException e) {
            System.err.println("Problem: "+e);
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null ;
    }
}