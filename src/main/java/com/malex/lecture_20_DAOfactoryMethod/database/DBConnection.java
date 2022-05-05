package com.malex.lecture_20_DAOfactoryMethod.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.extern.java.Log;

@Log
public class DBConnection {

  private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";

  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String SELECT_FROM_ACCOUNT = "SELECT * FROM account";
  private Connection conn = null;

  public DBConnection(String userName, String password) {
    try {
      Class.forName(JDBC_DRIVER).newInstance();
      conn = DriverManager.getConnection(URL, userName, password);
    } catch (Exception ex) {
      log.severe(ex.getMessage());
    }
  }

  public void findAllById(int id) {
    try (ResultSet resultSets = conn.createStatement().executeQuery(SELECT_FROM_ACCOUNT)) {
      while (resultSets.next()) {
        log.info(resultSets.getInt("id") + " ");
        log.info(resultSets.getString("login") + " ");
        log.info(resultSets.getString("password") + " ");
        log.info("");
      }
    } catch (SQLException ex) {
      log.severe(ex.getMessage());
    }
  }
}
