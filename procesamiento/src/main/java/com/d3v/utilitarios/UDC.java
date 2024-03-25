package com.d3v.utilitarios;

import com.fundamentos.conexion.ManagerBD;

import lombok.Getter;
import lombok.Setter;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
public class UDC {
  private String modulo;
  
  private String constante;
  
  private String codigoDefinidoUsuario;
  
  private String descripcion;
  
  private String descripcion2;
  
  private String usoEspecial;
  
  private String hardCode;
  
  public void retrieve(ManagerBD BD, String esquema) {
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
      log.error("Genero un error al consultar la referencia de tipo pago XML: {}", e.toString());
    } 
  }
  
  public void retrieveDescripcion2(ManagerBD BD, String esquema) {
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
      log.error("Genero un error al consultar la referencia de tipo pago XML: {}", e.toString());
    } 
  }
}