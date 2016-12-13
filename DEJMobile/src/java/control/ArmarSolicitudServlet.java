/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import dao.MinutoDAO;
import dao.NavegacionDAO;
import dto.ClienteDTO;
import dto.SolicitudDTO;
import dao.SolicitudDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian
 */
@WebServlet(name = "ArmarSolicitudServlet", urlPatterns = {"/armar-solicitud"})
public class ArmarSolicitudServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ArmarSolicitudServlet.class.getName());

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
            out.println("<title>Servlet agregarPlanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet agregarPlanServlet at " + request.getContextPath() + "</h1>");
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
        
        HttpSession solicitudSession = request.getSession();
        SolicitudDTO solicitud = (SolicitudDTO)solicitudSession.getAttribute("solicitudSession");
        request.setAttribute("solicitud", solicitud);
        request.getRequestDispatcher("/arma-tu-plan.jsp").forward(request, response);
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

        String navegacionS = request.getParameter("navegacion");
        String minutoS = request.getParameter("minutos");        
        boolean entrega = Boolean.parseBoolean(request.getParameter("entrega"));
        
        ClienteDTO cliente = (ClienteDTO) request.getSession().getAttribute("clienteSession");
        String rut = cliente.getRut();
        
        int minuto = 0;
        int navegacion = 0;
        int total = 0;

        HttpSession solicitudSession = request.getSession();
        String redireccion = "/arma-tu-plan.jsp";
    
        SolicitudDTO solicitud = new SolicitudDTO();
        Map<String, String> mapMensajes = new HashMap<>();
        String mensaje = null;

        try {
            navegacion = Integer.parseInt(navegacionS);
        } catch (Exception e) {
            mapMensajes.put("navegacion", "Seleccione una opcion de navegación.");
        }

        try {
            minuto = Integer.parseInt(minutoS);
        } catch (Exception e) {
            mapMensajes.put("minutos", "Seleccione una opcion de minutos.");
        }

        try {
            total = (new NavegacionDAO().read(navegacion).getPrecio()) + (new MinutoDAO().read(minuto).getPrecio());
        } catch (Exception e) {            
        }
        

        solicitud = new SolicitudDTO(entrega, total, new Date(), new ClienteDAO().read(rut), new NavegacionDAO().read(navegacion), new MinutoDAO().read(minuto));
        
        solicitudSession.setAttribute("solicitudSession", solicitud);

        if (mapMensajes.isEmpty()) {      
          // solicitudSession.setAttribute("solicitudSession", solicitud);
            redireccion = "/confirmar-plan.jsp";
        } else {
            mensaje = "Por favor, revise el formulario";
        }


        request.setAttribute("solicitud", solicitud);
        request.setAttribute("mapMensajes", mapMensajes);
        request.setAttribute("mensaje", mensaje);
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
