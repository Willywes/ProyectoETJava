/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.NavegacionDTO;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NavegacionDAO implements CrearCRUD<NavegacionDTO> {

    private static final String SQL_INSERT = "INSERT INTO navegacion(descripcion, precio) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM navegacion WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE navegacion SET descripcion = ?, precio=? WHERE id = ? ";
    private static final String SQL_READ = "SELECT * FROM navegacion WHERE id = ?";
    private static final String SQL_READALL = "SELECT * FROM navegacion";

    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(NavegacionDTO o) {

        PreparedStatement ps;

        try {
            ps = con.getCn().prepareStatement(SQL_INSERT);
            ps.setString(1, o.getDescripcion());
            ps.setInt(2, o.getPrecio());           

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NavegacionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NavegacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    @Override
    public boolean update(NavegacionDTO o) {
        PreparedStatement ps;

        try {

            ps = con.getCn().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, o.getDescripcion());
            ps.setInt(2, o.getPrecio());            
            ps.setInt(3,o.getId());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NavegacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return false;
    }

    @Override
    public NavegacionDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        NavegacionDTO navegacion = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            ps.setInt(1, (int) key);

            rs = ps.executeQuery();

            if (rs.next()) {
                navegacion = new NavegacionDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NavegacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return navegacion;
    }

    @Override
    public List<NavegacionDTO> readAll() {

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<NavegacionDTO> listaNavegacion = new ArrayList();

        try {

            ps = con.getCn().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                listaNavegacion.add(new NavegacionDTO(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NavegacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaNavegacion;
    }

}
