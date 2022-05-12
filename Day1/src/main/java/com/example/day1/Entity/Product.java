package com.example.day1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private int id;

    private String ProductName;

    private double price;

}
