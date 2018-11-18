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
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from products");
            while (myRs.next()) {
                System.out.println(myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
//        return myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price");
        return null;
    }

    public static Product selectProduct(String productCode) {
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from products where id = ?");
            while (myRs.next()) {
                System.out.println(myRs.getString("id"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
//        return myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price");
        return null;
    }

    public static boolean exists(String productCode) {
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from products where id = ?");
            if(myRs == null) {
                System.out.println("That ID doesn't exist");
            }
            else
                System.out.println(myRs.getString("id"));
                  
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
//        return myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price");
        return false;
    }    
    
    private static void saveProducts(List<Product> products) {
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from products where id = ?");
            while (myRs.next()) {
                System.out.println(myRs.getString("id"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
//        return myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price");
    }

    public static void insertProduct(Product product) {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            String preparedsql = "insert into products"
                    + "(code, description, price)"
                    + "values " 
                    + "(?, ?, ?)";
            PreparedStatement ps = myConn.prepareStatement(preparedsql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            String preparedsql = "update products set id = ?, " + "code = ?," + "id = ?," + "description = ?"
                                  + "where code = ?";
            PreparedStatement ps = myConn.prepareStatement(preparedsql);
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
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            String preparedsql = "delete from products where code = ?";
            PreparedStatement ps = myConn.prepareStatement(preparedsql);
            ps.setString(1, product.getCode());
            ps.executeUpdate();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }    
}
