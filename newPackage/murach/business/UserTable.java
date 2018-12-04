package murach.business;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import murach.business.User;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserTable {
    
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
    
    public static void addRecord(User user) throws IOException {
	try {
            String preparedsql = "insert into users"
                    + "(firstName, lastName, email, password)"
                    + "values " 
                    + "(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(preparedsql);
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
        User user = new User();
        boolean done = false;
        try {
            String p = "select firstName, lastName, email, password from users where email = ?";
            PreparedStatement ps = conn.prepareStatement(p);
            ps.setString(1, emailAddress);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
            done=true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        
        if(!done){
            user = null;
        }
        
        return user;

    }

    public static ArrayList<User> getUsers() throws IOException {
	ArrayList<User> users = new ArrayList<User>();
        boolean done = false;
        try {
            String p = "select firstName, lastName, email, password from users";
            ps = conn.prepareStatement(p);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                
                users.add(user);
            }
            done=true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        
        if(!done){
            users = null;
        }
        
        return users;
    }

    public static HashMap<String, User> getUsersMap() throws IOException {
	 HashMap<String, User> map = new HashMap<>();
         boolean done = false;
        try {
            ps = conn.prepareStatement("select id, firstName, lastName, email, password from users");
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                
                map.put(rs.getString("id"), user);
            }
            done = true;
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        
        if(!done){
            map = null;
        }
        return map;
    }
}
