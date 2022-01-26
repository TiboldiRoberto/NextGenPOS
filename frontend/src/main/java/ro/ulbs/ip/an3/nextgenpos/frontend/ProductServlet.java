/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ro.ulbs.ip.an3.nextgenpos.frontend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roberto
 */

//@DeclareRoles({"AdminRole","ClientRole"})
//@ServletSecurity (
//        value = @HttpConstraint(
//                rolesAllowed ={"AdminRole"}
//        )
//)

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {
    
    @EJB 
    private ProductsRest restClient;

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
            out.println("<!DOCTYPE html><html><body>");
            List<ProductsDto> products = restClient.listAll();
            /* TODO output your page here. You may use following sample code. */
            out.print("Au fost gasite ");
            out.println(products.size());
            out.println(" produse <br/>");
            out.println("<table border=\"1\" style=\"border-collapse: collapse\">");
            for(ProductsDto prod: products)
            {
                out.print("<tr><td>");
                out.print(prod.getId());
                out.print("</td><td>");
                
                out.print("<tr><td>");
                out.print(prod.getName());
                out.print("</td><td>");
                
                out.print("<tr><td>");
                out.print(prod.getUnit());
                out.print("</td></tr>");
            }
             out.println("</table></body></html>");
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
        
        List<ProductsDto> products = restClient.listAll();
        request.setAttribute("products", products);
        
        request.getRequestDispatcher("/products.jsp").forward(request, response);
        
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
