/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import conexion.Conexion;
import dao.ClienteDAO;
import dto.ClienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vina
 */
@WebServlet(name = "ListarSolicitudServlet", urlPatterns = {"/ListarSolicitudServlet"})
public class ListarSolicitudServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ListarSolicitudServlet.class.getName());

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
            out.println("<title>Servlet ListarSolicitudServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarSolicitudServlet at " + request.getContextPath() + "</h1>");
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
        ClienteDAO cliente = new ClienteDAO();

        String idSolicitud = request.getParameter("idSolicitud");

        if (idSolicitud == null || idSolicitud.isEmpty()) {
            request.setAttribute("solicitud", cliente.read(Integer.parseInt(idSolicitud)));
        } else {
            request.setAttribute("solicitud", cliente.read(Integer.parseInt(idSolicitud)));
        }

        request.setAttribute("solicitud", cliente.readAll());
        request.getRequestDispatcher("principal.jsp").forward(request, response);

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
        response.setContentType("text/html;charset=UTF-8");

        String idSolicitud = request.getParameter("idSolicitud");
        ClienteDAO cliente = new ClienteDAO();
        cliente.delete(Integer.parseInt(idSolicitud));
        request.setAttribute("mensaje", "Se ha eliminado la Solicitud.");

        if (idSolicitud == null || idSolicitud.isEmpty()) {
            request.setAttribute("solicitud", cliente.read(Integer.parseInt(idSolicitud)));
        } else {
            request.setAttribute("solicitud", cliente.read(Integer.parseInt(idSolicitud)));
        }

        request.setAttribute("solicitud", cliente.readAll());
        request.getRequestDispatcher("principal.jsp").forward(request, response);
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
