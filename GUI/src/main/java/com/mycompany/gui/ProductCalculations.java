/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

/**
 *
 * @author Sfiso
 */
// Q2.5: The ProductCalculations class implementing the interface
public class ProductCalculations implements IProductCalculations {


    private double price;

    // Constructor to capture the product price entered by the user
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVAT() {
        return price * 0.15; // VAT is 15% of price
    }

    @Override
    public double GetCommission() {
        return price * 0.05; // Commission is 5% of price
    }

    @Override
    public double GetTotal() {
        return price + GetVAT() + GetCommission(); // Price + VAT + Commission
    }
}

