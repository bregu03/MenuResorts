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
public class MenuFacturacionTest {
    
    /**
     *
     */
    public MenuFacturacionTest() {
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
     * Test of menu_facturacion method, of class MenuFacturacion.
     */
    @Test
    public void testMenu_facturacion() {
        System.out.println("menu_facturacion");
        Resort ResortActual = null;
        MenuFacturacion instance = new MenuFacturacion();
        Resort expResult = null;
        Resort result = instance.menu_facturacion(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarFactura method, of class MenuFacturacion.
     */
    @Test
    public void testGenerarFactura() {
        System.out.println("generarFactura");
        Resort ResortActual = null;
        MenuFacturacion instance = new MenuFacturacion();
        Resort expResult = null;
        Resort result = instance.generarFactura(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of facturasCliente method, of class MenuFacturacion.
     */
    @Test
    public void testFacturasCliente() {
        System.out.println("facturasCliente");
        Resort ResortActual = null;
        MenuFacturacion instance = new MenuFacturacion();
        instance.facturasCliente(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostarFactura method, of class MenuFacturacion.
     */
    @Test
    public void testMostarFactura() {
        System.out.println("mostarFactura");
        Resort ResortActual = null;
        MenuFacturacion instance = new MenuFacturacion();
        instance.mostarFactura(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
