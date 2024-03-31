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
public class T41021   implements Serializable {


     private T41021Id id;
     private Date jdFechaUltRecep;
     private Double mnCantDisponibleHd;
     private Double mnCantBackOrder;
     private Double mnCantOrdenCompra;
     private Double mnCantOrdenTrabajo;
     private Double mnCantConfirmadaFirme;
     private Double mnCantConfirmadaFlexible;
     private String szUsuario;
     private String szProgramaId;
     private Date jdFechaAct;
     private Date mnTiempoAct;
     private String szHost;
}