package com.d3v.proceso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
  }
  