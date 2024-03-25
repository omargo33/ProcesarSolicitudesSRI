package com.fundamentos.conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class managerBD {
  private String DRIVER_NAME;
  
  private String DATABASE_URL;
  
  public Connection con;
  
  public CallableStatement callp;
  
  public Statement stt;
  
  public String msjError;
  
  public managerBD(String driver, String url) {
    this.DRIVER_NAME = driver;
    this.DATABASE_URL = url;
  }
  
  public boolean initDBMySql(String User, String Pass) {
    try {
      Class.forName(this.DRIVER_NAME).newInstance();
      DriverManager.setLoginTimeout(60);
      this.con = DriverManager.getConnection(this.DATABASE_URL, User, Pass);
      this.stt = this.con.createStatement();
      this.con.setAutoCommit(false);
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      setMsjError(e.getMessage());
      return false;
    } catch (Exception ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } 
    return true;
  }
  
  public boolean initDBSqlServer(String User, String Pass) {
    try {
      Class.forName(this.DRIVER_NAME).newInstance();
      DriverManager.setLoginTimeout(60);
      this.con = DriverManager.getConnection(this.DATABASE_URL, User, Pass);
      this.stt = this.con.createStatement();
      this.con.setAutoCommit(false);
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      setMsjError(e.getMessage());
      return false;
    } catch (Exception ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } 
    return true;
  }
  
  public boolean initDBOracle(String User, String Pass) {
    try {
      Locale.setDefault(new Locale("es", "ES"));
      Class.forName(this.DRIVER_NAME).newInstance();
      DriverManager.setLoginTimeout(60);
      this.con = DriverManager.getConnection(this.DATABASE_URL, User, Pass);
      this.stt = this.con.createStatement();
      this.con.setAutoCommit(false);
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      setMsjError(e.getMessage());
      return false;
    } catch (Exception ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } 
    return true;
  }
  
  public boolean initExcel() {
    try {
      Class.forName(this.DRIVER_NAME).newInstance();
      DriverManager.setLoginTimeout(60);
      this.con = DriverManager.getConnection(this.DATABASE_URL);
      this.stt = this.con.createStatement();
      log.info("Ingresa a Excel");
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
      setMsjError(e.getMessage());
      return false;
    } catch (Exception ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
      return false;
    } 
    return true;
  }
  
  public boolean sqlCommit() {
    try {
      this.con.commit();
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      setMsjError(e.getMessage());
      return false;
    } 
  }
  
  public boolean sqlRollBack() {
    try {
      this.con.rollback();
      return true;
    } catch (SQLException e) {
      setMsjError(e.getMessage());
      return false;
    } 
  }
  
  public void setMsjError(String msj) {
    this.msjError = msj;
  }
  
  public String getMsjError() {
    return this.msjError;
  }
  
  public Connection getMiConeccion() {
    return this.con;
  }
  
  public void Close(Statement stm) {
    if (stm != null)
      try {
        stm.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }  
  }
  
  public boolean desconectar() {
    if (this.con != null)
      try {
        this.con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }  
    return true;
  }
  
  public CallableStatement ejecutaProcedure(String sql) {
    try {
      this.callp = this.con.prepareCall(sql);
    } catch (SQLException ex) {
      ex.printStackTrace();
      this.callp = null;
    } 
    return this.callp;
  }
  
  public Date getConverFecha(String fe) {
    Date f = null;
    try {
      this.callp = this.con.prepareCall("{? = call testdta.jde2date(?)}");
      this.callp.registerOutParameter(1, 91);
      this.callp.setInt(2, Integer.parseInt(fe));
      this.callp.execute();
      f = this.callp.getDate(1);
    } catch (SQLException sQLException) {}
    return f;
  }
  
  public ResultSet sqlResultSet(String query) {
    try {
      ResultSet rs = this.stt.executeQuery(query);
      return rs;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e, "Error al intentar ejecutar la Sentencia " + e.getMessage(), 0);
      return null;
    } 
  }
  
  public String[][] sqlString(String consulta) {
    String[][] res = (String[][])null;
    ResultSet rst = null;
    Vector<String> vec = null;
    Vector<Vector<String>> tuplas = null;
    try {
      rst = this.stt.executeQuery(consulta);
      int col = rst.getMetaData().getColumnCount();
      tuplas = new Vector();
      while (rst.next()) {
        vec = new Vector();
        for (int j = 1; j <= col; j++)
          vec.add(rst.getString(j)); 
        tuplas.add(vec);
      } 
      if (tuplas == null || vec == null)
        return (String[][])null; 
      res = new String[tuplas.size()][vec.size()];
      for (int i = 0; i < tuplas.size(); i++) {
        Vector<String> aux = tuplas.elementAt(i);
        for (int j = 0; j < aux.size(); j++)
          res[i][j] = aux.elementAt(j); 
      } 
    } catch (Exception c) {
      c.printStackTrace();
    } 
    return res;
  }
  
  public String[][] sqlProcedure(ResultSet rs) {
    String[][] res = (String[][])null;
    ResultSet rst = null;
    Vector<String> vec = null;
    Vector<Vector<String>> tuplas = null;
    try {
      rst = rs;
      int col = rst.getMetaData().getColumnCount();
      tuplas = new Vector();
      while (rst.next()) {
        vec = new Vector();
        for (int j = 1; j <= col; j++)
          vec.add(rst.getString(j)); 
        tuplas.add(vec);
      } 
      if (tuplas == null || vec == null)
        return (String[][])null; 
      res = new String[tuplas.size()][vec.size()];
      for (int i = 0; i < tuplas.size(); i++) {
        Vector<String> aux = tuplas.elementAt(i);
        for (int j = 0; j < aux.size(); j++)
          res[i][j] = aux.elementAt(j); 
      } 
    } catch (Exception c) {
      c.printStackTrace();
    } 
    return res;
  }
  
  public boolean sqlInsert(String consulta) {
    try {
      if (this.stt.executeUpdate(consulta) > 0)
        return true; 
    } catch (SQLException ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
    } 
    return false;
  }
  
  public boolean sqlUpdate(String consulta) {
    try {
      if (this.stt.executeUpdate(consulta) > 0)
        return true; 
    } catch (SQLException ex) {
      ex.printStackTrace();
      setMsjError(ex.getMessage());
    } 
    return false;
  }
  
  public boolean sqlVOID(String consulta) {
    try {
      this.stt.execute(consulta);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    } 
  }
  
  public boolean sqlExisteDato(String sql) {
    String[][] d = sqlString(sql);
    try {
      if (d.length > 0)
        return true; 
    } catch (NullPointerException e) {
      return false;
    } 
    return false;
  }
  
  public String tipoDato(String d) {
    Double a = null;
    try {
      a = Double.valueOf(d);
    } catch (Exception ex) {
      if (d.length() < 1) {
        d = "default";
      } else {
        d = "'" + d + "'";
      } 
    } 
    return d;
  }
  
  public int getConverJuliano(String fe) {
    int f = 0;
    try {
      this.callp.setString(2, fe);
      this.callp.execute();
      f = this.callp.getInt(1);
    } catch (SQLException sQLException) {}
    return f;
  }
  
  public void getPrepaConverJuliano() {
    try {
      this.callp = this.con.prepareCall("{? = call date2jde(?)}");
      this.callp.registerOutParameter(1, 6);
    } catch (SQLException sQLException) {}
  }
}
