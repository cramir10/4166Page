/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import murach.business.User;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author Axelarator
 */
public class MembershipServlet extends HttpServlet {

    //fields
    ArrayList<User> users = new ArrayList<User>(1000);
//    public static void main(String[] args) {
//        try {
//            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/4166Page", "user", "123");
//            Statement myStmt = myConn.createStatement();
//            ResultSet myRs = myStmt.executeQuery("select * from users");
//            while (myRs.next()) {
//                System.out.println(myRs.getString("lastName") + ", " + myRs.getString("firstName"));
//            }
//        }
//        catch (Exception exc) {
//            exc.printStackTrace();
//        }
//    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MembershipServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MembershipServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get action parameter
        String action = request.getParameter("action");

        //Make a big decision
        switch (action) {
            case "login":
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                break;
            case "signup":
                getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
                break;
            case "logout":
                    //not implemented
                 HttpSession session = request.getSession();
                 session.invalidate();
                 response.sendRedirect("/4166Page/login.jsp");
                break;
            default:
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //trying to not change seesion ids 
        
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            
            switch (action) {
                case "signup":
                    
                    try{
                        // users params
                        String firstName = request.getParameter("first");
                        String lastName = request.getParameter("last");
                        String email = request.getParameter("email");
                        String password = request.getParameter("pass");
                        String username = request.getParameter("user");

                        // validation
                        if(firstName == null || lastName == null || email == null ||
                                password == null || username == null){
                            String message = "please fill out all fields!";
                            request.setAttribute("message",message);
                            getServletContext().getRequestDispatcher("/signup.jsp").forward(request, response);
                        }
                        //set user
                        User u = new User(firstName, lastName, email, password, username);
                        u.setFirstName(firstName);
                        u.setLastName(lastName);
                        u.setEmail(email);
                        u.setPassword(password);
                        u.setUserName(username);
                        System.out.println(u.getUserName());
                        this.users.add(u);

                        session.setAttribute("User", u);
                        session.setAttribute("loginFlag", true);
                        System.out.println("in the signup " +session.getId());
                        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                    }catch(Exception e){
                        System.out.println(e);
                        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                    break;
                case "login":
                    //get user & password parameter from form
                    String user = request.getParameter("user");
                    String pass = request.getParameter("pass");
                    try{
                    
                        User userVar = (User) session.getAttribute("User");
                        
                        if (user.isEmpty() || pass.isEmpty()) {
                            System.out.println("User = empty");
                            String message = "please fill out all fields!";
                            request.setAttribute("message",message);
                            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                        } else if (user == null ||!user.equals(userVar.getUserName())) {
                        //user didn't match any user in the text file
                            System.out.println("user != userVar");
                            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                        } else if (pass == null || !pass.equals(userVar.getPassword())) {
                            System.out.println("pass != userVar");
                            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                        } else {
                            System.out.println("User login");
                        //valid user, so go to display products
                            session.setAttribute("User", userVar);
                            session.setAttribute("loginFlag", true);
                            getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                            }   
                    }catch(Exception e){
                        System.out.println(e);
                        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                        
                    }
                    break;
                default:
                    System.out.println("in default");
                    break;
            }

    }// end post

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}









//        if (username.equals(username) && password.equals(password)) {
//            //get the old session and invalidate
//            HttpSession oldSession = request.getSession();
//            if (oldSession != null) {
//                oldSession.invalidate();
//            }
//            //generate a new session
//            HttpSession newSession = request.getSession(true);
//
//            //setting session to expiry in 5 mins
//            newSession.setMaxInactiveInterval(5*60);
//            
//            newSession.setAttribute("ID", request.getSession().getId());
//            
//            response.sendRedirect("products.jsp");
//        } else {
//             RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
//             PrintWriter out = response.getWriter();
//             out.println("<font color=red>Either username or password is wrong.</font>");
//             rd.include(request, response);
//            }
//        }
        /*
        HttpSession session = request.getSession();
        User user = (session != null) ? (User) session.getAttribute("user") : null;
        String url = "/products.jsp";
        
        if(user == null) {
            response.sendRedirect("/login.jsp");
        }
        else
            getServletContext().getRequestDispatcher(url).forward(request,response);
             
        
        if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            message = "Fill out all fields<br>";
            if(firstName.isEmpty()) {
                message += "firstName, ";
            }
            if(lastName.isEmpty()) {
                message += "lastName, ";
            }
            if(email.isEmpty()) {
                message += "email, ";
            }
            if(password.isEmpty()) {
                message += "password, ";
            }
        }
        else {
            User u = new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setEmail(email);
            u.setPassword(password);
            
            
            session.setAttribute("UserData", u);
            
           
            getServletContext().getRequestDispatcher(url).forward(request,response);
        }
        */
