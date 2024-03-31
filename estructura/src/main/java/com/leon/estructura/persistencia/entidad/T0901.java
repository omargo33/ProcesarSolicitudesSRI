package  com.leon.estructura.persistencia.entidad;

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
public class T0901   implements Serializable {


     private int accountId;
     private String company;
     private String businessUnit;
     private String objectAccount;
     private String subsidiary;
     private String accountNumber3rd;
     private String description;
     private String accountLevelofDetail;
     private byte[] billableYn;
     private String currencyCodeFrom;
     private String categoryCode01;
     private String categoryCode02;
     private String categoryCode03;
     private String categoryCode04;
     private String categoryCode05;
     private String categoryCode06;
     private String categoryCode07;
     private String categoryCode08;
     private String categoryCode09;
     private String categoryCode10;
     private String objectAccountAlternate;
     private String subsidiaryAlternate;
     private String taxRateArea;

   



}


