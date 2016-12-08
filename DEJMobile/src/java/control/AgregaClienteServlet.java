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
@WebServlet(name = "AgregaClienteServlet", urlPatterns = {"/registrar-cliente"})
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

        //datos para el dispatcher
        String redireccion = "/registro.jsp";
        // recibir datos
        String rut = request.getParameter("rut").toUpperCase();
        String clave = request.getParameter("clave");
        String claveConfirmar = request.getParameter("clave-confirmar");
        String nombre = request.getParameter("nombre").toUpperCase();
        String paterno = request.getParameter("paterno").toUpperCase();
        String materno = request.getParameter("materno").toUpperCase();
        String direccion = request.getParameter("direccion").toUpperCase();
        String numero = request.getParameter("numero").toUpperCase();
        String idComunaS = request.getParameter("id-comuna");
        String telefonoS = request.getParameter("telefono");

        int idComuna = 0;
        int telefono = 0;
        boolean success = false;

        // instacias
        ClienteDTO cliente;
        Map<String, String> mapMensajes = new HashMap<>();
        String mensaje;

        if (Control.comprobarVacio(rut)) {
            mapMensajes.put("rut", "Ingrese un RUT.");
        }

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

        if (Control.comprobarSiExisteRut(rut)) {
            mapMensajes.put("rut", "este RUT ya está registrado, pruebe iniciar sesión.");
            rut = "";
        }
        if (Control.comprobarVacio(clave)) {
            mapMensajes.put("clave", "Ingrese una Clave");
        }
        if (Control.comprobarVacio(claveConfirmar)) {
            mapMensajes.put("clave-confirmar", "Ingrese nuevamente la Clave.");
        }
        if (!Control.comprobarPass(clave, claveConfirmar)) {
            mapMensajes.put("clave-confirmar", "las claves no coinciden.");
        }
        if (Control.comprobarVacio(nombre)) {
            mapMensajes.put("nombre", "Ingrese un nombre.");
        }
        if (Control.comprobarVacio(paterno)) {
            mapMensajes.put("paterno", "Ingrese un apellido paterno.");
        }
        if (Control.comprobarVacio(materno)) {
            mapMensajes.put("materno", "Ingrese un apellido materno.");
        }
        if (Control.comprobarVacio(direccion)) {
            mapMensajes.put("direccion", "Ingrese una dirección.");
        }
        if (Control.comprobarVacio(numero)) {
            mapMensajes.put("numero", "Ingrese un número en la dirección.");
        }
        if (Control.comprobarVacio(idComunaS)) {
            mapMensajes.put("id-comuna", "Seleccione una comuna.");
        }

        try {
            idComuna = Integer.parseInt(idComunaS);
        } catch (Exception e) {
            mapMensajes.put("id-comuna", "Seleccione una comuna.");
        }

        if (Control.comprobarVacio(telefonoS)) {
            mapMensajes.put("telefono", "Ingrese un número de teléfono.");
        } else {
            try {
                telefono = Integer.parseInt(telefonoS);
                if (telefono < 100000000 || telefono > 1000000000) {
                    mapMensajes.put("telefono", "el número de télefono debe ser de 9 digitos.");
                    telefonoS = "";
                }
            } catch (Exception e) {
                telefonoS = "";
                mapMensajes.put("telefono", "Error al ingresar el número de teléfono.");
            }
        }

        cliente = new ClienteDTO(Encriptar.getMD5(clave), rut, nombre, paterno, materno, direccion, numero, new ComunaDAO().read(idComuna), telefono);

        if (mapMensajes.isEmpty()) {

            ClienteDAO dao = new ClienteDAO();
            try {

                if (dao.create(cliente)) {
                    success = true;
                    mensaje = "Registro Éxitoso.";
                    LOG.log(Level.INFO, "Grabó correctamente.");
                    cliente = null;
                    telefonoS = null;
                    //redireccion ="/index.jsp";

                } else {
                    mensaje = "Error, no se registró el Cliente.";
                    LOG.log(Level.INFO, "NO Grabó correctamente.");
                }

            } catch (Exception ex) {
                mensaje = ex.getMessage();
                LOG.log(Level.SEVERE, "Error al grabar {0}.", ex.getMessage());
            }
        } else {
            mensaje = "Por favor, revise el formulario";
        }

        request.setAttribute("cliente", cliente);
        request.setAttribute("telefono", telefonoS);
        request.setAttribute("mapMensajes", mapMensajes);
        request.setAttribute("success", success);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher(redireccion).forward(request, response);
    }

}
