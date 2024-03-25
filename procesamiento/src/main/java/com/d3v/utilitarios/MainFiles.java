package com.d3v.utilitarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MainFiles {
  private String path;
  
  private boolean exitInmediate;
  
  private static String PAQUETE_OBJETO = "cron.utilidades.MainFiles";
  
  public MainFiles(String Path) {
    this.path = Path;
    setExitInmediate(true);
  }
  
  MainFiles() {}
  
  public String getPath() {
    return this.path;
  }
  
  public File archivo() {
    return new File(this.path);
  }
  
  public String getText() {
    try {
      File fichaEntrada = new File(MainBackdoor.archivoTemporalSistemaOperativo() + this.path);
      FileInputStream canalEntrada = new FileInputStream(fichaEntrada);
      byte[] bt = new byte[(int)fichaEntrada.length()];
      canalEntrada.read(bt);
      canalEntrada.close();
      return new String(bt);
    } catch (IOException e) {
      if (isExitInmediate())
        escribirLogDefault(new Object[] { getClass().getName(), ".getText()", e.toString() }); 
      return "";
    } 
  }
  
  public String toString() {
    return getText();
  }
  
  public void setText(String text) {
    try {
      byte[] b = text.getBytes();
      File fichaSalida = new File(MainBackdoor.archivoTemporalSistemaOperativo() + this.path);
      FileOutputStream canalSalida = new FileOutputStream(fichaSalida);
      canalSalida.write(b);
      canalSalida.close();
    } catch (IOException e) {
      escribirLogDefault(new Object[] { getClass().getName(), ".setText()", e.toString() });
    } 
  }
  
  public String getEncriptado() {
    return (new MainConversiones()).desencripta(getText());
  }
  
  public void setEncriptado(String text) {
    setText((new MainConversiones()).encripta(text));
  }
  
  public boolean isExitInmediate() {
    return this.exitInmediate;
  }
  
  public void setExitInmediate(boolean exitInmediate) {
    this.exitInmediate = exitInmediate;
  }
  
  public static String escribirLog(String f, String s) {
    try {
      FileWriter fileWriter = new FileWriter(f, true);
      fileWriter.write(s + "\n");
      fileWriter.flush();
      fileWriter.close();
    } catch (IOException e) {
      return MainConversiones.agregaEspacios(new Object[] { "ko", e.toString() });
    } 
    return "ok";
  }
  
  public static String escribirLogDefault(Object... palabras) {
    return escribirLog("servidor", palabras);
  }
  
  public static String escribirLog(String nombre, Object... palabras) {
    String mensaje = MainFechaString.getHora() + ": ";
    for (int i = 0; i < palabras.length; i++) {
      String palabra = null;
      try {
        palabra = palabras[i].toString().trim();
      } catch (Exception e) {
        palabra = "";
      } 
      if (palabra.startsWith(".")) {
        mensaje = mensaje.trim() + palabra + " ";
      } else {
        mensaje = mensaje + palabra + " ";
      } 
    } 
    return escribirLog(MainBackdoor.archivoTemporalSistemaOperativo() + nombre + "_" + MainFechaString.getNombreFileDate(), mensaje);
  }
  
  public static void borrarArchivo(String path) {
    File f1 = new File(path);
    boolean success = f1.delete();
    if (!success)
      escribirLogDefault(new Object[] { escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".borrarArchivo()" }) }); 
  }
  
  public static void comprimirZip(String filename, String zipfilename, int largo) {
    try {
      byte[] buf = new byte[largo];
      FileInputStream fis = new FileInputStream(filename);
      fis.read(buf, 0, buf.length);
      CRC32 crc = new CRC32();
      ZipOutputStream s = new ZipOutputStream(new FileOutputStream(zipfilename));
      s.setLevel(6);
      ZipEntry entry = new ZipEntry(filename);
      entry.setSize(buf.length);
      crc.reset();
      crc.update(buf);
      entry.setCrc(crc.getValue());
      s.putNextEntry(entry);
      s.write(buf, 0, buf.length);
      s.finish();
      s.close();
    } catch (Exception e) {
      escribirLogDefault(new Object[] { PAQUETE_OBJETO + ".comprimirZip()" });
    } 
  }
}
