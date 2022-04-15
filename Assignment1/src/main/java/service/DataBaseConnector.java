package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector
{
  static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
  static final String USER = "postgres";
  static final String PASSWORD = "1234";

  private static DataBaseConnector instance = new DataBaseConnector();

  public synchronized static DataBaseConnector getInstance()
  {
    return instance;
  }

  public synchronized Connection getConnection()
  {
    try
    {
      DriverManager.registerDriver(new org.postgresql.Driver());
      return DriverManager.getConnection(DB_URL,USER,PASSWORD);
    }
    catch (SQLException e)
    {
      throw new RuntimeException("DATABASE CONNECTION FAILED!");
    }
  }
}
