package com.d3v.utilitarios;

public class MainBackdoor {
    private static String PROPIEDAD_NOMBRE_SISTEMA = "os.name";
    
    public static boolean isWindows() {
      String os = System.getProperty(PROPIEDAD_NOMBRE_SISTEMA).toLowerCase();
      return (os.indexOf("win") >= 0);
    }
    
    public static boolean isMac() {
      String os = System.getProperty(PROPIEDAD_NOMBRE_SISTEMA).toLowerCase();
      return (os.indexOf("mac") >= 0);
    }
    
    public static boolean isUnix() {
      String os = System.getProperty(PROPIEDAD_NOMBRE_SISTEMA).toLowerCase();
      return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
    }
    
    public static boolean isSolaris() {
      String os = System.getProperty(PROPIEDAD_NOMBRE_SISTEMA).toLowerCase();
      return (os.indexOf("sunos") >= 0);
    }
    
    public static String archivoTemporalSistemaOperativo() {
      if (isUnix())
        return "/tmp/js_"; 
      if (isWindows())
        return "C:/Windows/Temp/ds_"; 
      return null;
    }
  }
  