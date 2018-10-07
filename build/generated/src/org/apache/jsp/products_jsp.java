package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class products_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Product Management</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <p>User <a title=\"logout\" href=\"login.jsp\">Logout</a></p>\r\n");
      out.write("        <h1 id=\"head\">Products</h1>\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr id=\"heading\">\r\n");
      out.write("                <th>Code</th>\r\n");
      out.write("                <th>Description</th>\r\n");
      out.write("                <th>Price</th>\r\n");
      out.write("                <th></th>\r\n");
      out.write("                <th></th>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>8601</td>\r\n");
      out.write("                <td>86 (the band) - True Life Songs and Pictures</td>\r\n");
      out.write("                <td>$15.95</td>\r\n");
      out.write("                <td><a title=\"Edit\" href=\"product.jsp\">Edit</a></td>\r\n");
      out.write("                <td><a title=\"Delete\" href=\"confirmDelete.jsp\">Delete</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>pf01</td>\r\n");
      out.write("                <td>Paddlefoot - The first CD</td>\r\n");
      out.write("                <td>$12.95</td>\r\n");
      out.write("                <td><a title=\"Edit\" href=\"product.jsp\">Edit</a></td>\r\n");
      out.write("                <td><a title=\"Delete\" href=\"confirmDelete.jsp.jsp\">Delete</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>pf02</td>\r\n");
      out.write("                <td>Paddlefoot - The second CD</td>\r\n");
      out.write("                <td>$14.95</td>\r\n");
      out.write("                <td><a title=\"Edit\" href=\"product.jsp\">Edit</a></td>\r\n");
      out.write("                <td><a title=\"Delete\" href=\"confirmDelete.jsp\">Delete</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>jr01</td>\r\n");
      out.write("                <td>Joe Rut - Genuine Wood Grained Finish</td>\r\n");
      out.write("                <td>$14.95</td>\r\n");
      out.write("                <td><a title=\"Edit\" href=\"product.jsp\">Edit</a></td>\r\n");
      out.write("                <td><a title=\"Delete\" href=\"confirmDelete.jsp\">Delete</a></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <button class=\"productButton\" id=\"button_add_product\" onClick=\"location.href='product.jsp'\" >Add Product</button>\r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
