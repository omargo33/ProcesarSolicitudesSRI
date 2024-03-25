package com.d3v.utilitarios;

import com.fundamentos.conexion.managerBD;

public class UDC {
  private String modulo;
  
  private String constante;
  
  private String codigoDefinidoUsuario;
  
  private String descripcion;
  
  private String descripcion2;
  
  private String usoEspecial;
  
  private String hardCode;
  
  public void retrieve(managerBD BD, String esquema) {
    String[][] registro = (String[][])null;
    String query = "";
    try {
      query = "SELECT * FROM " + esquema + ".t0005 WHERE szModulo = '" + getModulo() + "'  AND szConstante = '" + getConstante() + "' AND szCodigoDefinidoUsuario = '" + getCodigoDefinidoUsuario() + "' ";
      registro = BD.sqlString(query);
      if (registro != null && registro.length > 0) {
        this.descripcion = registro[0][3];
        this.descripcion2 = registro[0][4];
        this.usoEspecial = registro[0][5];
        this.hardCode = registro[0][6];
      } 
    } catch (Exception e) {
      System.err.println("Genero un error al consultar la referencia de tipo pago XML: " + e.toString());
    } 
  }
  
  public void retrieveDescripcion2(managerBD BD, String esquema) {
    String[][] registro = (String[][])null;
    String query = "";
    try {
      query = "SELECT * FROM " + esquema + ".t0005 WHERE szModulo = '" + getModulo() + "'  AND szConstante = '" + getConstante() + "' AND szDescripcion02 = '" + getDescripcion2() + "' ";
      registro = BD.sqlString(query);
      if (registro != null && registro.length > 0) {
        this.codigoDefinidoUsuario = registro[0][2];
        this.descripcion = registro[0][3];
        this.descripcion2 = registro[0][4];
        this.usoEspecial = registro[0][5];
        this.hardCode = registro[0][6];
      } 
    } catch (Exception e) {
      System.err.println("Genero un error al consultar la referencia de tipo pago XML: " + e.toString());
    } 
  }
  
  public String getModulo() {
    return this.modulo;
  }
  
  public void setModulo(String modulo) {
    this.modulo = modulo;
  }
  
  public String getConstante() {
    return this.constante;
  }
  
  public void setConstante(String constante) {
    this.constante = constante;
  }
  
  public String getCodigoDefinidoUsuario() {
    return this.codigoDefinidoUsuario;
  }
  
  public void setCodigoDefinidoUsuario(String codigoDefinidoUsuario) {
    this.codigoDefinidoUsuario = codigoDefinidoUsuario;
  }
  
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  public String getDescripcion2() {
    return this.descripcion2;
  }
  
  public void setDescripcion2(String descripcion2) {
    this.descripcion2 = descripcion2;
  }
  
  public String getUsoEspecial() {
    return this.usoEspecial;
  }
  
  public void setUsoEspecial(String usoEspecial) {
    this.usoEspecial = usoEspecial;
  }
  
  public String getHardCode() {
    return this.hardCode;
  }
  
  public void setHardCode(String hardCode) {
    this.hardCode = hardCode;
  }
}
