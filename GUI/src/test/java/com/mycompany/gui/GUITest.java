/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.gui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    
/**
 *
 * @author Sfiso
 */
public class GUITest {


public class ProductCalculationsTest {

    @Test
    public void GetVAT_WithValidData_ReturnsCorrectValue() {
        double price = 3500.0;
        ProductCalculations calc = new ProductCalculations(price);
        
        double expectedVAT = 3500.0 * 0.15; // 525.0
        assertEquals(expectedVAT, calc.GetVAT(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        double price = 3500.0;
        ProductCalculations calc = new ProductCalculations(price);
        
        double expectedTotal = 3500.0 + (3500.0 * 0.15) + (3500.0 * 0.05); // 4200.0
        assertEquals(expectedTotal, calc.GetTotal(), 0.01);
    }
}
}
