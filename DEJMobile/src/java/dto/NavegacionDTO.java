/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author jimmymeneses
 */
public class NavegacionDTO {
    private int id;
    private String descripcion;
    private int precio;

    public NavegacionDTO() {
    }
    
    public NavegacionDTO(String descripcion, int precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public NavegacionDTO(int id, String descripcion, int precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    

}
