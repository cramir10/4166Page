package edu.uncc.nbad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        //Get action parameter
        String action = request.getParameter("action");
      
        //User is logged in
        //Make a big decision
        switch (action) {
            case "displayProducts":
                //Call getProducts method to grab products from text file and put inside ArrayList of Products to put into session attribute
               
                getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
                break;
            case "addProduct":
                getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
                break;

            case "deleteProduct":
                //Call getProduct method to grab product from text file and put inside request attribute
                // not implemented
                break;
            case "actuallyDelete":
                System.out.println("Requested to delete" + request.getParameter("productCode"));
                 // not implemented
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
        //Get action parameter
        String action = request.getParameter("action");
        //If user is not logged in, forward to the login page
        if (action.equals("login")) {
            
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            
            if (user.getPassword()==null)
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            else
            {
                getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
            }
        }

        //User is logged in, proceed to updateProduct if appropriate action parameter
        switch (action) {
            case "updateProduct":
            {       // not implemented
                String productCode = request.getParameter("productCode");
                
                    break;
                    }
            case "addProduct":
                    //Get the the values to put into the new product
                    String code = request.getParameter("code");
                    String desc = request.getParameter("description");
                    double price = Double.parseDouble(request.getParameter("price"));

                    //Create new product object and put in the values
                    Product newProduct = new Product();
                    newProduct.setCode(code);
                    newProduct.setDescription(desc);
                    newProduct.setPrice(price);
                    
                    //get the product list from the session, if any 
                    HttpSession session = request.getSession();
                    
                    ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
                    
                    if(products==null)
                    {
                        products =  new ArrayList<>();
                        
                    }
                    
                    //add product to list
                    products.add(newProduct);
                    
                    // replacing the old list in the session by a the new list (that contains the new product we just added)
                    session.removeAttribute("products");
                    session.setAttribute("products", products);
                    
                    //Redirect back to products page
                    getServletContext().getRequestDispatcher("/products.jsp").forward(request, response);
               
                break;
            default:
                break;
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


/*
        String message;
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        double price2 = Double.parseDouble(price);
       
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
            p.setPrice(price2);
            String url = "/products.jsp";
            getServletContext().getRequestDispatcher(url).forward(request,response);
//            Cookie c = new Cookie("code", code);
//            Cookie d = new Cookie("description", description);
//            Cookie pr = new Cookie("price", price);
//            response.addCookie(c); 
//            response.addCookie(d); 
//            response.addCookie(pr);
//            Cookie[] cookies = request.getCookies();
//            String cookieCode = "code";
//            String cookieDes = "description";
//            String cookiePrice = "price";
//            for(Cookie cookie : cookies) {
//                if(cookieCode.equals(cookie.getCode()))
//                    cookieDes = cookie.getDescription();
//            }
        }
*/
