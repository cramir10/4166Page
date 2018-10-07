/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.nbad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.uncc.nbad.User;
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
        String action = request.getParameter("action");
        String log = "/login.jsp";
        String sign = "/signup.jsp";
        if (action == null || !action.equals("signup") || !action.equals("login")) {       
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MembershipControllerServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet MembershipControllerServlet at " + request.getContextPath() + "</h1>");
                out.println("<p>Action is " + action + "</p>");
                out.println("<p>Error! The action parameter is required, only signup value is valid</p>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        else if (action.equals("login")) {
            getServletContext().getRequestDispatcher(log).forward(request, response);
        }
        else if (action.equals("signup")) {
            getServletContext().getRequestDispatcher(sign).forward(request, response);
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
        processRequest(request, response);
        String message;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
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
    }

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
