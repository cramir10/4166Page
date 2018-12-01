/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

/**
 *
 * @author trey
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class ProductTable {

	
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    public static List<Product> selectProducts() {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static Product selectProduct(String productCode) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static boolean exists(String productCode) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }    
    
    private static void saveProducts(List<Product> products) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void insertProduct(Product product) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void updateProduct(Product product) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }

    public static void deleteProduct(Product product) {
		throw new NotImplementedException(); // remove this line and implement the logic
    }    
}
