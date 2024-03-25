package com.d3v.proceso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DsF0711Z1 {
    private String monto;
    
    private String idIntrumentoPago;
    
    private String instrumentoPago;
    
    private String plazo;
    
    private String unidadTiempo;
    
    public DsF0711Z1() {
      setMonto("");
      setIdIntrumentoPago("");
      setInstrumentoPago("");
      setPlazo("0");
      setUnidadTiempo("");
    }
  }  