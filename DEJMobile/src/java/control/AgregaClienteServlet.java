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

    ClienteDAO clientes;
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

        ClienteDTO cliente = new ClienteDTO();
        request.setAttribute("cliente", cliente);
        request.setAttribute("lstCliente", clientes.readAll());
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
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
        ClienteDTO cliente = new ClienteDTO();
        Map<String, String> mapMensajes = new HashMap<>();
        String mensaje;

        //convertir y validar
        cliente.setClave(request.getParameter("clave"));
        if (cliente.getClave().isEmpty()) {
            mapMensajes.put("clave", "Ingrese una Clave");
        }

        cliente.setRut(request.getParameter("rut"));
        if (cliente.getClave().isEmpty()) {
            mapMensajes.put("rut", "Ingrese un rut");
        }

        cliente.setNombre(request.getParameter("nombre"));
        if (cliente.getNombre().isEmpty()) {
            mapMensajes.put("nombre", "Ingrese nombre ");
        }

        cliente.setPaterno(request.getParameter("paterno"));
        if (cliente.getPaterno().isEmpty()) {
            mapMensajes.put("paterno", "Ingrese apellido del paterno");

        }

        cliente.setMaterno(request.getParameter("materno"));
        if (cliente.getMaterno().isEmpty()) {
            mapMensajes.put("materno", "Ingrese apellido  materno");

        }
        cliente.setNumero(request.get);


        //delegar lógica de negocio
        if (mapMensajes.isEmpty()) {
            try {
                clientes.create(cliente);
                mensaje = "Cliente se agregó exitosamente";
                LOG.log(Level.INFO, "Grabó correctamente ");
            } catch (Exception ex) {
                mensaje = ex.getMessage();
                LOG.log(Level.SEVERE, "Error al grabar " + ex.getMessage());
            }
        } else {
            mensaje = "Favor, revise el formulario";
        }
        
        
        request.setAttribute("mapMensajes", mapMensajes);
        //request.setAttribute("mensaje", mensaje);
        request.setAttribute("cliente", cliente);
        request.setAttribute("lstCliente", clientes.readAll());
        request.getRequestDispatcher("/registro.jsp").forward(request, response);
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
    }


}
