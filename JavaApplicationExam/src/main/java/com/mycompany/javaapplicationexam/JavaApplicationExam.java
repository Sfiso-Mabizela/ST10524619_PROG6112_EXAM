/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaapplicationexam;
import java.util.Scanner;
/**
 *
 * @author Sfiso
 */
public class JavaApplicationExam {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        // Define the 3 mattress products
        String[] products = {
            "Cozy Nights Monarch", 
            "Restonic Barbados", 
            "Sealy Phuket"
        };

        // 2D Array: 3 rows (products) by 3 columns (months)
        int[][] sales = new int[3][3];

        // Prompt user for sales input matching the sample screenshot
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                sales[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println();

        // Instantiate the Product class and PrintProduct class
        Product productObj = new Product(products, sales);
        PrintProduct printer = new PrintProduct(productObj);

        // Print out the final report
        printer.printReport();
        
        scanner.close();
    }
}

