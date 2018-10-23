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
        HttpSession session = request.getSession(); 
        String action = request.getParameter("action");
        switch (action) {
            case "signup":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String username = request.getParameter("username");
                User u = new User(firstName, lastName, email, password, username);
                u.setFirstName(firstName);
                u.setLastName(lastName);
                u.setEmail(email);
                u.setPassword(password);
                u.setUserName(username);
                ArrayList<User> users = new ArrayList<User>();
                users.add(u);
                session.setAttribute("loginFlag", true);
                session.setAttribute("UserData", u);
                request.getRequestDispatcher("products.jsp").include(request, response);
                break;
            case "logoff":
                session.removeAttribute("UserData");
                session.removeAttribute("loginFlag");
                session.invalidate();
                request.getRequestDispatcher("login.jsp").include(request, response);
                break;
            case "login":
                //get user parameter
                String uname = request.getParameter("username");
                User sun = (User) session.getAttribute("UserData");
                String unamesun = sun.getUserName();
                if(uname.equals(unamesun)) {
                    session.setAttribute("loginFlag", true);
                    //change redirect to products.jsp
                    response.sendRedirect("products.jsp");
                }
                else {                
                    //if validate is false, move to login
                    response.sendRedirect("login.jsp");
                }
                break;
            case "authenticate":
                String usernameInDatabase="taz";
                String passwordInDatebase = "1234";
                break;
            default:
                session.invalidate();
                request.getRequestDispatcher("login.jsp").include(request, response);
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
