/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author jimmymeneses
 */
import conexion.Conexion;
import dto.*;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements CrearCRUD<ClienteDTO> {

    private static final String SQL_INSERT = "INSERT INTO cliente( clave,rut, nombre, paterno,materno, direccion, numero,  comuna_id, telefono) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE cliente SET id = ?, nombre = ? WHERE nombre = ? ";
    private static final String SQL_READ = "SELECT * FROM cliente WHERE id = ?";
    private static final String SQL_READALL = "SELECT * FROM cliente";

    private static final Conexion con = Conexion.conectar();

    public boolean create(ClienteDTO o) {

        PreparedStatement ps;

        try {
            ps = con.getCn().prepareStatement(SQL_INSERT);
            ps.setString(1, o.getClave());
            ps.setString(2, o.getRut());
            ps.setString(3, o.getNombre());
            ps.setString(4, o.getPaterno());
            ps.setString(5, o.getMaterno());
            ps.setString(6, o.getDireccion());
            ps.setString(7, o.getNumero());
            ps.setInt(8, o.getComuna_id().getId());
            ps.setInt(9, o.getTelefono());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    public boolean delete(Object key) {
        PreparedStatement ps;
        try {

            ps = con.getCn().prepareStatement(SQL_DELETE);
            ps.setInt(1, (int) key);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return false;
    }

    //este hay que revisarlo
    public boolean update(ClienteDTO o) {
        PreparedStatement ps;

        try {

            ps = con.getCn().prepareStatement(SQL_UPDATE);
            ps.setString(1, o.getClave());
            ps.setString(2, o.getRut());
            ps.setString(2, o.getNombre());
            ps.setString(2, o.getPaterno());
            ps.setString(2, o.getMaterno());
            ps.setString(2, o.getDireccion());
            ps.setInt(2, o.getComuna_id().getId());
            ps.setString(2, o.getNumero());
            ps.setInt(2, o.getTelefono());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return false;
    }

    public ClienteDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        ClienteDTO cliente = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            //ps.setString(2, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                //cliente = new ClienteDTO(rs.getInt(1), rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    public List<ClienteDTO> readAll() {

        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ClienteDTO> listaCliente = new ArrayList();

        try {

            ps = con.getCn().prepareStatement(SQL_READALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                // listaCliente.add(new ClienteDTO(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }

        return listaCliente;
    }

}
