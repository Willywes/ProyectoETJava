/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.MinutoDTO;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MinutoDAO implements CrearCRUD<MinutoDTO> {

    private static final String SQL_INSERT = "INSERT INTO minuto(id, descripcion,precio) VALUES(?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM minuto WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE minuto SET id = ?, descripcion = ?, precio=? WHERE descripcion = ? ";
    private static final String SQL_READ = "SELECT * FROM minuto WHERE id = ?";
    private static final String SQL_READALL = "SELECT * FROM minuto";

    private static final Conexion con = Conexion.conectar();

    public boolean create(MinutoDTO o) {

        PreparedStatement ps;

        try {
            ps = con.getCn().prepareStatement(SQL_INSERT);
            ps.setInt(1, o.getId());
            ps.setInt(2, o.getPrecio());
            ps.setString(3, o.getDescripcion());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    public boolean delete(Object key) {
        PreparedStatement ps;
        try {

            ps = con.getCn().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int) key);//aqui deberia ir la id, pero si es autoincrementable 
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

    public boolean update(MinutoDTO o) {
        PreparedStatement ps;

        try {

            ps = con.getCn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, o.getPrecio());
            ps.setString(1, o.getDescripcion());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return false;
    }

    public MinutoDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        MinutoDTO minuto = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            ps.setString(2, key.toString());
           // ps.setInt(3, (int)(key).toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                // minuto = new MinutoDTO(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MinutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return minuto;
    }

    public List<MinutoDTO> readAll() {

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<MinutoDTO> listaMinuto = new ArrayList();

        try {

            ps = con.getCn().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                 listaMinuto.add(new MinutoDTO(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MinutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaMinuto;
    }
}
