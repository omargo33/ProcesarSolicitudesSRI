package com.d3v.proceso;

public class dsF0022 {
    private String company;
    
    private String typeDoc;
    
    private int anioFiscal;
    
    private String descripcion;
    
    private int nextNumber;
    
    public dsF0022() {
      setCompany("");
      setTypeDoc("");
      setAnioFiscal(0);
      setDescripcion("");
      setNextNumber(0);
    }
    
    public String getCompany() {
      return this.company;
    }
    
    public void setCompany(String company) {
      this.company = company;
    }
    
    public String getTypeDoc() {
      return this.typeDoc;
    }
    
    public void setTypeDoc(String typeDoc) {
      this.typeDoc = typeDoc;
    }
    
    public int getAnioFiscal() {
      return this.anioFiscal;
    }
    
    public void setAnioFiscal(int anioFiscal) {
      this.anioFiscal = anioFiscal;
    }
    
    public String getDescripcion() {
      return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
    }
    
    public int getNextNumber() {
      return this.nextNumber;
    }
    
    public void setNextNumber(int nextNumber) {
      this.nextNumber = nextNumber;
    }
  }
  