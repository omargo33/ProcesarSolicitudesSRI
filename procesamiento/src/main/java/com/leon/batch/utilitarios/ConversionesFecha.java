package com.leon.batch.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.time.format.DateTimeFormatter;
import java.time.OffsetDateTime;
import java.time.Instant;

/**
 * Clase que permite formatear fechas a string.
 * 
 * @author omargo33
 * @since 2024-04-01
 *
 */
public class ConversionesFecha {

  private ConversionesFecha() {
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

  public static Date stringAFecha(String fecha, String formato) {
    SimpleDateFormat miFechaFormato = new SimpleDateFormat(formato, new Locale("Es"));
    try {
      return miFechaFormato.parse(fecha);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Metodo para obtener la fecha actual.
   * 
   * @return
   */
  public static String getHora() {
    return fechaFormateada("HH:mm:ss");
  }

  /**
   * Metodo para obtener la fecha actual.
   * Formato iso: 2023-12-05T15:30:47-05:00
   * 
   * @param fechaStr
   * @return
   */
  public static Date stringDateIso(String fechaStr) {
    DateTimeFormatter formato = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    OffsetDateTime fechaOffset = OffsetDateTime.parse(fechaStr, formato);

    Instant instant = fechaOffset.toInstant();
    return  Date.from(instant);
  }
}
