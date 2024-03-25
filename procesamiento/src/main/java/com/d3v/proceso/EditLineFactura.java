package com.d3v.proceso;

import com.d3v.utilitarios.Pagos;
import com.d3v.utilitarios.UDC;
import com.fundamentos.conexion.managerBD;
import com.d3v.utilitarios.MainFechaString;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.springframework.beans.BeanUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class EditLineFactura {
  dsF57011Z1 comprobanteCabecera = new dsF57011Z1();
  
  List<dsF57011Z1> comprobanteDetalle;
  
  List<dsF0711Z1> pagosDetalle;
  
  float mntotalSinImpuestos = 0.0F;
  
  float mntotalDescuentos = 0.0F;
  
  float mntotalConImpuestos = 0.0F;
  
  String szPorcentajeIVAVigente = "";
  
  float mnbaseIVAVigente = 0.0F;
  
  float mnIVAVigente = 0.0F;
  
  float mnbaseIVA0 = 0.0F;
  
  float mnBaseICE = 0.0F;
  
  float mnTotalICE = 0.0F;
  
  float mnPropina = 0.0F;
  
  float mnBaseIRBPNR = 0.0F;
  
  float mnTotalIRBPNR = 0.0F;
  
  private String xml;
  
  private AnalizarXMLRespuesta autorizacion = new AnalizarXMLRespuesta();
  
  public EditLineFactura() {
    setComprobanteDetalle(new ArrayList<>());
    setComprobanteCabecera(new dsF57011Z1());
    setPagosDetalle(new ArrayList<>());
    setXml("");
  }
  
  public static String limpiarEspaciosBlanco(String xml) {
    return xml.replaceAll("\\s*(<\\?xml[^>]*\\?>)\\s*", "$1");
  }
  
  public void procesarComprobante(managerBD BD, String esquema, String xmlAutorizado, String empresaDocumento, String tipoDocumento, String nroDocumento, String empresaComprobante, String tipoComprobante, String nroComprobante) {
    String prologoXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    cadenaXML(xmlAutorizado);
    boolean procesarOK = true;
    String comprobante = "";
    String nroAutorizacion = "";
    String fechaAutorizacion = "";
    this.autorizacion = new AnalizarXMLRespuesta();
    this.autorizacion.procesar(getXml());
    this.autorizacion.descuartizaXML();
    if (this.autorizacion.getAutorizacionOk().getEstado().isEmpty()) {
      procesarOK = false;
    } else {
      comprobante = this.autorizacion.getAutorizacionOk().getComprobante();
      nroAutorizacion = this.autorizacion.getAutorizacionOk().getNumeroAutorizacion();
      fechaAutorizacion = this.autorizacion.getAutorizacionOk().getFechaAutorizacion();
    } 
    if (procesarOK) {
      descuartizarComprobante(comprobante);
      int i;
      for (i = 0; i < this.comprobanteDetalle.size(); i++) {
        if (nroDocumento.isEmpty() || nroDocumento.equals("") || nroDocumento.equals(" ")) {
          EditLinerNroSiguiente nn = new EditLinerNroSiguiente();
          nn.setBD(BD);
          nn.setEsquema(esquema);
          nn.getDSF0022().setAnioFiscal(Integer.valueOf(MainFechaString.fechaFormateada(new Date(), "yyyy")).intValue());
          nn.getDSF0022().setCompany(empresaComprobante);
          nn.getDSF0022().setTypeDoc(tipoComprobante);
          nn.editLine("1");
          nroDocumento = String.valueOf(nn.getDSF0022().getNextNumber());
        } 
        if (nroComprobante.isEmpty() || nroComprobante.equals("") || nroComprobante.equals(" ")) {
          EditLinerNroSiguiente nn = new EditLinerNroSiguiente();
          nn.setBD(BD);
          nn.setEsquema(esquema);
          nn.getDSF0022().setAnioFiscal(Integer.valueOf(MainFechaString.fechaFormateada(new Date(), "yyyy")).intValue());
          nn.getDSF0022().setCompany(empresaDocumento);
          nn.getDSF0022().setTypeDoc(tipoDocumento);
          nn.editLine("1");
          nroComprobante = String.valueOf(nn.getDSF0022().getNextNumber());
        } 
        EditLinerNroSiguiente nno = new EditLinerNroSiguiente();
        nno.setBD(BD);
        nno.setEsquema(esquema);
        nno.getDSF00221().setObjeto("t57011z1");
        nno.editlineObjeto("1");
        String nroTrabajo = String.valueOf(nno.getDSF00221().getNextNumber());
        try {
          EditLineSalesZ1 pZ1 = new EditLineSalesZ1();
          dsF57011Z1 detalleTemporal = new dsF57011Z1();
          BeanUtils.copyProperties(this.comprobanteDetalle.get(i), detalleTemporal);
          pZ1.setDSF57011Z1(detalleTemporal);
          pZ1.getDSF57011Z1().setSzDocumentCompany(empresaDocumento);
          pZ1.getDSF57011Z1().setSzDocumentType(tipoDocumento);
          pZ1.getDSF57011Z1().setMnDocumentNumber(nroDocumento);
          pZ1.getDSF57011Z1().setMnLineNumber(String.valueOf(i + 1));
          pZ1.getDSF57011Z1().setSzInvoiceCompany(empresaComprobante);
          pZ1.getDSF57011Z1().setSzInvoiceType(tipoComprobante);
          pZ1.getDSF57011Z1().setMnInvoiceNumber(nroComprobante);
          pZ1.getDSF57011Z1().setMnLegalNumber("9999999999");
          pZ1.getDSF57011Z1().setMnJobNumber(nroTrabajo);
          pZ1.getDSF57011Z1().setSzUserID("ROBOT");
          pZ1.getDSF57011Z1().setJdDateUpdated(MainFechaString.fechaFormateada(new Date(), "yyyy-MM-dd"));
          pZ1.getDSF57011Z1().setSzMember("LOADINV");
          pZ1.getDSF57011Z1().setSzWorkStationID("-");
          pZ1.getDSF57011Z1().setSzComputerID("-");
          pZ1.getDSF57011Z1().setMnTimeofDay(MainFechaString.getHora());
          pZ1.getDSF57011Z1().setSzAutorizacionElectronica(nroAutorizacion);
          pZ1.getDSF57011Z1().setSzRefAutorizacion1(fechaAutorizacion);
          pZ1.setEsquema(esquema);
          pZ1.setBD(BD);
          pZ1.editLine("2");
        } catch (Exception e) {
          System.err.println("Genero una expcial registrar el comprobante: " + e.toString());
        } 
      } 
      for (i = 0; i < this.pagosDetalle.size(); i++) {
        EditLineNegociacion neg = new EditLineNegociacion();
        neg.setDocDocument((new Integer(nroDocumento)).intValue());
        neg.setDocEmpresa(empresaDocumento);
        neg.setDocType(tipoDocumento);
        neg.setId(empresaDocumento + tipoDocumento + nroDocumento);
        neg.setSequence(i + 1);
        neg.setCreationDateTime(MainFechaString.fechaFormateada(new Date(), "yyyy-MM-dd hh:mm:ss"));
        neg.setPaymentTransactionID(empresaDocumento + tipoDocumento + nroDocumento + neg.getSequence());
        neg.setPaymentAmount(((dsF0711Z1)this.pagosDetalle.get(i)).getMonto());
        neg.setTypeOperation(((dsF0711Z1)this.pagosDetalle.get(i)).getIdIntrumentoPago());
        UDC udc = new UDC();
        udc.setModulo("57");
        udc.setConstante("PY");
        udc.setDescripcion2(((dsF0711Z1)this.pagosDetalle.get(i)).getIdIntrumentoPago());
        udc.retrieveDescripcion2(BD, esquema);
        neg.setTypeOperation(udc.getCodigoDefinidoUsuario());
        neg.setValueDate(MainFechaString.fechaFormateada(new Date(), "yyyy-MM-dd"));
        neg.setUsuarioOriginador("DLAUTOM");
        neg.setUsuarioModficador("DLAUTOM");
        neg.setFechaOrigen(MainFechaString.fechaFormateada(new Date(), "yyyy-MM-dd"));
        neg.setFechaModificada(MainFechaString.fechaFormateada(new Date(), "yyyy-MM-dd"));
        neg.saveTransaction(BD, esquema);
      } 
    } 
  }
  
  public String cambioFormatoRecuperaFechaBD(String date) {
    String fecha = "";
    try {
      SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
      Date fechaDate = dmyFormat.parse(date);
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      fecha = dateFormat.format(fechaDate);
      return fecha;
    } catch (Exception ex) {
      return ex.toString();
    } 
  }
  
  public void descuartizarComprobante(String xml) {
    String estab = "";
    String ptoEmi = "";
    String secuencial = "";
    dsF57011Z1 comprobante = new dsF57011Z1();
    Document document = parseXmlFile(xml);
    NodeList nodeLst = document.getElementsByTagName("infoTributaria");
    int i;
    for (i = 0; i < nodeLst.getLength(); i++) {
      Node nodo = nodeLst.item(i);
      for (int k = 0; k < nodo.getChildNodes().getLength(); k++) {
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("ambiente"))
          if (nodo.getChildNodes().item(k).getTextContent().equals("1")) {
            comprobante.setSzAmbiente("PRUEBAS");
          } else {
            comprobante.setSzAmbiente("PRODUCCIÓN");
          }  
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("tipoEmision"))
          if (nodo.getChildNodes().item(k).getTextContent().equals("1")) {
            comprobante.setSzTipoEmision("NORMAL");
          } else {
            comprobante.setSzTipoEmision("CONTINGENCIA");
          }  
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("razonSocial"))
          comprobante.setSzName(nodo.getChildNodes().item(k).getTextContent().toUpperCase()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("ruc"))
          comprobante.setSzTaxIdentificationNumber(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("claveAcceso"))
          comprobante.setSzClaveAcceso(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("codDoc") && nodo
          .getChildNodes().item(k).getTextContent().equals("01"))
          comprobante.setSzOperationType("FACTURA"); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("estab"))
          estab = nodo.getChildNodes().item(k).getTextContent(); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("ptoEmi"))
          ptoEmi = nodo.getChildNodes().item(k).getTextContent(); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("secuencial"))
          secuencial = nodo.getChildNodes().item(k).getTextContent(); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("dirMatriz"))
          comprobante.setSzAddressLine1(nodo.getChildNodes().item(k).getTextContent().toUpperCase()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("regimenMicroempresas"))
          comprobante.setSzParameterDataItem04(nodo.getChildNodes().item(k).getTextContent().toUpperCase()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("agenteRetencion"))
          comprobante.setSzParameterDataItem05(nodo.getChildNodes().item(k).getTextContent().toUpperCase()); 
      } 
    } 
    nodeLst = document.getElementsByTagName("infoFactura");
    for (i = 0; i < nodeLst.getLength(); i++) {
      Node nodo = nodeLst.item(i);
      for (int k = 0; k < nodo.getChildNodes().getLength(); k++) {
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("fechaEmision"))
          comprobante.setJdDateInvoice(cambioFormatoRecuperaFechaBD(nodo.getChildNodes().item(k).getTextContent())); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("dirEstablecimiento"))
          comprobante.setSzAddressLine2(nodo.getChildNodes().item(k).getTextContent().toUpperCase()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("contribuyenteEspecial"))
          comprobante.setSzContribuyenteEspecial(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("obligadoContabilidad"))
          comprobante.setSzObligadoContabilidad(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("tipoIdentificacionComprador"))
          comprobante.setSzCatSales01(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("razonSocialComprador"))
          comprobante.setSzNameAlpha(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("identificacionComprador"))
          comprobante.setSzTaxID(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("direccionComprador"))
          comprobante.setSzAddressLine3(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("rise"))
          comprobante.setSzRise(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("moneda"))
          comprobante.setSzMoneda(nodo.getChildNodes().item(k).getTextContent()); 
        if (nodo.getChildNodes().item(k).getNodeName().equalsIgnoreCase("propina")) {
          comprobante.setMnAmountSalesTaxTotal1(nodo.getChildNodes().item(k).getTextContent());
          this.mnPropina += Float.valueOf(comprobante.getMnAmountSalesTaxTotal1()).floatValue();
        } 
      } 
    } 
    try {
      String cadenaPadre = "";
      nodeLst = document.getElementsByTagName("infoAdicional");
      for (int j = 0; j < nodeLst.getLength(); j++) {
        Node nodo = nodeLst.item(j);
        for (int l = 0; l < nodo.getChildNodes().getLength(); l++) {
          if (nodo.getChildNodes().item(l).getNodeName() != "#text") {
            Node granChildNode = nodo.getChildNodes().item(l);
            NamedNodeMap chileNamedNodeMap = granChildNode.getAttributes();
            for (int u = 0; u < chileNamedNodeMap.getLength(); u++) {
              Node granChildAttribute = chileNamedNodeMap.item(u);
              if (granChildAttribute.getNodeValue().equalsIgnoreCase("direccion"))
                comprobante.setSzAddressLine3(nodo.getChildNodes().item(l).getTextContent()); 
              if (granChildAttribute.getNodeValue().equalsIgnoreCase("Observacion"))
                comprobante.setSzParameterDataItem06(nodo.getChildNodes().item(l).getTextContent()); 
              String cadenaHijo = granChildAttribute.getNodeValue() + ": " + nodo.getChildNodes().item(l).getTextContent() + "; ";
              cadenaPadre = cadenaPadre + cadenaHijo;
            } 
          } 
        } 
      } 
    } catch (Exception e) {
      System.out.println("Se genero una exepcial analizar la informaciadicional");
    } 
    nodeLst = document.getElementsByTagName("pago");
    for (i = 0; i < nodeLst.getLength(); i++) {
      Node nodo = nodeLst.item(i);
      dsF0711Z1 tmp = new dsF0711Z1();
      for (int l = 0; l < nodo.getChildNodes().getLength(); l++) {
        if (nodo.getChildNodes().item(l).getNodeName() != "#text") {
          if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("formaPago")) {
            tmp.setIdIntrumentoPago(nodo.getChildNodes().item(l).getTextContent());
            tmp.setInstrumentoPago((new Pagos()).consultarDescripcion(nodo.getChildNodes().item(l).getTextContent()));
          } 
          if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("total"))
            tmp.setMonto(nodo.getChildNodes().item(l).getTextContent()); 
          if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("plazo"))
            tmp.setPlazo(nodo.getChildNodes().item(l).getTextContent()); 
          if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("unidadTiempo"))
            tmp.setUnidadTiempo(nodo.getChildNodes().item(l).getTextContent()); 
        } 
      } 
      this.pagosDetalle.add(tmp);
    } 
    nodeLst = document.getElementsByTagName("detalle");
    for (i = 0; i < nodeLst.getLength(); i++) {
      Node nodo = nodeLst.item(i);
      dsF57011Z1 detalle = new dsF57011Z1();
      comprobante.setSzReferenceLegal(estab + "-" + ptoEmi + "-" + secuencial);
      BeanUtils.copyProperties(comprobante, detalle);
      for (int l = 0; l < nodo.getChildNodes().getLength(); l++) {
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("codigoPrincipal"))
          detalle.setSz2ndItemNumber(nodo.getChildNodes().item(l).getTextContent()); 
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("descripcion"))
          detalle.setSzDescription(nodo.getChildNodes().item(l).getTextContent().toUpperCase()); 
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("cantidad"))
          detalle.setMnQuantityShipped(nodo.getChildNodes().item(l).getTextContent()); 
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("precioUnitario"))
          detalle.setMnAmountPriceUnit(nodo.getChildNodes().item(l).getTextContent()); 
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("descuento"))
          detalle.setMnDiscountAmount(nodo.getChildNodes().item(l).getTextContent()); 
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("impuestos")) {
          NodeList nodeLstimpuesto = nodo.getChildNodes().item(l).getChildNodes();
          for (int j = 0; j < nodeLstimpuesto.getLength(); j++) {
            Node nodoimpuesto = nodeLstimpuesto.item(j);
            if (nodo.getChildNodes().item(j).getNodeName() != "#text") {
              boolean procesarAcumuladores = false;
              for (int u = 0; u < nodoimpuesto.getChildNodes().getLength(); u++) {
                procesarAcumuladores = true;
                if (nodoimpuesto.getChildNodes().item(u).getNodeName().equalsIgnoreCase("codigo"))
                  detalle.setMnTaxRate1(nodoimpuesto.getChildNodes().item(u).getTextContent()); 
                if (nodoimpuesto.getChildNodes().item(u).getNodeName().equalsIgnoreCase("codigoPorcentaje"))
                  detalle.setMnTaxRate2(nodoimpuesto.getChildNodes().item(u).getTextContent()); 
                if (nodoimpuesto.getChildNodes().item(u).getNodeName().equalsIgnoreCase("baseImponible"))
                  detalle.setMnAmountExtendedPrice(nodoimpuesto.getChildNodes().item(u).getTextContent()); 
                if (nodoimpuesto.getChildNodes().item(u).getNodeName().equalsIgnoreCase("valor"))
                  detalle.setMnAmountTax(nodoimpuesto.getChildNodes().item(u).getTextContent()); 
              } 
              if (detalle.getMnDiscountAmount().equals(""))
                detalle.setMnDiscountAmount("0"); 
              if (procesarAcumuladores) {
                if (detalle.getMnTaxRate1().equals("2")) {
                  this.mntotalSinImpuestos += Float.valueOf(detalle.getMnAmountExtendedPrice()).floatValue();
                  this.mntotalDescuentos += Float.valueOf(detalle.getMnDiscountAmount()).floatValue();
                  if (!detalle.getMnTaxRate2().equals("0")) {
                    if (detalle.getMnTaxRate2().equals("2"))
                      this.szPorcentajeIVAVigente = "12"; 
                    if (detalle.getMnTaxRate2().equals("3"))
                      this.szPorcentajeIVAVigente = "14"; 
                    this.mnbaseIVAVigente += Float.valueOf(detalle.getMnAmountExtendedPrice()).floatValue();
                    this.mnIVAVigente += Float.valueOf(detalle.getMnAmountTax()).floatValue();
                  } else {
                    this.mnbaseIVA0 += Float.valueOf(detalle.getMnAmountExtendedPrice()).floatValue();
                  } 
                  this.mntotalConImpuestos += Float.valueOf(detalle.getMnAmountExtendedPrice()).floatValue() + Float.valueOf(detalle.getMnAmountTax()).floatValue();
                } 
                if (detalle.getMnTaxRate1().equals("3")) {
                  this.mnTotalICE += Float.valueOf(detalle.getMnAmountExtendedPrice()).floatValue();
                  this.mnBaseICE += Float.valueOf(detalle.getMnAmountTax()).floatValue();
                } 
                if (detalle.getMnTaxRate1().equals("5")) {
                  this.mnTotalIRBPNR += Float.valueOf(detalle.getMnAmountExtendedPrice()).floatValue();
                  this.mnBaseIRBPNR += Float.valueOf(detalle.getMnAmountTax()).floatValue();
                } 
              } 
            } 
          } 
        } 
        if (nodo.getChildNodes().item(l).getNodeName().equalsIgnoreCase("precioTotalSinImpuesto"))
          detalle.setMnAmountExtendedPrice(nodo.getChildNodes().item(l).getTextContent()); 
      } 
      this.comprobanteDetalle.add(detalle);
      this.comprobanteCabecera = detalle;
    } 
    if (!comprobante.getMnAmountSalesTaxTotal1().equals("")) {
      Float propina = new Float(0.0F);
      try {
        propina = new Float(comprobante.getMnAmountSalesTaxTotal1());
      } catch (Exception e) {
        propina = new Float(0.0F);
      } 
      this.mntotalConImpuestos += propina.floatValue();
    } 
  }
  
  public Document parseXmlFile(String in) {
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      InputSource is = new InputSource(new StringReader(in));
      return db.parse(is);
    } catch (Exception e) {
      System.out.println(getClass().getName() + ".parseXmlFile() " + e
          .toString());
      return null;
    } 
  }
  
  public void cadenaXML(String everything) {
    if (!everything.isEmpty()) {
      String xmltemp = everything;
      Matcher junkMatcher = Pattern.compile("^([\\W]+)<").matcher(xmltemp.trim());
      xmltemp = junkMatcher.replaceFirst("<");
      setXml(xmltemp);
    } 
  }
  
  public static Date StringToDate(String fecha, String caracter, int op) {
    String formato = "yyyy" + caracter + "MM" + caracter + "dd";
    if (op == 1) {
      formato = "yyyy" + caracter + "dd" + caracter + "MM";
    } else if (op == 2) {
      formato = "MM" + caracter + "yyyy" + caracter + "dd";
    } else if (op == 3) {
      formato = "MM" + caracter + "dd" + caracter + "yyyy";
    } else if (op == 4) {
      formato = "dd" + caracter + "yyyy" + caracter + "MM";
    } else if (op == 5) {
      formato = "dd" + caracter + "MM" + caracter + "yyyy";
    } 
    SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
    Date fechaFormato = null;
    try {
      sdf.setLenient(false);
      fechaFormato = sdf.parse(fecha);
    } catch (ParseException ex) {
      System.err.println("Genero una exepcial formatear la fecha: " + ex.toString());
    } 
    return fechaFormato;
  }
  
  public static String DateToString(Date fecha, String caracter, int op) {
    String formato = "yyyy" + caracter + "MM" + caracter + "dd";
    if (op == 1) {
      formato = "yyyy" + caracter + "dd" + caracter + "MM";
    } else if (op == 2) {
      formato = "MM" + caracter + "yyyy" + caracter + "dd";
    } else if (op == 3) {
      formato = "MM" + caracter + "dd" + caracter + "yyyy";
    } else if (op == 4) {
      formato = "dd" + caracter + "yyyy" + caracter + "MM";
    } else if (op == 5) {
      formato = "dd" + caracter + "MM" + caracter + "yyyy";
    } 
    SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
    String fechaFormato = null;
    sdf.setLenient(false);
    fechaFormato = sdf.format(fecha);
    return fechaFormato;
  }
  
  public dsF57011Z1 getComprobanteCabecera() {
    return this.comprobanteCabecera;
  }
  
  public void setComprobanteCabecera(dsF57011Z1 comprobanteCabecera) {
    this.comprobanteCabecera = comprobanteCabecera;
  }
  
  public List<dsF57011Z1> getComprobanteDetalle() {
    return this.comprobanteDetalle;
  }
  
  public void setComprobanteDetalle(List<dsF57011Z1> comprobanteDetalle) {
    this.comprobanteDetalle = comprobanteDetalle;
  }
  
  public List<dsF0711Z1> getPagosDetalle() {
    return this.pagosDetalle;
  }
  
  public void setPagosDetalle(List<dsF0711Z1> pagosDetalle) {
    this.pagosDetalle = pagosDetalle;
  }
  
  public String getXml() {
    return this.xml;
  }
  
  public void setXml(String xml) {
    this.xml = xml;
  }
}