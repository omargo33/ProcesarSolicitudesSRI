package com.leon.batch.cliente.estructuras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Clase para almacenar la estructura de los documentos.
 * 
 * @autor omargo33
 * @since 2024-04-04
 * 
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Documento {
    int documentId;
    String rucIssuer;
    String commercialName;
    String socialNameIssuer;
    String issuedAt;
    String establishment;
    String pointIssue;
    String sequence;
    String documentType;
    int documentTypeId;
    String issuedAtFormatted;
    String accessKey;
    double totalValueWithoutTaxes;
    double tip;
    double totalDiscount;
    String typeEmission;
    double totalAmount;
    String taxpayerId;
    String authorizationAt;
    Taxes[] taxes;
}