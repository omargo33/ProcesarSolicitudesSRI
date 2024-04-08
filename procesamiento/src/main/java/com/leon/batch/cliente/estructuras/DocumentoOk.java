package com.leon.batch.cliente.estructuras;

import java.util.List;

import lombok.Data;

/**
 * Clase para almacenar la estructura de los documentos.
 * 
 * @autor omargo33
 * @since 2024-04-04
 * 
 */
@Data
public class DocumentoOk {
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
    double totalAmount;
    String taxpayerId;
    Taxes[] taxes;
}