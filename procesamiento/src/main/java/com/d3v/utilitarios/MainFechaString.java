package com.d3v.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Clase que permite formatear fechas a string.
 * 
 * @author omargo33
 * @since 2024-04-01
 *
 */
public class MainFechaString {
  public static String fechaFormateada(String formato) {
    return fechaFormateada(new Date(), formato);
  }

  public static String fechaFormateada(Date fecha, String formato) {
    SimpleDateFormat miFechaFormato = new SimpleDateFormat(formato, new Locale("Es"));
    return miFechaFormato.format(fecha);
  }

  public static String getHora() {
    return fechaFormateada("HH:mm:ss");
  }
}
