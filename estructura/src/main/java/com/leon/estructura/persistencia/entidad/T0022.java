package  com.leon.estructura.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;

/**
 * JPA 
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Entity
@Table(name = "t0022")
@Data
public class T0022 implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private T0022Id id;

    @Column(name = "szDescripcion", length = 70)
    private String szDescripcion;

    @Column(name = "mnNextNumber")
    private Integer mnNextNumber;

}
