package com.leon.batch.cliente.estructuras;

import lombok.Data;

@Data
public class DocumentosOk {
    String status;
    DocumentoOk[] data;
}
