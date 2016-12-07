/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import dao.ComunaDAO;
import dto.ClienteDTO;
import utilidades.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "AgregaClienteServlet", urlPatterns = {"/AgregaClienteServlet"})
public class AgregaClienteServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AgregaClienteServlet.class.getName());

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
            out.println("<title>Servlet AgregaClienteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregaClienteServlet at " + request.getContextPath() + "</h1>");
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

        // recibir datos
        String rut = request.getParameter("rut");
        String clave = request.getParameter("clave");
        String claveConfirmar = request.getParameter("clave-confirmar");
        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String direccion = request.getParameter("direccion");
        String numero = request.getParameter("numero");
        String idComunaS = request.getParameter("id-comuna");
        String telefonoS = request.getParameter("telefono");
        int idComuna = 0;
        int telefono = 0;

        // instacias
        ClienteDTO cliente;
        Map<String, String> mapMensajes = new HashMap<>();
        String mensaje;

        if (Control.comprobarVacio(rut)) {
            mapMensajes.put("rut", "Ingrese un rut");
        }

//        try {
//            if (!Control.comprobarSiRutEsValido(rut)) {
//                mapMensajes.put("rut", "El Rut no es válido");
//            }
//        } catch (Exception e) {
//            mapMensajes.put("rut", e.getMessage());
//        }

        if (Control.comprobarSiExisteRut(rut)) {
            mapMensajes.put("rut", "este rut ya esta registrado pruebe con otro");
        }
        if (Control.comprobarVacio(clave)) {
            mapMensajes.put("clave", "Ingrese una Clave");
        }
        if (Control.comprobarVacio(claveConfirmar)) {
            mapMensajes.put("clave-confirmar", "Ingrese nuevamente una Clave");
        }
//        if (!Control.comprobarPass(clave, claveConfirmar)) {
//            mapMensajes.put("clave-confirmar", "las claves no coinciden");
//        }        
        if (Control.comprobarVacio(nombre)) {
            mapMensajes.put("nombre", "Ingrese un nombre");
        }
        if (Control.comprobarVacio(paterno)) {
            mapMensajes.put("paterno", "Ingrese un apellido paterno");
        }
        if (Control.comprobarVacio(materno)) {
            mapMensajes.put("materno", "Ingrese un apellido materno");
        }
        if (Control.comprobarVacio(direccion)) {
            mapMensajes.put("direccion", "Ingrese una direccion");
        }
        if (Control.comprobarVacio(numero)) {
            mapMensajes.put("numero", "Ingrese un numero en la direccion");
        }
        if (Control.comprobarVacio(idComunaS)) {
            mapMensajes.put("id-comuna", "Seleccione una Comuna");
        }

        try {
            idComuna = Integer.parseInt(idComunaS);
        } catch (Exception e) {
            mapMensajes.put("id-comuna", "Seleccione una Comuna");
        }

        if (Control.comprobarVacio(telefonoS)) {
            mapMensajes.put("telefono", "Ingrese un telefono");
        }
        try {
            telefono = Integer.parseInt(telefonoS);
        } catch (Exception e) {
            mapMensajes.put("telefono", "Error en el numero de telefono");
        }

        //delegar lógica de negocio
        if (mapMensajes.isEmpty()) {
            cliente = new ClienteDTO(Encriptar.getMD5(clave), rut, nombre, paterno, materno, direccion, numero, new ComunaDAO().read(idComuna), telefono);
            ClienteDAO dao = new ClienteDAO();

            try {

                if (dao.create(cliente)) {
                    mensaje = "Cliente se agregó exitosamente";
                    LOG.log(Level.INFO, "Grabó correctamente ");
                } else {
                    mensaje = "NOOOOOOOO Cliente se agregó exitosamente";
                    LOG.log(Level.INFO, "NO Grabó correctamente ");
                }

            } catch (Exception ex) {
                mensaje = ex.getMessage();
                LOG.log(Level.SEVERE, "Error al grabar {0}", ex.getMessage());
            }
        } else {
            mensaje = "Favor, revise el formulario";
        }

        request.setAttribute("mapMensajes", mapMensajes);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
// @Override
//    public String getServletInfo() {
//        return "Short description";
//    }

