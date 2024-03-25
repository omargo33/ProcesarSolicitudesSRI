package com.d3v.proceso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
  
  public String toString() {
    return "\nambiente: " + getAmbiente() + "\ncomprobante: " + 
      getComprobante() + "\nestado: " + 
      getEstado() + "\nfecha autorizacion: " + 
      getFechaAutorizacion() + "\ntipo comprobante: " + 
      getTipoComprobante() + "\nmensajes: " + 
      listaMensajesToString();
  }
  
  
  public String listaMensajesToString() {
    String respuesta = "";
    for (MensajeAutorizacion a : getListaMensajeAutorizacion())
      respuesta = respuesta + a.toString(); 
    return respuesta;
  }
  
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
