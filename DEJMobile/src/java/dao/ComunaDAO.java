/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ComunaDTO;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Willywes
 */
public class ComunaDAO implements CrearCRUD<ComunaDTO> {

    private static final String SQL_INSERT = "INSERT INTO comuna(id, nombre) VALUES(?,?)";
    private static final String SQL_DELETE = "DELETE FROM comuna WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE comuna SET nombre = ? WHERE id = ? ";
    private static final String SQL_READ = "SELECT * FROM comuna WHERE id = ?";
    private static final String SQL_READALL = "SELECT * FROM comuna";

    private static final Conexion con = Conexion.conectar();

    @Override
    public boolean create(ComunaDTO o) {

        PreparedStatement ps;

        try {
            ps = con.getCn().prepareStatement(SQL_INSERT);
            ps.setInt(1, o.getId());
            ps.setString(2, o.getNombre());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    @Override
    public boolean update(ComunaDTO o) {
        PreparedStatement ps;

        try {

            ps = con.getCn().prepareStatement(SQL_UPDATE);
            ps.setString(1, o.getNombre());
            ps.setInt(2, o.getId());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return false;
    }

    @Override
    public ComunaDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        ComunaDTO comuna = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            if (rs.next()) {
                comuna = new ComunaDTO(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return comuna;
    }

    @Override
    public List<ComunaDTO> readAll() {

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ComunaDTO> listaComuna = new ArrayList();

        try {

            ps = con.getCn().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                listaComuna.add(new ComunaDTO(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaComuna;
    }

}
