
package com.sri.procesamiento;

public class Clientes {
    
    private String usuario;
    private String baseDatos;
    private String sriUsuario;
    private String sriCredencial;
    
    public void solicitudConfiguracion(String codigo) {

        //Katalina Asmal
        if (codigo.equals("1")) {
            setUsuario("dveloper_catalina_usuario");
            setBaseDatos("dveloper_catalina");
            setSriUsuario("0103153425001");
            setSriCredencial("LCAG2019");
        }
        
        //Don Vinicio
        if (codigo.equals("2")) {
            setUsuario("dveloper_rosa_usuario");
            setBaseDatos("dveloper_rosa");
            setSriUsuario("0911774198001");
            setSriCredencial("ROSITA1234");
        }
        
        //Indupan
        if (codigo.equals("3")) {
            setUsuario("dveloper_indupan_facturador");
            setBaseDatos("dveloper_indupan");
            setSriUsuario("1715726772001");
            setSriCredencial("Indupan1111@");
        }
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }

    public String getSriUsuario() {
        return sriUsuario;
    }

    public void setSriUsuario(String sriUsuario) {
        this.sriUsuario = sriUsuario;
    }

    public String getSriCredencial() {
        return sriCredencial;
    }

    public void setSriCredencial(String sriCredencial) {
        this.sriCredencial = sriCredencial;
    }
    
}
