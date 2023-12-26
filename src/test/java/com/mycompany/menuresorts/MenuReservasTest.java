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
public class MenuReservasTest {
    
    public MenuReservasTest() {
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
     * Test of menu_reservas method, of class MenuReservas.
     */
    @Test
    public void testMenu_reservas() throws Exception {
        System.out.println("menu_reservas");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        Resort expResult = null;
        Resort result = instance.menu_reservas(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearReserva method, of class MenuReservas.
     */
    @Test
    public void testCrearReserva() throws Exception {
        System.out.println("crearReserva");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        Resort expResult = null;
        Resort result = instance.crearReserva(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarReserva method, of class MenuReservas.
     */
    @Test
    public void testEliminarReserva() {
        System.out.println("eliminarReserva");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        Resort expResult = null;
        Resort result = instance.eliminarReserva(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregarActividad method, of class MenuReservas.
     */
    @Test
    public void testAgregarActividad() throws Exception {
        System.out.println("agregarActividad");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        Resort expResult = null;
        Resort result = instance.agregarActividad(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarActividad method, of class MenuReservas.
     */
    @Test
    public void testEliminarActividad() {
        System.out.println("eliminarActividad");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        Resort expResult = null;
        Resort result = instance.eliminarActividad(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarReservas method, of class MenuReservas.
     */
    @Test
    public void testListarReservas() {
        System.out.println("listarReservas");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        instance.listarReservas(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarReserva method, of class MenuReservas.
     */
    @Test
    public void testMostrarReserva() {
        System.out.println("mostrarReserva");
        Resort ResortActual = null;
        MenuReservas instance = new MenuReservas();
        instance.mostrarReserva(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
