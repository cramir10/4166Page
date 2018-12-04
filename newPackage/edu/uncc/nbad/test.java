/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import murach.business.Product;
import murach.business.ProductTable;
import murach.business.User;
import murach.business.UserTable;

/**
 *
 * @author trey
 */
public class test {
    
    public static void main(String args[]){
        
        ProductTable pt = new ProductTable();
        
        try {
            List<Product> ps = pt.selectProducts();
            
            System.out.println(ps.size());
            
            Product p = new Product("1","Not today", 123.45);
            pt.insertProduct(p);
            
            List<Product> px = pt.selectProducts();
            
            System.out.println(px.size());
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
}
