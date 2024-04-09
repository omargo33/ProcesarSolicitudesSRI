package com.leon.batch.cliente.estructuras;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Clase para almacenar la estructura de los tokens correctos.
 * 
 * @author omargo33
 * @since 2024-04-08
 * 
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenOk {
    @JsonProperty("access_token")
    private String accessToken;
    
    @JsonProperty("expires_in")
    private int expiresIn;
    
    @JsonProperty("token_type")
    private String tokenType;
}