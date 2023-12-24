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
public class MenuActividadesTest {
    
    /**
     *
     */
    public MenuActividadesTest() {
    }
    
    /**
     *
     */
    @BeforeAll
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterAll
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @BeforeEach
    public void setUp() {
    }
    
    /**
     *
     */
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of menu_actividades method, of class MenuActividades.
     */
    @Test
    public void testMenu_actividades() {
        System.out.println("menu_actividades");
        Resort ResortActual = null;
        MenuActividades instance = new MenuActividades();
        Resort expResult = null;
        Resort result = instance.menu_actividades(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirActividad method, of class MenuActividades.
     */
    @Test
    public void testAñadirActividad() {
        System.out.println("a\u00f1adirActividad");
        Resort ResortActual = null;
        MenuActividades instance = new MenuActividades();
        Resort expResult = null;
        Resort result = instance.agregarActividad(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarActividades method, of class MenuActividades.
     */
    @Test
    public void testListarActividades() {
        System.out.println("listarActividades");
        Resort ResortActual = null;
        MenuActividades instance = new MenuActividades();
        instance.listarActividades(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarActividad method, of class MenuActividades.
     */
    @Test
    public void testMostrarActividad() {
        System.out.println("mostrarActividad");
        Resort ResortActual = null;
        MenuActividades instance = new MenuActividades();
        instance.mostrarActividad(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
