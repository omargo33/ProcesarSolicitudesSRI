package com.d3v.proceso;

import lombok.Data;

/**
 * Clase que representa un mensaje de autorización
 * 
 * @author omargo33
 * @since 2024-04-05
 */
@Data
public class MensajeAutorizacion {
  private String identificador;

  private String mensaje;

  private String tipo;
}
