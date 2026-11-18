/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplicationexam;

/**
 *
 * @author Sfiso
 */

   // Product class implementing the IProduct interface
public class Product implements IProduct{


    
    // Fields to hold our data passed from the main application
    private String[] productNames;
    private int[][] salesData;

    // Constructor to initialize arrays
    public Product(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductSold() {
        int total = 0;
        // Loop through each product (rows)
        for (int i = 0; i < salesData.length; i++) {
            // Loop through each month (columns)
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j]; // Add each sale to the grand total
            }
        }
        return total; // Return the final grand total (e.g., 153)
    }

    @Override
    public double GetAverageProductSold() {
        int totalProductsCount = productNames.length; // Number of products (3)
        int grandTotal = GetTotalProductSold();
        
        // Calculate average per product: Total Sales / Number of Products
        return (double) grandTotal / totalProductsCount;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxSales = 0;
        int popularIndex = 0;

        // Loop through products to find the one with the highest total sales
        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
            }

            // Compare with the max found so far
            if (currentProductTotal > maxSales) {
                maxSales = currentProductTotal;
                popularIndex = i; // Save the index of the top-selling product
            }
        }

        // Return formatted string like "Cozy Nights Monarch (25)" or similar based on totals
        return productNames[popularIndex] + " (" + maxSales + ")";
    }
}  
