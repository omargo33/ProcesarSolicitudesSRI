package com.d3v.proceso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
  
  public String getEstado() {
    return this.estado;
  }
  
  public void setEstado(String estado) {
    this.estado = estado;
  }
  
  public String getFechaAutorizacion() {
    return this.fechaAutorizacion;
  }
  
  public void setFechaAutorizacion(String fechaAutorizacion) {
    this.fechaAutorizacion = fechaAutorizacion;
  }
  
  public String getAmbiente() {
    return this.ambiente;
  }
  
  public void setAmbiente(String ambiente) {
    this.ambiente = ambiente;
  }
  
  public String getComprobante() {
    return this.comprobante;
  }
  
  public void setComprobante(String comprobante) {
    this.comprobante = comprobante;
  }
  
  public List<MensajeAutorizacion> getListaMensajeAutorizacion() {
    return this.listaMensajeAutorizacion;
  }
  
  public void setListaMensajeAutorizacion(List<MensajeAutorizacion> listaMensajeAutorizacion) {
    this.listaMensajeAutorizacion = listaMensajeAutorizacion;
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
  
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }
  
  public String getNumeroAutorizacion() {
    return this.numeroAutorizacion;
  }
  
  public void setNumeroAutorizacion(String numeroAutorizacion) {
    this.numeroAutorizacion = numeroAutorizacion;
  }
  
  public String getTipoComprobante() {
    return this.tipoComprobante;
  }
  
  public void setTipoComprobante(String tipoComprobante) {
    this.tipoComprobante = tipoComprobante;
  }
}
