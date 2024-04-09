package com.leon.batch.cliente.estructuras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Clase para almacenar la estructura de los impuestos.
 * 
 * @author omargo33
 * @since 2024-04-04
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Taxes {
    String name;
    int percentage;
    double taxableBase;
    double value;
}