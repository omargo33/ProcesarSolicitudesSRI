package com.d3v.utilitarios;

public class Pagos {
  private String DESC_01 = "SIN UTILIZACION DEL SISTEMA FINANCIERO";

  private String DESC_02 = "CHEQUE PROPIO";

  private String DESC_03 = "CHEQUE CERTIFICADO";

  private String DESC_04 = "CHEQUE DE GERENCIA";

  private String DESC_05 = "CHEQUE DEL EXTERIOR";

  private String DESC_06 = "DDE CUENTA";

  private String DESC_07 = "TRANSFERENCIA PROPIO BANCO";

  private String DESC_08 = "TRANSFERENCIA OTRO BANCO NACIONAL";

  private String DESC_09 = "TRANSFERENCIA BANCO EXTERIOR";

  private String DESC_10 = "TARJETA DE CRNACIONAL";

  private String DESC_11 = "TARJETA DE CRINTERNACIONAL";

  private String DESC_12 = "GIRO";

  private String DESC_13 = "DEPOSITO EN CUENTA (CORRIENTE/AHORROS)";

  private String DESC_14 = "ENDOSO DE INVERSIÓN";

  private String DESC_15 = "COMPENSACIDE DEUDAS";

  private String DESC_16 = "TARJETA DE DÉBITO";

  private String DESC_17 = "DINERO ELECTRÓNICO";

  private String DESC_18 = "TARJETA PREPAGO";

  private String DESC_19 = "TARJETA DE CRÉDITO";

  private String DESC_20 = "OTROS CON UTILIZACION DEL SISTEMA FINANCIERO";

  private String DESC_21 = "ENDOSO DE TÍTULOS";

  public String consultarDescripcion(String idInstrumentoPago) {
    String instrumentoPago = " ";
    if (idInstrumentoPago.equals("01"))
      instrumentoPago = this.DESC_01;
    if (idInstrumentoPago.equals("02"))
      instrumentoPago = this.DESC_02;
    if (idInstrumentoPago.equals("03"))
      instrumentoPago = this.DESC_03;
    if (idInstrumentoPago.equals("04"))
      instrumentoPago = this.DESC_04;
    if (idInstrumentoPago.equals("05"))
      instrumentoPago = this.DESC_05;
    if (idInstrumentoPago.equals("06"))
      instrumentoPago = this.DESC_06;
    if (idInstrumentoPago.equals("07"))
      instrumentoPago = this.DESC_07;
    if (idInstrumentoPago.equals("08"))
      instrumentoPago = this.DESC_08;
    if (idInstrumentoPago.equals("09"))
      instrumentoPago = this.DESC_09;
    if (idInstrumentoPago.equals("10"))
      instrumentoPago = this.DESC_10;
    if (idInstrumentoPago.equals("11"))
      instrumentoPago = this.DESC_11;
    if (idInstrumentoPago.equals("12"))
      instrumentoPago = this.DESC_12;
    if (idInstrumentoPago.equals("13"))
      instrumentoPago = this.DESC_13;
    if (idInstrumentoPago.equals("14"))
      instrumentoPago = this.DESC_14;
    if (idInstrumentoPago.equals("15"))
      instrumentoPago = this.DESC_15;
    if (idInstrumentoPago.equals("16"))
      instrumentoPago = this.DESC_16;
    if (idInstrumentoPago.equals("17"))
      instrumentoPago = this.DESC_17;
    if (idInstrumentoPago.equals("18"))
      instrumentoPago = this.DESC_18;
    if (idInstrumentoPago.equals("19"))
      instrumentoPago = this.DESC_19;
    if (idInstrumentoPago.equals("20"))
      instrumentoPago = this.DESC_20;
    if (idInstrumentoPago.equals("21"))
      instrumentoPago = this.DESC_21;
    return instrumentoPago;
  }
}
