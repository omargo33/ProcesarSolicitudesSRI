package com.d3v.utilitarios;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.Calendar;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.internet.MimeUtility;

public class MainConversiones {
  private static String PAQUETE_OBJETO = "cron.utilidades.MainConversiones";
  
  private static String NOMBRE_ARCHIVO = "TempFile";
  
  private static String TIPO_ENCRIPCION = "DES/ECB/PKCS5Padding";
  
  private static String BASE_CODIFICACION = "base64";
  
  private static final String keyBuffer = "56af65d2";
  
  public static String titulo(String nombre) {
    if (nombre != null && nombre.trim().length() > 1) {
      String respuesta = "";
      nombre = nombre.replaceAll("_", " ");
      StringTokenizer tokens = new StringTokenizer(nombre);
      while (tokens.hasMoreTokens()) {
        String dataTemp = tokens.nextToken();
        respuesta = respuesta.concat(" " + dataTemp.substring(0, 1).toUpperCase() + dataTemp.substring(1, dataTemp.length()).toLowerCase());
      } 
      return respuesta.trim();
    } 
    return (nombre == null) ? "." : nombre.trim().toUpperCase();
  }
  
  public static int convierteInt(String valor) {
    try {
      return (new Integer(valor)).intValue();
    } catch (NumberFormatException e) {
      return 0;
    } 
  }
  
  public static Date convierteDate(String valor) {
    Calendar cal = Calendar.getInstance();
    cal.set(1, (new Integer(valor.substring(0, 4))).intValue());
    cal.set(2, (new Integer(valor.substring(5, 7))).intValue());
    cal.set(5, (new Integer(valor.substring(8, 10))).intValue());
    cal.set(10, 0);
    cal.set(12, 0);
    cal.set(13, 0);
    cal.set(14, 0);
    return new Date(cal.getTimeInMillis());
  }
  
  public static Date convierteDate(String fecha, String hora) {
    Calendar cal = Calendar.getInstance();
    try {
      StringTokenizer Tok = new StringTokenizer(fecha, "/");
      if (Tok.hasMoreElements())
        cal.set(5, (new Integer((String)Tok.nextElement())).intValue()); 
      if (Tok.hasMoreElements()) {
        String dato = (String)Tok.nextElement();
        if (dato.equalsIgnoreCase("ene"))
          cal.set(2, 1); 
        if (dato.equalsIgnoreCase("feb"))
          cal.set(2, 2); 
        if (dato.equalsIgnoreCase("mar"))
          cal.set(2, 3); 
        if (dato.equalsIgnoreCase("abr"))
          cal.set(2, 4); 
        if (dato.equalsIgnoreCase("may"))
          cal.set(2, 5); 
        if (dato.equalsIgnoreCase("jun"))
          cal.set(2, 6); 
        if (dato.equalsIgnoreCase("jul"))
          cal.set(2, 7); 
        if (dato.equalsIgnoreCase("ago"))
          cal.set(2, 8); 
        if (dato.equalsIgnoreCase("sep"))
          cal.set(2, 9); 
        if (dato.equalsIgnoreCase("oct"))
          cal.set(2, 10); 
        if (dato.equalsIgnoreCase("nov"))
          cal.set(2, 11); 
        if (dato.equalsIgnoreCase("dic"))
          cal.set(2, 12); 
      } 
      if (Tok.hasMoreElements())
        cal.set(1, (new Integer((String)Tok.nextElement())).intValue()); 
      Tok = new StringTokenizer(hora, ":");
      if (Tok.hasMoreElements())
        cal.set(10, (new Integer((String)Tok.nextElement())).intValue()); 
      if (Tok.hasMoreElements())
        cal.set(12, (new Integer((String)Tok.nextElement())).intValue()); 
      if (Tok.hasMoreElements())
        cal.set(13, (new Integer((String)Tok.nextElement())).intValue()); 
      cal.set(14, 0);
    } catch (Exception e) {
      MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".convierteDate()", e.toString() });
    } 
    return new Date(cal.getTimeInMillis());
  }
  
  public static byte[] convierteByte(String pathFile) {
    File file = new File(pathFile);
    byte[] b = new byte[(int)file.length()];
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      fileInputStream.read(b);
    } catch (FileNotFoundException e) {
      MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".convierteByte() -> FileNotFoundException", e.toString() });
      return null;
    } catch (IOException e1) {
      MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".convierteByte() -> IOException", e1.toString() });
      return null;
    } 
    return b;
  }
  
  public static double convierteDouble(String valor) {
    try {
      return (new Double(valor)).doubleValue();
    } catch (NumberFormatException e) {
      return 0.0D;
    } 
  }
  
  public static File convierteFile(InputStream inputStream, String path, int largo) {
    try {
      File f = new File(path);
      OutputStream out = new FileOutputStream(f);
      byte[] buf = new byte[largo];
      int len = 0;
      while ((len = inputStream.read(buf)) > 0)
        out.write(buf, 0, len); 
      out.close();
      inputStream.close();
      return new File(MainBackdoor.archivoTemporalSistemaOperativo() + NOMBRE_ARCHIVO);
    } catch (Exception e) {
      MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".convierteFile()", e.toString() });
      return null;
    } 
  }
  
  public static File convierteFile(InputStream inputStream, int largo) {
    return convierteFile(inputStream, MainBackdoor.archivoTemporalSistemaOperativo() + NOMBRE_ARCHIVO, largo);
  }
  
  public static double convierteDouble(String valor, int decimales) {
    try {
      double d = (new Double(valor)).doubleValue();
      BigDecimal bd = new BigDecimal(Double.toString(d));
      bd = bd.setScale(decimales, 4);
      return bd.doubleValue();
    } catch (NumberFormatException e) {
      return 0.0D;
    } 
  }
  
  public static String convierteString(InputStream inputStream) {
    try {
      if (inputStream != null) {
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        try {
          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
          while ((line = bufferedReader.readLine()) != null)
            stringBuilder.append(line).append("\n"); 
        } finally {
          inputStream.close();
        } 
        return stringBuilder.toString();
      } 
      return "";
    } catch (Exception e) {
      MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".convierteString()", e.toString() });
      return null;
    } 
  }
  
  public static InputStream convierteInputStream(String texto) {
    try {
      return new ByteArrayInputStream(texto.getBytes());
    } catch (Exception e) {
      MainFiles.escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".convierteInputStream()", e.toString() });
      return null;
    } 
  }
  
  public static String agregaEspacios(Object... palabras) {
    String mensaje = "";
    for (int i = 0; i < palabras.length; i++) {
      String palabra = null;
      try {
        palabra = palabras[i].toString().trim();
      } catch (Exception e) {
        palabra = "";
      } 
      mensaje = mensaje + palabra + " ";
    } 
    return mensaje;
  }
  
  public static String addSt(Object... parametros) {
    String words = "";
    for (int i = 0; i < parametros.length; i++)
      words = words + parametros[i].toString() + " "; 
    return words.trim();
  }
  
  public static String cortar(String texto, int corte) {
    return (texto == null) ? "" : texto.trim().substring(0, (texto.trim().length() > corte - 1) ? (corte - 1) : texto.trim().length());
  }
  
  public String encripta(String datos) {
    try {
      SecureRandom securerandom = new SecureRandom();
      securerandom.nextBytes("56af65d2".getBytes());
      Cipher cipher = Cipher.getInstance(TIPO_ENCRIPCION);
      cipher.init(1, getKey());
      byte[] abyte0 = encode(cipher.doFinal(datos.getBytes()));
      return new String(abyte0);
    } catch (Exception e) {
      MainFiles.escribirLogDefault(new Object[] { getClass().getName(), ".encripta()", e.toString() });
      return null;
    } 
  }
  
  public String desencripta(String datosEncriptados) {
    try {
      Cipher cipher = Cipher.getInstance(TIPO_ENCRIPCION);
      cipher.init(2, getKey());
      byte[] abyte0 = cipher.doFinal(decode(datosEncriptados.getBytes()));
      return new String(abyte0);
    } catch (Exception e) {
      MainFiles.escribirLogDefault(new Object[] { getClass().getName(), ".desencripta()", e.toString() });
      return null;
    } 
  }
  
  private static SecretKeySpec getKey() {
    SecretKeySpec key = new SecretKeySpec("56af65d2".getBytes(), "DES");
    return key;
  }
  
  public static byte[] decode(byte[] datoDecodificar) throws Exception {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datoDecodificar);
    InputStream inputStream = MimeUtility.decode(byteArrayInputStream, BASE_CODIFICACION);
    byte[] tmp = new byte[datoDecodificar.length];
    int n = inputStream.read(tmp);
    byte[] res = new byte[n];
    System.arraycopy(tmp, 0, res, 0, n);
    return res;
  }
  
  public static byte[] encode(byte[] datoCodificar) throws Exception {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    OutputStream outputStream = MimeUtility.encode(byteArrayOutputStream, BASE_CODIFICACION);
    outputStream.write(datoCodificar);
    outputStream.close();
    return byteArrayOutputStream.toByteArray();
  }
}
