package com.leon.batch.cliente;

import com.leon.batch.cliente.estructuras.TokenKo;
import com.leon.batch.cliente.estructuras.TokenOk;

public class Probar {

    public static void main(String[] args) {
        Probar probar = new Probar();
        probar.probarTokenOk();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        probar.probarTokenOk();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        probar.probarTokenOk();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        probar.probarTokenOk();

        /* 
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        probar.probarTokenOk();
    }

    private void probarTokenOk() {

        TokenConsumo tokenConsumo = new TokenConsumo();
        int estadoConsumo = tokenConsumo.load("https://auth.invoicy.app-1/token", "33nda5ed9snbl7edpgp7f3it1c",
                "o0js143is9nh3rc0hdgu1uu83uluic11vvrv28h88sdh3h3nubq", "client_credentials");

        switch (estadoConsumo) {
            case TokenConsumo.SERVIDOR_ERROR:
                System.err.println("Error en la conexion al servidor." + tokenConsumo.getRespuesta());
                break;

            case TokenConsumo.SERVICIO_OK:
                TokenOk tokenOk = tokenConsumo.getJsonRespuesta(TokenOk.class);
                System.out.println("Token: " + tokenOk.getAccessToken());

                System.out.println("Token: " + tokenOk.toString());

                break;

            case TokenConsumo.SERVICIO_ERROR:
                TokenKo tokenKo = tokenConsumo.getJsonRespuesta(TokenKo.class);

                if (tokenKo == null) {
                    System.err.println("Error: " + tokenConsumo.getRespuesta());
                    break;
                }

                System.err.println("Error: " + tokenKo.getError());

                break;

            case TokenConsumo.CORTOCIRCUITO:
                System.err.println("Error esta en cortocircuito.");
                break;

            default:
                break;
        }

    }
}
