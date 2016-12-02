/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author jimmymeneses
 */
public class SolicitudDTO {

    private boolean entrega;
    private int total;
    private Date fecha_hora;
    private ClienteDTO cliente_rut;
    private NavegacionDTO navegacion_id;
    private MinutoDTO minuto_id;
    public SolicitudDTO() {
    }

    public SolicitudDTO(boolean entrega, int total, Date fecha_hora,ClienteDTO cliente_rut,NavegacionDTO navegacion_id,MinutoDTO minuto_id) {
        this.entrega = entrega;
        this.total = total;
        this.fecha_hora = fecha_hora;
        this.cliente_rut=cliente_rut;
        this.navegacion_id=navegacion_id;
        this.minuto_id=minuto_id;
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

    public ClienteDTO getCliente_rut() {
        return cliente_rut;
    }

    public void setCliente_rut(ClienteDTO cliente_rut) {
        this.cliente_rut = cliente_rut;
    }

    public NavegacionDTO getNavegacion_id() {
        return navegacion_id;
    }

    public void setNavegacion_id(NavegacionDTO navegacion_id) {
        this.navegacion_id = navegacion_id;
    }

    public MinutoDTO getMinuto_id() {
        return minuto_id;
    }

    public void setMinuto_id(MinutoDTO minuto_id) {
        this.minuto_id = minuto_id;
    }
 
    
}
