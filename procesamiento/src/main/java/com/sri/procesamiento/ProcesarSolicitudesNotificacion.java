
package com.sri.procesamiento;

import com.d3v.proceso.EditLineFactura;
import com.fundamentos.conexion.ManagerBD;

import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;

@Slf4j
public class ProcesarSolicitudesNotificacion {

    public static String CARPETA_EMPRESA = "COMPROBANTES";
    
   /* public void procesar() {

        SolicitudToken solicitudToken = new SolicitudToken();
        solicitudToken.procesarSolicitud(Configuracion.CLIENT_ID, Configuracion.SECRET_ID, "client_credentials");
        solicitudToken.getToken(); // Variable maestra de procesamiento
  
        Clientes clientes = new Clientes();
   
        //Carga de facturas masivamente
        for (int i = 1; i <= 3; i++) {

            try {
                //Configuracion global del cliente 
                clientes.solicitudConfiguracion(String.valueOf(i));

                //Procesar movimientos de clientes utilizando el token
                DescargarMovimientosProveedores descargarMovimientosProveedores = new DescargarMovimientosProveedores();
                descargarMovimientosProveedores.procesarSolicitud(
                        solicitudToken.getToken(),
                        clientes.getSriUsuario(),
                        clientes.getSriCredencial(),
                        "03",
                        "2024");

                //Descarga de movimientos consolidados
                String respuestaSolicitud = descargarMovimientosProveedores.getRespuestaSolicitud();

                //Registro de movimientos consolidados
                descargarMovimientosProveedores.analizarRespuesta(
                        respuestaSolicitud,
                        clientes.getUsuario(),
                        Configuracion.CREDENCIAL_MAESTRA,
                        clientes.getBaseDatos());

            } catch (Exception e) {
                log.error("Genero un error al descargar la solicitud. {}", e.toString());
            }
        }

        //Descarga y procesamiento de comprobantes a nivel de detalle
        for (int i = 1; i <= 3; i++) {
            clientes.solicitudConfiguracion(String.valueOf(i));
            
            try {
              
                ManagerBD BD = new ManagerBD("com.mysql.jdbc.Driver", "jdbc:mysql://50.31.188.7/" + clientes.getBaseDatos() + "?autoReconnect=true&useSSL=false");
                if (BD.initDBMySql(clientes.getUsuario(), Configuracion.CREDENCIAL_MAESTRA)) {
                                        
                    log.error("Procesando detalle del usuario -> {}", clientes.getSriUsuario());

                    String query = "SELECT a.access_key FROM resumenDocumentosProveedores a WHERE a.access_key NOT IN (SELECT b.szClaveAcceso FROM  t57011 b )";

                    ResultSet data = BD.sqlResultSet(query);
                    while (data.next()) {

                        String claveAcceso = data.getString("access_key");                        
                        log.error("-> {}" + claveAcceso);
                   
                        ConsultaDocumento documento = new ConsultaDocumento();
                        documento.procesarSolicitud(
                                solicitudToken.getToken(),
                                clientes.getSriUsuario(),
                                clientes.getSriCredencial(),
                                claveAcceso);

                        try {
                            if (documento.getEstadoSolicitud().equals("200")) {
                                //Registrar Archivos Descargado
                                ManagerBD BD_ = new ManagerBD("com.mysql.jdbc.Driver", "jdbc:mysql://50.31.188.7/" + clientes.getBaseDatos() + "?autoReconnect=true&useSSL=false");
                                if (BD_.initDBMySql(clientes.getUsuario(), Configuracion.CREDENCIAL_MAESTRA));

                                try {
                                    new EditLineFactura().procesarComprobante(
                                            BD_,
                                            clientes.getBaseDatos(),
                                            documento.getRespuestaSolicitud(),
                                            "00001",
                                            "FX", // Factura por automatizacion
                                            "",
                                            "00001",
                                            "RX",
                                            "");

                                } catch (Exception e) {
                                    log.error("Se genero una expeción: ", e.toString());
                                    
                                }
                                BD_.desconectar();
                            }

                        } catch (Exception e) {
                            log.error("Se genero una excepcion al registrar el comprobante {}", claveAcceso);
                        }
                    }
                }
             
                BD.desconectar();
            } catch (Exception e) {
                log.error("Error al procesar la solicitud {} -> {}", clientes.getBaseDatos(), e.toString());
            }
        }
    }*/
}
