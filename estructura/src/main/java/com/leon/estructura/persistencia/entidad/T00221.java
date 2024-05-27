package  com.leon.estructura.persistencia.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * JPA
 * 
 * Y la llave primera szObjeto.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Data
@Entity
@Table(name = "t00221")
public class T00221 implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "szObjeto", length = 10)
    private String szObjeto;

    @Column(name = "mnNextNumber")
    private Integer mnNextNumber;
}
