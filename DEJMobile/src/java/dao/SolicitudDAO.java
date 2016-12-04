/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.SolicitudDTO;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolicitudDAO implements CrearCRUD<SolicitudDTO> {

    private static final String SQL_INSERT = "INSERT INTO solicitud(id, nombre) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM solicitud WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE solicitud SET id = ?, nombre = ? WHERE nombre = ? ";
    private static final String SQL_READ = "SELECT * FROM solicitud WHERE id = ?";
    private static final String SQL_READALL = "SELECT * FROM solicitud";

    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(SolicitudDTO o) {

        PreparedStatement ps;

        try {
            ps = con.getCn().prepareStatement(SQL_INSERT);
            ps.setInt(1, o.getId());
            ps.setBoolean(2, o.getEntrega());
            ps.setInt(3, o.getTotal());
            //ps.setTimestamp(3, o.getFecha_hora()); aqui deberia ir la fecha lo buscare
            ps.setString(4, o.getCliente_rut().getRut());
            ps.setInt(5,o.getNavegacion_id().getId()); //al ser autoincrementable no lo podemos poner en el dto ahi q revisar eso
            ps.setInt(6,o.getMinuto_id().getId());
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
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {

            ps = con.getCn().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int) key);//aqui deberia ir la id, pero si es autoincrementable 
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
            ps.setBoolean(1, o.getEntrega());
            ps.setInt(2, o.getTotal());
            //ps.setDate(3, x); aqui deberia ir la fecha lo buscare
            ps.setString(4, o.getCliente_rut().getRut());
            // ps.setString(5, o.getNavegacion_id().getId()); al ser autoincrementable no lo podemos poner en el dto ahi q revisar eso
            //ps.setInt(6,o.getMinuto_id().getId());
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
    public SolicitudDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        SolicitudDTO solicitud = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            //ps.setString(2, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                // solicitud = new SolicitudDTO(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
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
                // listaSolicitud.add(new SolicitudDTO(rs.getString(2),rs.getInt(1),));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaSolicitud;
    }

}
