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
public class MenuClientesTest {
    
    /**
     *
     */
    public MenuClientesTest() {
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
     * Test of menu_clientes method, of class MenuClientes.
     */
    @Test
    public void testMenu_clientes() {
        System.out.println("menu_clientes");
        Resort ResortActual = null;
        MenuClientes instance = new MenuClientes();
        Resort expResult = null;
        Resort result = instance.menu_clientes(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirCliente method, of class MenuClientes.
     */
    @Test
    public void testAñadirCliente() {
        System.out.println("a\u00f1adirCliente");
        Resort ResortActual = null;
        MenuClientes instance = new MenuClientes();
        Resort expResult = null;
        Resort result = instance.añadirCliente(ResortActual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarClientes method, of class MenuClientes.
     */
    @Test
    public void testListarClientes() {
        System.out.println("listarClientes");
        Resort ResortActual = null;
        MenuClientes instance = new MenuClientes();
        instance.listarClientes(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarCliente method, of class MenuClientes.
     */
    @Test
    public void testMostrarCliente() {
        System.out.println("mostrarCliente");
        Resort ResortActual = null;
        MenuClientes.mostrarCliente(ResortActual);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
