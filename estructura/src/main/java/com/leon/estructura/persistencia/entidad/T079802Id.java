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
public class T079802Id  implements Serializable {

    private String szCodEmpresa;
    private String szCodOficina;
    private String szUnidadNegocioEst;

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof T079802Id))
            return false;
        T079802Id castOther = (T079802Id) other;

        return ((this.getSzCodEmpresa() == castOther.getSzCodEmpresa()) || (this.getSzCodEmpresa() != null
                && castOther.getSzCodEmpresa() != null && this.getSzCodEmpresa().equals(castOther.getSzCodEmpresa())))
                && ((this.getSzCodOficina() == castOther.getSzCodOficina())
                        || (this.getSzCodOficina() != null && castOther.getSzCodOficina() != null
                                && this.getSzCodOficina().equals(castOther.getSzCodOficina())))
                && ((this.getSzUnidadNegocioEst() == castOther.getSzUnidadNegocioEst())
                        || (this.getSzUnidadNegocioEst() != null && castOther.getSzUnidadNegocioEst() != null
                                && this.getSzUnidadNegocioEst().equals(castOther.getSzUnidadNegocioEst())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getSzCodEmpresa() == null ? 0 : this.getSzCodEmpresa().hashCode());
        result = 37 * result + (getSzCodOficina() == null ? 0 : this.getSzCodOficina().hashCode());
        result = 37 * result + (getSzUnidadNegocioEst() == null ? 0 : this.getSzUnidadNegocioEst().hashCode());
        return result;
    }

}
