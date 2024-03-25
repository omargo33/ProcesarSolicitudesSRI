package com.d3v.proceso;

import com.fundamentos.conexion.managerBD;

public class EditLinerNroSiguiente {
  dsF0022 DSF0022 = new dsF0022();
  
  dsF00221 DSF00221 = new dsF00221();
  
  private String esquema;
  
  managerBD BD;
  
  public EditLinerNroSiguiente() {
    setDSF0022(new dsF0022());
    setDSF00221(new dsF00221());
    setEsquema("");
    setBD(null);
  }
  
  public void editLine(String typeMode) {
    String query = "";
    String[][] registro = (String[][])null;
    boolean updateNN = false;
    if (typeMode.equalsIgnoreCase("1")) {
      query = "SELECT * FROM " + this.esquema + ".t0022 WHERE szCompany = '" + this.DSF0022.getCompany() + "' AND szTypeDoc = '" + this.DSF0022.getTypeDoc() + "' AND mnPeriodoFiscal = '" + this.DSF0022.getAnioFiscal() + "' ;";
      registro = this.BD.sqlString(query);
      if (registro != null) {
        for (int i = 0; i < registro.length; i++) {
          this.DSF0022.setDescripcion(registro[i][3]);
          this.DSF0022.setNextNumber(Integer.parseInt(registro[i][4]));
          updateNN = true;
        } 
      } else {
        this.DSF0022.setDescripcion("CARGA AUT TIPO DOC " + this.DSF0022.getTypeDoc());
        String pfTemp = String.valueOf(this.DSF0022.getAnioFiscal());
        this.DSF0022.setNextNumber(Integer.parseInt(pfTemp.substring(2) + "000001"));
        query = "INSERT INTO " + this.esquema + ".t0022 (szCompany, szTypeDoc, mnPeriodoFiscal, szDescripcion, mnNextNumber)VALUES ('" + this.DSF0022.getCompany() + "' ,'" + this.DSF0022.getTypeDoc() + "', '" + this.DSF0022.getAnioFiscal() + "', '" + this.DSF0022.getDescripcion() + "', '" + this.DSF0022.getNextNumber() + "');";
        if (this.BD.sqlInsert(query) && this.BD.sqlCommit()) {
          System.out.println("Registro automatico NN exitoso!");
          updateNN = true;
        } else {
          System.out.println("Problemas al registrar NN automatico");
        } 
      } 
      if (updateNN) {
        int nextNumberNew = this.DSF0022.getNextNumber() + 1;
        query = "UPDATE " + this.esquema + ".t0022 SET mnNextNumber =  '" + nextNumberNew + "' WHERE szCompany = '" + this.DSF0022.getCompany() + "' AND szTypeDoc = '" + this.DSF0022.getTypeDoc() + "' AND mnPeriodoFiscal = '" + this.DSF0022.getAnioFiscal() + "' ;";
        if (this.BD.sqlUpdate(query) && this.BD.sqlCommit())
          System.out.println("Consumo realizado NN!"); 
      } 
    } 
  }
  
  public void editlineObjeto(String typeMode) {
    String query = "";
    String[][] registro = (String[][])null;
    boolean updateNN = false;
    if (typeMode.equalsIgnoreCase("1")) {
      query = "SELECT * FROM " + this.esquema + ".t00221 WHERE szObjeto = '" + this.DSF00221.getObjeto() + "' ;";
      registro = this.BD.sqlString(query);
      if (registro != null) {
        for (int i = 0; i < registro.length; i++) {
          this.DSF00221.setNextNumber(Integer.parseInt(registro[i][1]));
          updateNN = true;
        } 
      } else {
        this.DSF00221.setNextNumber(1);
        query = "INSERT INTO " + this.esquema + ".t00221(szObjeto, mnNextNumber)VALUES ('" + this.DSF00221.getObjeto() + "', '" + this.DSF00221.getNextNumber() + "' );";
        if (this.BD.sqlInsert(query) && this.BD.sqlCommit()) {
          System.out.println("Registro automatico NN por Objeto Exitoso!");
          updateNN = true;
        } else {
          System.out.println("Problemas al registrar NN por Objeto automatico");
        } 
      } 
      if (updateNN) {
        int nextNumberNew = this.DSF00221.getNextNumber() + 1;
        query = "UPDATE " + this.esquema + ".t00221 SET mnNextNumber =  '" + nextNumberNew + "' WHERE szObjeto = '" + this.DSF00221.getObjeto() + "' ;";
        if (this.BD.sqlUpdate(query) && this.BD.sqlCommit())
          System.out.println("Consumo realizado NN por Objeto!"); 
      } 
    } 
  }
  
  public dsF0022 getDSF0022() {
    return this.DSF0022;
  }
  
  public void setDSF0022(dsF0022 DSF0022) {
    this.DSF0022 = DSF0022;
  }
  
  public dsF00221 getDSF00221() {
    return this.DSF00221;
  }
  
  public void setDSF00221(dsF00221 DSF00221) {
    this.DSF00221 = DSF00221;
  }
  
  public String getEsquema() {
    return this.esquema;
  }
  
  public void setEsquema(String esquema) {
    this.esquema = esquema;
  }
  
  public managerBD getBD() {
    return this.BD;
  }
  
  public void setBD(managerBD BD) {
    this.BD = BD;
  }
}
