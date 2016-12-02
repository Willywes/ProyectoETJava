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
import dto.ClienteDTO;
import inteface.CrearCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements CrearCRUD<ClienteDTO> {

    private static final String SQL_INSERT = "INSERT INTO cliente(clave, rut, nombre, paterno, materno, direccion, numero,  comuna_id, telefono) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE rut = ?";
    private static final String SQL_UPDATE = "UPDATE cliente SET clave = ?, nombre = ?, paterno = ?, materno = ?, direccion = ?, numero = ?, comuna_id = ?, telefono = ? WHERE rut = ?";
    private static final String SQL_READ = "SELECT * FROM cliente WHERE rut = ?";
    private static final String SQL_READALL = "SELECT * FROM cliente";

    private static final Conexion con = Conexion.conectar();

    @Override
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
            ps.setInt(8, o.getComunaDTO().getId());
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

    @Override
    public boolean delete(Object key) {
        
        PreparedStatement ps;
        
        try {

            ps = con.getCn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString()); // tratamos al rut como string aunque no deberiamos. el rut no es string
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
    @Override
    public boolean update(ClienteDTO o) {
        PreparedStatement ps;

        try {

            ps = con.getCn().prepareStatement(SQL_UPDATE);
            ps.setString(1, o.getClave());            
            ps.setString(2, o.getNombre());
            ps.setString(3, o.getPaterno());
            ps.setString(4, o.getMaterno());
            ps.setString(5, o.getDireccion());
            ps.setString(6, o.getNumero());
            ps.setInt(7, o.getComunaDTO().getId());            
            ps.setInt(8, o.getTelefono());
            ps.setString(9, o.getRut());

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

    @Override
    public ClienteDTO read(Object key) {

        PreparedStatement ps;
        ResultSet rs;
        ClienteDTO cliente = null;

        try {

            ps = con.getCn().prepareStatement(SQL_READ);
            
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new ClienteDTO(
                        rs.getString(1), 
                        rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                new ComunaDAO().read(rs.getInt(8)),
                rs.getInt(9));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
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
