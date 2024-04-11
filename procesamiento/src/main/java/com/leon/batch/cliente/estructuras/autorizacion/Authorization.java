//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.09 at 10:09:47 p. m. ECT 
//

package com.leon.batch.cliente.estructuras.autorizacion;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroAutorizacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fechaAutorizacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ambiente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="comprobante" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mensajes">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mensaje" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="identificador" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "estado",
        "numeroAutorizacion",
        "fechaAutorizacion",
        "ambiente",
        "comprobante",
        "mensajes"
})
@XmlRootElement(name = "Authorization")
public class Authorization {

    @XmlElement(required = true)
    protected String estado;
    @XmlElement(required = true)
    protected String numeroAutorizacion;
    @XmlElement(required = true)
    protected String fechaAutorizacion;
    @XmlElement(required = true)
    protected String ambiente;
    @XmlElement(required = true)
    protected String comprobante;
    @XmlElement(required = true)
    protected Authorization.Mensajes mensajes;

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the numeroAutorizacion property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    /**
     * Sets the value of the numeroAutorizacion property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setNumeroAutorizacion(String value) {
        this.numeroAutorizacion = value;
    }

    /**
     * Gets the value of the fechaAutorizacion property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getFechaAutorizacion() {
        return fechaAutorizacion;
    }

    /**
     * Sets the value of the fechaAutorizacion property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setFechaAutorizacion(String value) {
        this.fechaAutorizacion = value;
    }

    /**
     * Gets the value of the ambiente property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * Sets the value of the ambiente property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setAmbiente(String value) {
        this.ambiente = value;
    }

    /**
     * Gets the value of the comprobante property.
     * 
     * @return
     *         possible object is
     *         {@link String }
     * 
     */
    public String getComprobante() {
        return comprobante;
    }

    /**
     * Sets the value of the comprobante property.
     * 
     * @param value
     *              allowed object is
     *              {@link String }
     * 
     */
    public void setComprobante(String value) {
        this.comprobante = value;
    }

    /**
     * Gets the value of the mensajes property.
     * 
     * @return
     *         possible object is
     *         {@link Authorization.Mensajes }
     * 
     */
    public Authorization.Mensajes getMensajes() {
        return mensajes;
    }

    /**
     * Sets the value of the mensajes property.
     * 
     * @param value
     *              allowed object is
     *              {@link Authorization.Mensajes }
     * 
     */
    public void setMensajes(Authorization.Mensajes value) {
        this.mensajes = value;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     * 
     * <p>
     * The following schema fragment specifies the expected content contained within
     * this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mensaje" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="identificador" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "mensaje"
    })
    public static class Mensajes {

        protected List<Authorization.Mensajes.Mensaje> mensaje;

        /**
         * Gets the value of the mensaje property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mensaje property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * 
         * <pre>
         * getMensaje().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Authorization.Mensajes.Mensaje }
         * 
         * 
         */
        public List<Authorization.Mensajes.Mensaje> getMensaje() {
            if (mensaje == null) {
                mensaje = new ArrayList<Authorization.Mensajes.Mensaje>();
            }
            return this.mensaje;
        }

        /**
         * <p>
         * Java class for anonymous complex type.
         * 
         * <p>
         * The following schema fragment specifies the expected content contained within
         * this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="identificador" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "identificador",
                "mensaje",
                "tipo"
        })
        public static class Mensaje {

            @XmlElement(required = true)
            protected String identificador;
            @XmlElement(required = true)
            protected String mensaje;
            @XmlElement(required = true)
            protected String tipo;

            /**
             * Gets the value of the identificador property.
             * 
             * @return
             *         possible object is
             *         {@link String }
             * 
             */
            public String getIdentificador() {
                return identificador;
            }

            /**
             * Sets the value of the identificador property.
             * 
             * @param value
             *              allowed object is
             *              {@link String }
             * 
             */
            public void setIdentificador(String value) {
                this.identificador = value;
            }

            /**
             * Gets the value of the mensaje property.
             * 
             * @return
             *         possible object is
             *         {@link String }
             * 
             */
            public String getMensaje() {
                return mensaje;
            }

            /**
             * Sets the value of the mensaje property.
             * 
             * @param value
             *              allowed object is
             *              {@link String }
             * 
             */
            public void setMensaje(String value) {
                this.mensaje = value;
            }

            /**
             * Gets the value of the tipo property.
             * 
             * @return
             *         possible object is
             *         {@link String }
             * 
             */
            public String getTipo() {
                return tipo;
            }

            /**
             * Sets the value of the tipo property.
             * 
             * @param value
             *              allowed object is
             *              {@link String }
             * 
             */
            public void setTipo(String value) {
                this.tipo = value;
            }

        }

    }

}