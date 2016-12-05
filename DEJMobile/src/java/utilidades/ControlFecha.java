/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Sebastian
 */
public class ControlFecha {

    public static String JavaToMySQL(Date date) throws ParseException {
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        GregorianCalendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        String s = formatoFecha.format(calendar.getTime());
        String s = formatoFecha.format(date);
        return s;
//        String pattern = "yyyy-MM-dd HH-mm-ss";
//        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//        String fechaSQL = formatter.formatoFecha(now);
//        return fechaSQL;
    }

    public static Date MySQLToJava(String fecha) throws ParseException {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse(fecha); // mysql datetime formatoFecha
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.getTime();

    }
    
    public static String formatearFecha(Date date){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s = formatoFecha.format(date);
        return s;
    }

}
