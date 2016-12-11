/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import dao.ClienteDAO;
import dto.ClienteDTO;
import java.text.DecimalFormat;
import static utilidades.Encriptar.getMD5;

/**
 *
 * @author Willywes
 */
public class Control {

    public static boolean comprobarVacio(String s) {
        return s.isEmpty();
    }

    public static boolean comprobarPass(String pass, String pass2) {
        return pass.equals(pass2);
    }

    public static boolean comprobarSiExisteRut(String rut) {
        ClienteDAO dao = new ClienteDAO();
        return dao.ComprobarExiste(rut);
    }

    public static boolean validarPassLogin(String rut, String pass) {
        ClienteDTO cliente = new ClienteDAO().read(rut);
        return cliente.getClave().equals(getMD5(pass));

    }

    public static String transformarRut(String rut) throws Exception {

        int cont = 0;
        String format;
        if (rut.length() == 0) {
            throw new Exception("El RUT no puede estar vacio.");
        } else {
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            if (rut.length() < 8) {
                throw new Exception("El RUT no tienen el rango correcto.");
            }

            format = "-" + rut.substring(rut.length() - 1);

            for (int i = rut.length() - 2; i >= 0; i--) {
                format = rut.substring(i, i + 1) + format;
                cont++;
                if (cont == 3 && i != 0) {
                    format = "." + format;
                    cont = 0;
                }
            }
            return format;
        }
    }

    public static boolean validarRut(String rutS) throws Exception {
//        int suma = 0;
        char dv;
        int rut;
//        int[] serie = {2, 3, 4, 5, 6, 7};
        rutS = rutS.replace(".", "");
        String[] rutArray = rutS.split("-");
        try {
            rut = Integer.parseInt(rutArray[0]);
        } catch (Exception e) {
            throw new Exception("Rut debe ser válido.");
        }
        dv = rutArray[1].charAt(0);

//        for (int i = rut.length() - 2; i >= 0; i--) {
//            suma += Integer.valueOf(rut.substring(i, i + 1))
//                    * serie[(rut.length() - 2 - i) % 6];
//        }
//        dvT = String.valueOf(11 - suma % 11);
//        if (dvT.compareToIgnoreCase("10") == 0) {
//            dvT = "K";
//        }
//
//        if (dvT.compareToIgnoreCase(dvR) == 0) {
//            return true;
//        } else {
//            return false;
//        }
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }

    public static String formatearDinero(int money){
        DecimalFormat formatear = new DecimalFormat("$###,###");
        String laMonea = formatear.format(money);
        return laMonea;
    }
}
