package com.d3v.proceso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Autorizacion {
  private String estado;

  private String fechaAutorizacion;

  private Date fecha;

  private String ambiente;

  private String comprobante;

  private String numeroAutorizacion;

  private String tipoComprobante;

  private List<MensajeAutorizacion> listaMensajeAutorizacion;

  public Autorizacion() {
    setAmbiente("");
    setComprobante("");
    setEstado("");
    setFecha(new Date());
    setFechaAutorizacion("2000-07-15T18:00:05.752-05:00");
    setListaMensajeAutorizacion(new ArrayList<>());
    setTipoComprobante("");
  }

  
  /**
   * Metodo para listar los mensajes de autorizacion
   * 
   * @return
   */
  //TODO: no le veo utilizado
  public String listarMensajesToString() {
    String respuesta = "";
    for (MensajeAutorizacion a : getListaMensajeAutorizacion())
      respuesta = respuesta + a.toString();
    return respuesta;
  }

  
  /**
   * Metodo para obtener una fecha con formato particular.
   * 
   * @return
   */
  public Date getFecha() {
    try {
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      String strFecha = getFechaAutorizacion().replaceAll("T", " ").substring(1, 19);
      Date fechaDate = formato.parse(strFecha);
      return fechaDate;
    } catch (Exception ex) {
      return new Date();
    }
  }
}
