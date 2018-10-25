/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Axelarator
 */
public class MembershipServlet extends HttpServlet {

    //fields
    ArrayList<User> users = new ArrayList<User>(1000);
    HttpSession session = null;
    
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
            response.setContentType("text/html;charset=UTF-8");
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
        this.session = request.getSession(false);
        if(session == null){
            session = request.getSession(true);
            System.out.println(session.getId());
        }else{}
        //
            String action = request.getParameter("action");
            switch (action) {
                case "signup":
                    String firstName = request.getParameter("first");
                    String lastName = request.getParameter("last");
                    String email = request.getParameter("email");
                    String password = request.getParameter("pass");
                    String username = request.getParameter("user");
                    User u = new User(firstName, lastName, email, password, username);
                    u.setFirstName(firstName);
                    u.setLastName(lastName);
                    u.setEmail(email);
                    u.setPassword(password);
                    u.setUserName(username);
                    
                    request.setAttribute("UserData", u);
                    this.users.add(u);
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                    break;
                case "logoff":
                    System.out.println("in the logoff");
                    session.removeAttribute("UserData");
                    session.removeAttribute("loginFlag");
                    session.invalidate();
                    response.sendRedirect("/4166Page/login.jsp");
                    break;
                case "login":
                    //get user parameter from form
                    String uname = request.getParameter("user");
                    // get users from users list
                    String unameFromArrayList = this.users.get(0).getUserName();
                    //check if user input matches a signed up user
                    if(uname.equals(unameFromArrayList)) {
                        //set flag and users array
                        session.setAttribute("loginFlag", true);
                        session.setAttribute("users", this.users);
                        //forward to products.jsp
                        getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                    }
                    else {                
                        //if validate is false, move to login
                        response.sendRedirect("login.jsp");
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
