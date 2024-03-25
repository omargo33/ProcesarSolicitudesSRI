package com.d3v.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainFechaString {
  public static String fechaFormateada(String formato) {
    return fechaFormateada(new Date(), formato);
  }
  
  public static String fechaFormateada(Date fecha, String formato) {
    SimpleDateFormat miFechaFormato = new SimpleDateFormat(formato, new Locale("Es"));
    return miFechaFormato.format(fecha);
  }
  
  public static String getFecha() {
    return fechaFormateada("EEEE, dd/MM/yyyy");
  }
  
  public static String getHora() {
    return fechaFormateada("HH:mm:ss");
  }
  
  public static String getFechaEclipSoft() {
    return fechaFormateada("MM/dd/yyyy");
  }
  
  public static String getFechaHora() {
    return fechaFormateada("dd/MM/yyyy HH:mm:ss");
  }
  
  public static String getDiaFecha() {
    return fechaFormateada("EEEE, dd/MM/yyyy");
  }
  
  public static String getDiaFechaHora() {
    return fechaFormateada("EEEE, dd/MM/yyyy HH:mm:ss");
  }
  
  public static String getDiaFechaHoraSimple() {
    return fechaFormateada("dd/MM/yy HH:mm:ss");
  }
  
  public static String getNombreFileDate() {
    return fechaFormateada("yyyyMMdd") + ".log";
  }
  
  public static String getNombreFileDateCompleto() {
    return fechaFormateada("yyyyMMddHHmmss") + ".log";
  }
  
  public static String getHoraMinuto() {
    return fechaFormateada("HH:mm");
  }
}
