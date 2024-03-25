package com.d3v.proceso;

public class MensajeAutorizacion {
    private String identificador;
    
    private String mensaje;
    
    private String tipo;
    
    public MensajeAutorizacion() {
      setIdentificador("");
      setMensaje("");
      setTipo("");
    }
    
    public String toString() {
      return "\nidentificador: " + getIdentificador() + "\nmensaje: " + 
        getMensaje() + "\ntipo: " + getTipo();
    }
    
    public String getIdentificador() {
      return this.identificador;
    }
    
    public void setIdentificador(String identificador) {
      this.identificador = identificador;
    }
    
    public String getMensaje() {
      return this.mensaje;
    }
    
    public void setMensaje(String mensaje) {
      this.mensaje = mensaje;
    }
    
    public String getTipo() {
      return this.tipo;
    }
    
    public void setTipo(String tipo) {
      this.tipo = tipo;
    }
  }
  