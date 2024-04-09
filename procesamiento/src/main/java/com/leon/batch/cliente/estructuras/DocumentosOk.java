package com.leon.batch.cliente.estructuras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


/**
 * Clase para almacenar la estructura de los documentos ok.
 * 
 * @author omargo33
 * @since 2024-04-08
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentosOk {
    String status;
    Documento[] data;
}
