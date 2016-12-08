/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ComunaDTO;
import dto.SolicitudDTO;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.ControlFecha;

/**
 *
 * @author Willywes
 */
public class SolicitudDAO implements CrearCRUD<SolicitudDTO> {

    private static final String SQL_INSERT = "INSERT INTO solicitud(entrega, total, fecha_hora, cliente_rut, navegacion_id, minuto_id) VALUES(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM solicitud WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE solicitud SET entrega= ?, total= ?, fecha_hora= ?, cliente_rut= ?, navegacion_id= ?, minuto_id = ? WHERE id = ? ";
    private static final String SQL_READ = "SELECT * FROM solicitud WHERE id = ?";
    private static final String SQL_READALL = "SELECT * FROM solicitud";
    private static final String SQL_READALLUSER = "SELECT * FROM solicitud Where cliente_rut=? order by fecha_hora desc";

    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(SolicitudDTO o) {
        PreparedStatement ps;

        try {
            ps = con.getCn().prepareStatement(SQL_INSERT);
            ps.setBoolean(1, o.isEntrega());
            ps.setInt(2, o.getTotal());
            ps.setString(3, ControlFecha.JavaToMySQL(o.getFecha_hora()));
            ps.setString(4, o.getClienteDTO().getRut());
            ps.setInt(5, o.getNavegacionDTO().getId());
            ps.setInt(6, o.getMinutoDTO().getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {

            ps = con.getCn().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int) key);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    @Override
    public boolean update(SolicitudDTO o) {
        PreparedStatement ps;

        try {

            ps = con.getCn().prepareStatement(SQL_UPDATE);
            ps.setBoolean(1, o.isEntrega());
            ps.setInt(2, o.getTotal());
            ps.setString(3, ControlFecha.JavaToMySQL(o.getFecha_hora()));
            ps.setString(4, o.getClienteDTO().getRut());
            ps.setInt(5, o.getNavegacionDTO().getId());
            ps.setInt(6, o.getMinutoDTO().getId());
            ps.setInt(7, o.getId());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return false;
    }

    @Override
    public SolicitudDTO read(Object key) {
        PreparedStatement ps;
        ResultSet rs;
        SolicitudDTO solicitud = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            if (rs.next()) {
                solicitud = new SolicitudDTO(
                        rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getInt(3),
                        ControlFecha.MySQLToJava(rs.getString(4)),
                        new ClienteDAO().read(rs.getString(5)),
                        new NavegacionDAO().read(rs.getInt(6)),
                        new MinutoDAO().read(rs.getInt(7)));
            }

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return solicitud;
    }

    @Override
    public List<SolicitudDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<SolicitudDTO> listaSolicitud = new ArrayList();

        try {

            ps = con.getCn().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                listaSolicitud.add(new SolicitudDTO(
                        rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getInt(3),
                        ControlFecha.MySQLToJava(rs.getString(4)),
                        new ClienteDAO().read(rs.getString(5)),
                        new NavegacionDAO().read(rs.getInt(6)),
                        new MinutoDAO().read(rs.getInt(7))));
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaSolicitud;
    }

    public List<SolicitudDTO> readAllUser(String rut) {
        PreparedStatement ps;

        ResultSet rs;
        ArrayList<SolicitudDTO> listaSolicitud = new ArrayList();

        try {

            ps = con.getCn().prepareStatement(SQL_READALLUSER);
            ps.setString(1, rut);
            rs = ps.executeQuery();

            while (rs.next()) {
                listaSolicitud.add(new SolicitudDTO(
                        rs.getInt(1),
                        rs.getBoolean(2),
                        rs.getInt(3),
                        ControlFecha.MySQLToJava(rs.getString(4)),
                        new ClienteDAO().read(rs.getString(5)),
                        new NavegacionDAO().read(rs.getInt(6)),
                        new MinutoDAO().read(rs.getInt(7))));
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaSolicitud;
    }

}
