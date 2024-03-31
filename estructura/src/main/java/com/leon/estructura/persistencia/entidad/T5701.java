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
public class T5701   implements Serializable {


     private T5701Id id;
     private String szEstado;
     private String szNameArchivoP12;
     private String szPwsArchivoP12;
     private String szLogAuditoria;
     private Integer mnTiempoEspera;
     private String szCodPathArchivoOrigen;
     private String szCodPathArchivoFirmado;
     private String szCodPathArchivoRide;
     private String szCodPathArchivoP12;
     private String szTipoEmision;
     private String szAmbiente;
     private String szModoConsumoServicio;
     private String szLogo;
     private String szMarcaAgua;
}