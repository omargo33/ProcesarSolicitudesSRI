package com.leon.estructura.persistencia.entidad;

import java.math.BigDecimal;

import lombok.Data;

import java.io.Serializable;
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
@Table(name = "resumenDocumentosProveedores")
public class ResumenDocumentoProveedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "access_key", length = 255)
    private String accessKey;

    @Column(name = "document_id")
    private int documentId;

    @Column(name = "ruc_issuer", length = 255)
    private String rucIssuer;

    @Column(name = "commercial_name", length = 255)
    private String commercialName;

    @Column(name = "social_name_issuer", length = 255)
    private String socialNameIssuer;

    @Column(name = "issued_at", length = 255)
    private Date issuedAt;

    @Column(name = "establishment", length = 255)
    private String establishment;

    @Column(name = "point_issue", length = 255)
    private String pointIssue;

    @Column(name = "sequence", length = 255)
    private String sequence;

    @Column(name = "document_type", length = 255)
    private String documentType;

    @Column(name = "document_type_id")
    private int documentTypeId;

    @Column(name = "issued_at_formatted", length = 255)
    private String issuedAtFormatted;

    @Column(name = "total_value_without_taxes")
    private BigDecimal totalValueWithoutTaxes;

    @Column(name = "tip")
    private BigDecimal tip;

    @Column(name = "total_discount")
    private BigDecimal totalDiscount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "taxpayer_id", length = 255)
    private String taxpayerId;
}
