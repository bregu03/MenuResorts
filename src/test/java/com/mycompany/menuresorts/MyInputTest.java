/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.menuresorts;

import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Alejandro
 */
public class MyInputTest {
    
    public MyInputTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of readString method, of class MyInput.
     */
    @Test
    public void testReadString() {
        System.out.println("readString");
        String expResult = "";
        String result = MyInput.readString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readInt method, of class MyInput.
     */
    @Test
    public void testReadInt() {
        System.out.println("readInt");
        int expResult = 0;
        int result = MyInput.readInt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readDouble method, of class MyInput.
     */
    @Test
    public void testReadDouble() {
        System.out.println("readDouble");
        double expResult = 0.0;
        double result = MyInput.readDouble();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readByte method, of class MyInput.
     */
    @Test
    public void testReadByte() {
        System.out.println("readByte");
        byte expResult = 0;
        byte result = MyInput.readByte();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readShort method, of class MyInput.
     */
    @Test
    public void testReadShort() {
        System.out.println("readShort");
        short expResult = 0;
        short result = MyInput.readShort();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readLong method, of class MyInput.
     */
    @Test
    public void testReadLong() {
        System.out.println("readLong");
        long expResult = 0L;
        long result = MyInput.readLong();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readDate method, of class MyInput.
     */
    @Test
    public void testReadDate() throws Exception {
        System.out.println("readDate");
        Date expResult = null;
        Date result = MyInput.readDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFloat method, of class MyInput.
     */
    @Test
    public void testReadFloat() {
        System.out.println("readFloat");
        float expResult = 0.0F;
        float result = MyInput.readFloat();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serialize method, of class MyInput.
     */
    @Test
    public void testSerialize() {
        System.out.println("serialize");
        Object a = null;
        String nombreFichero = "";
        MyInput.serialize(a, nombreFichero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deserialize method, of class MyInput.
     */
    @Test
    public void testDeserialize() {
        System.out.println("deserialize");
        String nombreFichero = "";
        Object expResult = null;
        Object result = MyInput.deserialize(nombreFichero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
