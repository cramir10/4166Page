package murach.business;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import murach.business.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.sql.*;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static murach.business.UserTable.conn;
import static murach.business.UserTable.ps;


public class ProductTable {

	
    static String url = "jdbc:mysql://localhost:3306/shop";
    static String username = "user";
    static String password = "123";
    
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
	
	//Static initializer, it runs when the class is intialized (it is executed once)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    
    static {
        try {
            conn = DriverManager.getConnection (url, username, password);
        }
        catch (SQLException e) {
            for (Throwable t : e)
                t.printStackTrace();
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////

    public static List<Product> selectProducts() {
	List<Product> products = new ArrayList<Product>();
        boolean done = false;
        try {
            String p = "select code,description, price from products";
            ps = conn.prepareStatement(p);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Product prod = new Product();
                prod.setCode(rs.getString("code"));
                prod.setDescription(rs.getString("description"));
                prod.setPrice(rs.getDouble("price"));
                                
                products.add(prod);
            }
            done=true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        
        if(!done){
            products = null;
        }
       

        return products;
    }

    public static Product selectProduct(String pCode) {
        Product prod = new Product();
        boolean done = false;
        try {
            String p = "select code,description, price from products where code = ?";
            PreparedStatement ps = conn.prepareStatement(p);
            ps.setString(1, pCode);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                prod.setCode(rs.getString("code"));
                prod.setDescription(rs.getString("description"));
                prod.setPrice(rs.getDouble("price"));
                
            }
            done=true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        
        if(!done){
            prod = null;
        }
        
        return prod;
    }

    public static boolean exists(String pCode) {
        boolean exist = false;
        try {
            String p = "select code,description, price from products where code = ?";
            PreparedStatement ps = conn.prepareStatement(p);
            ps.setString(1, pCode);
            rs = ps.executeQuery();
            
            if(rs != null){
               exist = true; 
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
	return exist;
    }    
    
    private static void saveProducts(List<Product> products) {
	ListIterator<Product> it = products.listIterator();
        String p = "insert into products"
                    + "(code, description, price)"
                    + "values " 
                    + "(?, ?, ?)";
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(p);
            while(it.hasNext()){
                Product prod = it.next();
                ps.setString(1, prod.getCode());
                ps.setString(2, prod.getDescription());
                ps.setDouble(3, prod.getPrice());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insertProduct(Product prod) {
        try {
            String p = "insert into products"
                    + "(code, description, price)"
                    + "values " 
                    + "(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(p);
            ps.setString(1, prod.getCode());
            ps.setString(2, prod.getDescription());
            ps.setDouble(3, prod.getPrice());
            ps.executeUpdate();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
	try {
            String p = "update products set code = ?, id = ?, description = ?"
                                  + "where code = ?";
            ps = conn.prepareStatement(p);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setString(4, product.getCode());
            ps.executeUpdate();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void deleteProduct(Product product) {
	try {
            String p = "delete from products where code = ?";
            ps = conn.prepareStatement(p);
            ps.setString(1, product.getCode());
            ps.executeUpdate();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }    
}
