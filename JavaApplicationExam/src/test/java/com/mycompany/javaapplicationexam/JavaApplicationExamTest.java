/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.javaapplicationexam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Sfiso
 */
public class JavaApplicationExamTest {
    

    // Dummy data to test our methods cleanly
    String[] testProducts = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    int[][] testSales = {
        {25, 18, 20}, // Total = 63
        {15, 10, 12}, // Total = 37
        {18, 15, 20}  // Total = 53  -> Grand Total = 153
    };

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testProducts, testSales);
        int expectedTotal = 153;
        
        // Assert that the total matches expected calculation
        assertEquals(expectedTotal, product.GetTotalProductSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(testProducts, testSales);
        double expectedAverage = 153.0 / 3.0; // 51.0 (or adjust based on specific test expectations)
        
        // Assert that the average matches expected calculation
        assertEquals(expectedAverage, product.GetAverageProductSold(), 0.01);
    }
}