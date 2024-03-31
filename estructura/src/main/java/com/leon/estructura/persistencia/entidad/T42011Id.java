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
public class T42011Id  implements Serializable {

    private int nroDoc;
    private String tipoDoc;
    private String companiaDoc;

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof T42011Id))
            return false;
        T42011Id castOther = (T42011Id) other;

        return (this.getNroDoc() == castOther.getNroDoc())
                && ((this.getTipoDoc() == castOther.getTipoDoc()) || (this.getTipoDoc() != null
                        && castOther.getTipoDoc() != null && this.getTipoDoc().equals(castOther.getTipoDoc())))
                && ((this.getCompaniaDoc() == castOther.getCompaniaDoc())
                        || (this.getCompaniaDoc() != null && castOther.getCompaniaDoc() != null
                                && this.getCompaniaDoc().equals(castOther.getCompaniaDoc())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getNroDoc();
        result = 37 * result + (getTipoDoc() == null ? 0 : this.getTipoDoc().hashCode());
        result = 37 * result + (getCompaniaDoc() == null ? 0 : this.getCompaniaDoc().hashCode());
        return result;
    }

}
