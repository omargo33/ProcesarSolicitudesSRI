
package com.sri.procesamiento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clientes {

    private String usuario;
    private String baseDatos;
    private String sriUsuario;
    private String sriCredencial;

    public void solicitudConfiguracion(String codigo) {
        // Katalina Asmal
        if (codigo.equals("1")) {
            setUsuario("dveloper_catalina_usuario");
            setBaseDatos("dveloper_catalina");
            setSriUsuario("0103153425001");
            setSriCredencial("LCAG2019");
        }

        // Don Vinicio
        if (codigo.equals("2")) {
            setUsuario("dveloper_rosa_usuario");
            setBaseDatos("dveloper_rosa");
            setSriUsuario("0911774198001");
            setSriCredencial("ROSITA1234");
        }

        // Indupan
        if (codigo.equals("3")) {
            setUsuario("dveloper_indupan_facturador");
            setBaseDatos("dveloper_indupan");
            setSriUsuario("1715726772001");
            setSriCredencial("Indupan1111@");
        }
    }
}
