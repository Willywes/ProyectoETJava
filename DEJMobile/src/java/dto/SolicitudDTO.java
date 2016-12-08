/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.ControlFecha;

/**
 *
 * @author jimmymeneses
 */
public class SolicitudDTO {

    private int id;
    private boolean entrega;
    private int total;
    private Date fecha_hora;
    private ClienteDTO clienteDTO;
    private NavegacionDTO navegacionDTO;
    private MinutoDTO minutoDTO;

    public SolicitudDTO() {
    }

    public SolicitudDTO(boolean entrega, int total, Date fecha_hora, ClienteDTO clienteDTO, NavegacionDTO navegacionDTO, MinutoDTO minutoDTO) {
        this.entrega = entrega;
        this.total = total;
        this.fecha_hora = fecha_hora;
        this.clienteDTO = clienteDTO;
        this.navegacionDTO = navegacionDTO;
        this.minutoDTO = minutoDTO;
    }

    public SolicitudDTO(int id, boolean entrega, int total, Date fecha_hora, ClienteDTO clienteDTO, NavegacionDTO navegacionDTO, MinutoDTO minutoDTO) {
        this.id = id;
        this.entrega = entrega;
        this.total = total;
        this.fecha_hora = fecha_hora;
        this.clienteDTO = clienteDTO;
        this.navegacionDTO = navegacionDTO;
        this.minutoDTO = minutoDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public NavegacionDTO getNavegacionDTO() {
        return navegacionDTO;
    }

    public void setNavegacionDTO(NavegacionDTO navegacionDTO) {
        this.navegacionDTO = navegacionDTO;
    }

    public MinutoDTO getMinutoDTO() {
        return minutoDTO;
    }

    public void setMinutoDTO(MinutoDTO minutoDTO) {
        this.minutoDTO = minutoDTO;
    }

    @Override
    public String toString() {
        return "SolicitudDTO{" + "id=" + id + ", entrega=" + entrega + ", total=" + total + ", fecha_hora=" + ControlFecha.formatearFecha(fecha_hora) + ", clienteDTO=" + clienteDTO.getNombre() + ", navegacionDTO=" + navegacionDTO.getDescripcion() + ", minutoDTO=" + minutoDTO.getDescripcion() + '}';
    }

}
