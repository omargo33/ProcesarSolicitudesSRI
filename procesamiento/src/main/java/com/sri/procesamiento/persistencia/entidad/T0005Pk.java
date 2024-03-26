package com.sri.procesamiento.persistencia.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * JPA de PrimaryKey para la entidad T0005.
 * 
 * @author omargo33
 * @version 1.0
 * 
 */
@Getter
@Setter
@Embeddable
public class T0005Pk implements Serializable {

    @Column(name = "szModulo")
    private String szModulo;

    @Column(name = "szConstante")
    private String szConstante;

    @Column(name = "szCodigoDefinidoUsuario")
    private String szCodigoDefinidoUsuario;

    @Column(name = "szDescripcion")
    private String szDescripcion;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        T0005Pk that = (T0005Pk) o;

        if (szModulo != null ? !szModulo.equals(that.szModulo) : that.szModulo != null)
            return false;
        if (szConstante != null ? !szConstante.equals(that.szConstante) : that.szConstante != null)
            return false;
        if (szCodigoDefinidoUsuario != null ? !szCodigoDefinidoUsuario.equals(that.szCodigoDefinidoUsuario)
                : that.szCodigoDefinidoUsuario != null)
            return false;
        return szDescripcion != null ? szDescripcion.equals(that.szDescripcion) : that.szDescripcion == null;
    }

    @Override
    public int hashCode() {
        int result = szModulo != null ? szModulo.hashCode() : 0;
        result = 31 * result + (szConstante != null ? szConstante.hashCode() : 0);
        result = 31 * result + (szCodigoDefinidoUsuario != null ? szCodigoDefinidoUsuario.hashCode() : 0);
        result = 31 * result + (szDescripcion != null ? szDescripcion.hashCode() : 0);
        return result;
    }
}
