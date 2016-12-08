/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import dto.ClienteDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilidades.Control;
import static utilidades.Control.comprobarSiExisteRut;

/**
 *
 * @author jimmymeneses
 */
@WebServlet(name = "ControlAcceso", urlPatterns = {"/login"})
public class ControlAcceso extends HttpServlet {

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
            out.println("<title>Servlet ControlAcceso</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControlAcceso at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        //variables 

        String rut = request.getParameter("rut");
        String clave = request.getParameter("pass");
        //
        ClienteDTO cliente = null;
        //mensajes de errores para guardar
        Map<String, String> mapMensajes = new HashMap<>();

        String redireccion = ("index.jsp");

        if (Control.comprobarVacio(rut)) {
            mapMensajes.put("rut", "Ingrese un RUT.");
        }

        try {
            String rutTemp = Control.transformarRut(rut);
            if (!Control.validarRut(rutTemp)) {
                mapMensajes.put("rut", "El RUT no esta Registrado .");
                rut = "";
            } else {
                rut = rutTemp;
            }
        } catch (Exception ex) {
            mapMensajes.put("rut", ex.getMessage());
            rut = "";
        }

        if (!Control.comprobarSiExisteRut(rut)) {
            mapMensajes.put("cliente", "este RUT no está registrado, debe registrarse.");
            rut = "";
        } else if (!Control.comprobarVacio(clave)) {

            if (Control.comprobarPass(rut, clave)) {
                //ahi vamos a logear
                HttpSession loginSession = request.getSession(true);
                redireccion = ("principal.jsp");
                cliente = new ClienteDAO().read(rut);
                loginSession.setAttribute("cliente", cliente);
                PrintWriter pw = response.getWriter();

            }
        } else {
            mapMensajes.put("clave", "Ingrese una Clave");
        }
        request.setAttribute("cliente", cliente);

        request.setAttribute("mapMensajes", mapMensajes);

        request.getRequestDispatcher(redireccion).forward(request, response);
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
