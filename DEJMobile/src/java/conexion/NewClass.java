package conexion;

import dao.*;
import dto.ClienteDTO;
import dto.ComunaDTO;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Willywes
 */
public class NewClass {

    public static void main(String[] args) {

//        Conexion c  =  Conexion.conectar();
//        
//        if (c != null) {
//            System.out.println("Conectado");
//        }
        ComunaDTO c = new ComunaDTO();
        ComunaDAO cdao = new ComunaDAO();

//      c = cdao.read(1101);
//      System.out.println(c.getId() + " - " + c.getNombre());
//        
//        List<ComunaDTO> lista = cdao.readAll();
//        for (ComunaDTO d : lista) {
//            System.out.println(d.getId() + " - " + d.getNombre());
//        }
        Date date = new Date(100, 00, 01);
        
        System.out.println(date.toString());

        
    }
}
