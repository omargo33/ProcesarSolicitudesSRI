package com.leon.batch.utilitarios;

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

  private MainFechaString() {
    super();
  }

  /**
   * Metodo para obtener una fecha(now) con formato particular.
   * 
   * @param formato
   * @return
   */
  public static String fechaFormateada(String formato) {
    return fechaFormateada(new Date(), formato);
  }

  /**
   * Metodo para obtener una fecha(custom) con formato particular.
   * 
   * @param fecha
   * @param formato
   * @return
   */
  public static String fechaFormateada(Date fecha, String formato) {
    SimpleDateFormat miFechaFormato = new SimpleDateFormat(formato, new Locale("Es"));
    return miFechaFormato.format(fecha);
  }

  /**
   * Metodo para obtener la fecha actual.
   * 
   * @return
   */
  public static String getHora() {
    return fechaFormateada("HH:mm:ss");
  }
}
