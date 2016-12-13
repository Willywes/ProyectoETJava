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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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

    private static final Logger LOG = Logger.getLogger(ControlAcceso.class.getName());

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
        
        HttpSession session = request.getSession(true); 
        
        String mensaje = null;
        String rut = request.getParameter("rut");
        String clave = request.getParameter("pass");
        boolean valido = false;
        //
        ClienteDTO clienteSession = null;
        
        //mensajes de errores para guardar
        Map<String, String> mapMensajes = new HashMap<>();
                
        if (Control.comprobarVacio(rut)) {
            mapMensajes.put("rut", "Ingrese un RUT.");
        } else {
            try {
                String rutTemp = Control.transformarRut(rut);
                if (!Control.validarRut(rutTemp)) {
                    mapMensajes.put("rut", "El RUT no es válido.");
                    rut = "";
                } else {
                    rut = rutTemp;
                }
            } catch (Exception ex) {
                mapMensajes.put("rut", ex.getMessage());
                rut = "";
            }
        }

        if (!Control.comprobarSiExisteRut(rut)) {
            mapMensajes.put("rut", "este RUT no está registrado, debe registrarse.");
            rut = "";
        } else if (Control.comprobarVacio(clave)) {
            mapMensajes.put("clave", "Ingrese una clave.");
        }

        try {
            if (Control.validarPassLogin(rut, clave)) {
                valido = true;
            } else {
                mapMensajes.put("clave", "La clave no coincide.");
            }
        } catch (Exception e) {
            mapMensajes.put("clave", "Ingrese una clave.");
        }

        String devolverRut = rut;

        if (mapMensajes.isEmpty()) {
            clienteSession = new ClienteDAO().read(rut);
            
            session.setAttribute("clienteSession", clienteSession);
            
            try {
                if (valido) {
                    //PrintWriter pw = response.getWriter();
                    LOG.log(Level.INFO, "Inició Sesión" + clienteSession.getRut() + " " + clienteSession.getNombre());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/principal.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    mensaje = "Error, no se pudo iniciar sesión.";
                    LOG.log(Level.INFO, "Intento de Login fallido.");
                }

            } catch (Exception ex) {
                mensaje = ex.getMessage();
                LOG.log(Level.SEVERE, "Error al grabar {0}.", ex.getMessage());
            }
        } else {
            mensaje = "Por favor, revise el formulario";
            clienteSession = null;
        }
        request.setAttribute("devolverRut", devolverRut);
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("cliente", clienteSession);
        request.setAttribute("mapMensajes", mapMensajes);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
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
