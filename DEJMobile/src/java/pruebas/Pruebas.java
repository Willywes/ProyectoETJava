package pruebas;



import dao.*;
import dto.ClienteDTO;
import dto.ComunaDTO;
import dto.MinutoDTO;
import dto.NavegacionDTO;
import dto.SolicitudDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import utilidades.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Willywes
 */
public class Pruebas {

    public static void main(String[] args) {

//        Conexion c  =  Conexion.conectar();
//        
//        if (c != null) {
//            System.out.println("Conectado");
//        }
//        ComunaDTO c = new ComunaDTO();
//        ComunaDAO cdao = new ComunaDAO();
//
//      c = cdao.read(1101);
//      System.out.println(c.getId() + " - " + c.getNombre());
//        
//        List<ComunaDTO> lista = cdao.readAll();
//        for (ComunaDTO d : lista) {
//            System.out.println(d.getId() + " - " + d.getNombre());
//        }
//        Date date = new Date(100, 00, 01);
//        
//        System.out.println(date.toString());
//        NavegacionDTO nav = new NavegacionDTO("10 Gigas", 8000);
//        NavegacionDAO navi = new NavegacionDAO();
//
//        navi.create(nav);
//        
//        List<NavegacionDTO> lista = navi.readAll();
//        for (NavegacionDTO d : lista) {
//            System.out.println(d.getId() + " - " + d.getDescripcion() + " $" + d.getPrecio());
//        }
//        MinutoDTO nav = new MinutoDTO("3000 Minutos", 5000);
//        MinutoDAO navi = new MinutoDAO();
//
//        navi.create(nav);
//        
//        List<MinutoDTO> lista = navi.readAll();
//        for (MinutoDTO d : lista) {
//            System.out.println(d.getId() + " - " + d.getDescripcion() + " $" + d.getPrecio());
//        }
//        ClienteDTO cl = new ClienteDTO("pene", "17753134-0", "Jimmy", "Cabello", "Isla", "Inglaterra", "330", new ComunaDAO().read(9205), 123123);
//        ClienteDAO cli = new ClienteDAO();
//        
//        cli.create(cl);
//        
//        ClienteDTO cliente = cli.read("17753134-0");
//        System.out.println(cliente);

//        SolicitudDTO sol = new SolicitudDTO();
//        SolicitudDAO soli = new SolicitudDAO();
//
//        sol = new SolicitudDTO(true, 2000, new Date(), new ClienteDAO().read("17753134-0"), new NavegacionDAO().read(1), new MinutoDAO().read(1));
////        
//        soli.create(sol);
//        
 //       System.out.println(soli.read(7));
 
//
//        System.out.println(Encriptar.getMD5("ola"));
//        System.out.println(Encriptar.getMD5("hola"));
//        System.out.println(Encriptar.getMD5("123456789"));
//        
//        String rut = "";
//
//
//        try {
//             System.out.println(ClienteDTO.transformarRut(rut));
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//        
//        if (ClienteDTO.validarRut(rut)) {
//            System.out.println("correcto");
//        }else {
//            System.out.println("no pe");
//        }
 
        

    }
}
