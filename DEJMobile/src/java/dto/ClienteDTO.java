/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Willywes
 */
public class ClienteDTO {
    
    String clave;
    String rut;
    String nombre;
    String paterno;
    String materno;
    String direccion;
    String numero;
    ComunaDTO comuna_id;
    int telefono;

    public ClienteDTO(){
    }
    
    public ClienteDTO(String clave, String rut, String nombre, String paterno, String materno, String direccion, String numero, ComunaDTO comuna_id, int telefono) {
        this.clave = clave;
        this.rut = rut;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.direccion = direccion;
        this.numero = numero;
        this.comuna_id = comuna_id;
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public ComunaDTO getComuna_id() {
        return comuna_id;
    }

    public void setComuna_id(ComunaDTO comuna_id) {
        this.comuna_id = comuna_id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
            
    
}
