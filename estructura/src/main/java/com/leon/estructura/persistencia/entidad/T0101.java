package  com.leon.estructura.persistencia.entidad;


import java.util.Date;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

/**
 * JPA 
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Data
@Entity 
@Table(name = "xx")
public class T0101   implements Serializable {


     private int mnNroDireccion;
     private String szRazonSocial;
     private String szNombreApellido;
     private String szIdentificadorFiscal;
     private String szTipoIdentificacion;
     private String szDireccion1;
     private String szDireccion2;
     private String szCorreo;
     private String szDominioCorreo;
     private String szTelfCas;
     private String szTelfOfi;
     private String szCel;
     private String szTipoPersona;
     private Double mnCreditoVencido;
     private Double mnMaximoCredito;
     private String szNickName;
     private Integer mnSecuenciaOrdenamiento;
     private Date jdFechaNacimiento;
     private String szGenero;
     private String szCatLd01;
     private String szCatLd02;
     private String szCatLd03;
     private String szCatLd04;
     private String szCatLd05;
     private String szCatLd06;
     private String szCatLd07;
     private String szCatLd08;
     private String szCatLd09;
     private String szCatLd10;
     private String szUsuario;
     private String szEstacionTrabajo;
     private Date jdFechaTrans;
     private Date mnTiempoTrans;
     private String szCompensacionLm;
     private String szExplicacionFiscal;
     private String szCuentaContableDefecto;
     private String szTipoContribuyente;

   }