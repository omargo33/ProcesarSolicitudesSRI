package com.leon.batch.cliente.estructuras;

import lombok.Data;

@Data
public class Taxes {
    String name;
    int percentage;
    double taxableBase;
    double value;
}