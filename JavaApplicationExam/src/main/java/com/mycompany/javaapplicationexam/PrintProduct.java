/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaapplicationexam;

/**
 *
 * @author Sfiso
 */

 // Class responsible for printing the report data to the console
public class PrintProduct {
 

    private IProduct product;

    // Constructor takes an IProduct implementation
    public PrintProduct(IProduct product) {
        this.product = product;
    }

    // Method to print the report summary
    public void printReport() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
        System.out.println("**************************************************");
    }
}  

