package com.d3v.proceso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DsF0022 {
  private String company;

  private String typeDoc;

  private int anioFiscal;

  private String descripcion;

  private int nextNumber;

  public DsF0022() {
    setCompany("");
    setTypeDoc("");
    setAnioFiscal(0);
    setDescripcion("");
    setNextNumber(0);
  }
}
