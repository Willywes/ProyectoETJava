/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dao.ClienteDAO;
import dto.ClienteDTO;

/**
 *
 * @author Willywes
 */
public class Control {
    
    public static boolean comprobarVacio(String s){    
        return s.isEmpty();
    }
    
    public static boolean comprobarPass(String pass, String pass2){    
        return pass.equals(pass2);
    }
    
    public static boolean comprobarSiExisteRut(String rut){
        ClienteDAO dao = new ClienteDAO();
        return dao.ComprobarExiste(rut);
    }
    public static boolean comprobarSiRutEsValido(String rut){
        ClienteDTO dto = new ClienteDTO();
        return dto.validarRut(dto.transformarRut(rut));
    }
}
