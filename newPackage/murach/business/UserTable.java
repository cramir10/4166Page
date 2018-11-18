package murach.business;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import murach.business.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserTable {
	
	//Static initializer, it runs when the class is intialized (it is executed once)
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }
    
    public static void addRecord(User user) throws IOException {
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            String preparedsql = "insert into users"
                    + "(firstName, lastName, email, password)"
                    + "values " 
                    + "(?, ?, ?, ?)";
            PreparedStatement ps = myConn.prepareStatement(preparedsql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public static User getUser(String emailAddress) throws IOException {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from users where email = ?");
            while (myRs.next()) {
                System.out.println(myRs.getString("email"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
//        return myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price");
        return null;

    }

    public static ArrayList<User> getUsers() throws IOException {
	try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from users");
            while (myRs.next()) {
                System.out.println(myRs.getString("id") + ", " 
                        + myRs.getString("firstName") + ", " 
                        + myRs.getString("lastName") + ", " 
                        + myRs.getString("email"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
//        return myRs.getString("id") + ", " + myRs.getString("code") + ", " + myRs.getString("description") + ", " + myRs.getString("price");
        return null;
    }

    public static HashMap<String, User> getUsersMap() throws IOException {
		throw new NotImplementedException(); // remove this line and implement the logic
    }
}
