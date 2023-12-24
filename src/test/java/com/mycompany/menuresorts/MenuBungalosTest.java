/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.menuresorts;

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
public class MenuBungalosTest {
    
    public MenuBungalosTest() {
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
     * Test of menu_bungalos method, of class MenuBungalos.
     */
    @Test
    public void testMenu_bungalos() {
        System.out.println("menu_bungalos");
        Resort ResortActual = null;
        MenuBungalos instance = new MenuBungalos();
        Resort expResult = null;
        Resort result = instance.menu_bungalos(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearBungalo method, of class MenuBungalos.
     */
    @Test
    public void testCrearBungalo() {
        System.out.println("crearBungalo");
        Resort ResortActual = null;
        MenuBungalos instance = new MenuBungalos();
        Resort expResult = null;
        Resort result = instance.crearBungalo(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarBungalo method, of class MenuBungalos.
     */
    @Test
    public void testEliminarBungalo() {
        System.out.println("eliminarBungalo");
        Resort ResortActual = null;
        MenuBungalos instance = new MenuBungalos();
        Resort expResult = null;
        Resort result = instance.eliminarBungalo(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAdaptados method, of class MenuBungalos.
     */
    @Test
    public void testListarAdaptados() {
        System.out.println("listarAdaptados");
        Resort ResortActual = null;
        MenuBungalos instance = new MenuBungalos();
        instance.listarAdaptados(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarNoadaptados method, of class MenuBungalos.
     */
    @Test
    public void testListarNoadaptados() {
        System.out.println("listarNoadaptados");
        Resort ResortActual = null;
        MenuBungalos instance = new MenuBungalos();
        instance.listarNoadaptados(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarInfo method, of class MenuBungalos.
     */
    @Test
    public void testMostrarInfo() {
        System.out.println("mostrarInfo");
        Resort ResortActual = null;
        MenuBungalos instance = new MenuBungalos();
        instance.mostrarInfo(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
