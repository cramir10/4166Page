package edu.uncc.nbad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.uncc.nbad.Product;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Axelarator
 */
public class ProductManagementServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductManagementServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductManagementServlet at " + request.getContextPath() + "</h1>");
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
        String display = "/products.jsp";
        String add = "/product.jsp";
        String delete = "/confirmDelete.jsp";
        if (action == null || !action.equals("displayProducts")
            || !action.equals("addProduct") || !action.equals("displayProduct")
            || !action.equals("deleteProduct")) {
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
        } else if (action.equals("displayProducts")) {
            getServletContext().getRequestDispatcher(display).forward(request, response);

        } else if (action.equals("addProduct")) {
            getServletContext().getRequestDispatcher(add).forward(request, response);


        } else if (action.equals("displayProduct")) {
            getServletContext().getRequestDispatcher(add).forward(request, response);


        } else if (action.equals("deleteProduct")) {
            getServletContext().getRequestDispatcher(delete).forward(request, response);


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
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        double price = request.getParameter("price");
        
        if(code.isEmpty() || description.isEmpty() || price.isEmpty()) {
            message = "Fill out all fields<br>";
            if(code.isEmpty()) {
                message += "code, ";
            }
            if(description.isEmpty()) {
                message += "description, ";
            }
            if(price.isEmpty()) {
                message += "price, ";
            }
        }
        else {
            Product p = new Product();
            p.setCode(code);
            p.setDescription(description);
            p.setPrice(price);
            
            HttpSession session = request.getSession();
            session.setAttribute("UserData", p);
            
            String url = "/products.jsp";
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
