package com.d3v.proceso;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class EditLinerNroSiguiente {
  DsF0022 dsf0022 = new DsF0022();

  DsF00221 dsf00221 = new DsF00221();

  private String esquema;

  public EditLinerNroSiguiente() {
    setDsf0022(new DsF0022());
    setDsf00221(new DsF00221());
    setEsquema("");
  }

  public void editLine(String typeMode) {
    String query = "";
    String[][] registro = (String[][]) null;
    boolean updateNN = false;
    if (typeMode.equalsIgnoreCase("1")) {
      query = "SELECT * FROM " + this.esquema + ".t0022 WHERE szCompany = '" + this.dsf0022.getCompany()
          + "' AND szTypeDoc = '" + this.dsf0022.getTypeDoc() + "' AND mnPeriodoFiscal = '"
          + this.dsf0022.getAnioFiscal() + "' ;";
      registro = this.BD.sqlString(query);
      if (registro != null) {
        for (int i = 0; i < registro.length; i++) {
          this.dsf0022.setDescripcion(registro[i][3]);
          this.dsf0022.setNextNumber(Integer.parseInt(registro[i][4]));
          updateNN = true;
        }
      } else {
        this.dsf0022.setDescripcion("CARGA AUT TIPO DOC " + this.dsf0022.getTypeDoc());
        String pfTemp = String.valueOf(this.dsf0022.getAnioFiscal());
        this.dsf0022.setNextNumber(Integer.parseInt(pfTemp.substring(2) + "000001"));
        query = "INSERT INTO " + this.esquema
            + ".t0022 (szCompany, szTypeDoc, mnPeriodoFiscal, szDescripcion, mnNextNumber)VALUES ('"
            + this.dsf0022.getCompany() + "' ,'" + this.dsf0022.getTypeDoc() + "', '" + this.dsf0022.getAnioFiscal()
            + "', '" + this.dsf0022.getDescripcion() + "', '" + this.dsf0022.getNextNumber() + "');";
        if (this.BD.sqlInsert(query) && this.BD.sqlCommit()) {
          log.info("Registro automatico NN exitoso!");
          updateNN = true;
        } else {
          log.info("Problemas al registrar NN automatico");
        }
      }
      if (updateNN) {
        int nextNumberNew = this.dsf0022.getNextNumber() + 1;
        query = "UPDATE " + this.esquema + ".t0022 SET mnNextNumber =  '" + nextNumberNew + "' WHERE szCompany = '"
            + this.dsf0022.getCompany() + "' AND szTypeDoc = '" + this.dsf0022.getTypeDoc()
            + "' AND mnPeriodoFiscal = '" + this.dsf0022.getAnioFiscal() + "' ;";
        if (this.BD.sqlUpdate(query) && this.BD.sqlCommit())
          log.info("Consumo realizado NN!");
      }
    }
  }

  public void editlineObjeto(String typeMode) {
    String query = "";
    String[][] registro = (String[][]) null;
    boolean updateNN = false;
    if (typeMode.equalsIgnoreCase("1")) {
      query = "SELECT * FROM " + this.esquema + ".t00221 WHERE szObjeto = '" + this.dsf00221.getObjeto() + "' ;";
      registro = this.BD.sqlString(query);
      if (registro != null) {
        for (int i = 0; i < registro.length; i++) {
          this.dsf00221.setNextNumber(Integer.parseInt(registro[i][1]));
          updateNN = true;
        }
      } else {
        this.dsf00221.setNextNumber(1);
        query = "INSERT INTO " + this.esquema + ".t00221(szObjeto, mnNextNumber)VALUES ('" + this.dsf00221.getObjeto()
            + "', '" + this.dsf00221.getNextNumber() + "' );";
        if (this.BD.sqlInsert(query) && this.BD.sqlCommit()) {
          log.info("Registro automatico NN por Objeto Exitoso!");
          updateNN = true;
        } else {
          log.info("Problemas al registrar NN por Objeto automatico");
        }
      }
      if (updateNN) {
        int nextNumberNew = this.dsf00221.getNextNumber() + 1;
        query = "UPDATE " + this.esquema + ".t00221 SET mnNextNumber =  '" + nextNumberNew + "' WHERE szObjeto = '"
            + this.dsf00221.getObjeto() + "' ;";
        if (this.BD.sqlUpdate(query) && this.BD.sqlCommit())
          log.info("Consumo realizado NN por Objeto!");
      }
    }
  }
}
