package com.d3v.proceso;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class AnalizarXMLRespuesta {
  private String XML;

  private Autorizacion autorizacionOk;

  private List<Autorizacion> listaAutorizacion;

  public AnalizarXMLRespuesta() {
    setAutorizacionOk(new Autorizacion());
  }

  public void procesar(String in) {
    setXML(in);
  }

  public Document parseXmlFile(String in) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      InputSource is = new InputSource(new StringReader(in));
      return db.parse(is);
    } catch (Exception e) {
      log.error("Error al parsear el archivo XML: {}", e.toString());
      return null;
    }
  }

  public void descuartizaXML() {
    setListaAutorizacion(new ArrayList<>());
    Document document = parseXmlFile(getXML());
    NodeList nodeLst = document.getElementsByTagName("Authorization");
    for (int i = 0; i < nodeLst.getLength(); i++) {
      Node nodo = nodeLst.item(i);
      Autorizacion autorizacion = new Autorizacion();
      for (int k = 0; k < nodo.getChildNodes().getLength(); k++) {
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("estado"))
          autorizacion.setEstado(nodo.getChildNodes().item(k).getTextContent());
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("numeroAutorizacion"))
          autorizacion.setNumeroAutorizacion(nodo.getChildNodes().item(k).getTextContent());
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("ambiente"))
          autorizacion.setAmbiente(nodo.getChildNodes().item(k).getTextContent());
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("comprobante"))
          autorizacion.setComprobante(nodo.getChildNodes().item(k).getTextContent());
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("fechaAutorizacion"))
          autorizacion.setFechaAutorizacion(nodo.getChildNodes().item(k).getTextContent());
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("mensajes")) {
          NodeList nodeLstMensajes = nodo.getChildNodes().item(k).getChildNodes();
          for (int j = 0; j < nodeLstMensajes.getLength(); j++) {
            Node nodoMensaje = nodeLstMensajes.item(j);
            MensajeAutorizacion mensajeAutorizacion = new MensajeAutorizacion();
            for (int l = 0; l < nodoMensaje.getChildNodes().getLength(); l++) {
              if (nodoMensaje.getChildNodes().item(l).getNodeName().equalsIgnoreCase("identificador"))
                mensajeAutorizacion.setIdentificador(nodoMensaje.getChildNodes().item(l).getTextContent());
              if (nodoMensaje.getChildNodes().item(l).getNodeName().equalsIgnoreCase("mensaje"))
                mensajeAutorizacion.setMensaje(nodoMensaje.getChildNodes().item(l).getTextContent());
              if (nodoMensaje.getChildNodes().item(l).getNodeName().equalsIgnoreCase("tipo"))
                mensajeAutorizacion.setTipo(nodoMensaje.getChildNodes().item(l).getTextContent());
            }
            autorizacion.getListaMensajeAutorizacion().add(mensajeAutorizacion);
          }
        }
      }
      if (autorizacion.getEstado().equalsIgnoreCase("AUTORIZADO")) {
        autorizacion.setTipoComprobante(descuartizaComprobante(autorizacion.getComprobante()));
        setAutorizacionOk(autorizacion);
      }
      getListaAutorizacion().add(autorizacion);
    }
  }

  public String descuartizaComprobante(String xmlComprobante) {
    String tipoComprobante = null;
    Document document = parseXmlFile(xmlComprobante);
    NodeList nodeLst = document.getElementsByTagName("infoTributaria");
    for (int i = 0; i < nodeLst.getLength(); i++) {
      Node nodo = nodeLst.item(i);
      for (int k = 0; k < nodo.getChildNodes().getLength(); k++) {
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("codDoc"))
          tipoComprobante = nodo.getChildNodes().item(k).getTextContent();
      }
    }
    return tipoComprobante;
  }

  public String getXML() {
    return this.XML;
  }

  public void setXML(String XML) {
    this.XML = XML;
  }

  public Autorizacion getAutorizacionOk() {
    return this.autorizacionOk;
  }

  public void setAutorizacionOk(Autorizacion autorizacionOk) {
    this.autorizacionOk = autorizacionOk;
  }

  public List<Autorizacion> getListaAutorizacion() {
    return this.listaAutorizacion;
  }

  public void setListaAutorizacion(List<Autorizacion> listaAutorizacion) {
    this.listaAutorizacion = listaAutorizacion;
  }
}
