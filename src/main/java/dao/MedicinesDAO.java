package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Medicines;

public class MedicinesDAO {
	  // データベース接続に使用する情報
	  private final String JDBC_URL = "jdbc:mysql://localhost:3306/medicines_management";
	  private final String DB_USER = "root";
	  private final String DB_PASS = "adminadmin";
	  
	  public List<Medicines> findAll() {
		    List<Medicines> medicinesList = new ArrayList<Medicines>();
		    
		    // データベース接続
		    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		    	
		    	 // SELECT文の準備
		        String sql = "SELECT NAME, TYPE, TIMING FROM MEDICINES JOIN MEDICINES_TIMING ON MEDICINES.ID = MEDICINES_TIMING.MEDICINES_ID";
		        PreparedStatement pStmt = conn.prepareStatement(sql);

		        // SELECTを実行
		        ResultSet rs = pStmt.executeQuery();
		        
		        // SELECT文の結果をArrayListに格納
		        while (rs.next()) {
		          String name = rs.getString("NAME");
		          String type = rs.getString("TYPE");
		          String timing = rs.getString("TIMING");
		          Medicines medicines = new Medicines(name, type, timing);
		          medicinesList.add(medicines);
		        }
		      } catch (SQLException e) {
		        e.printStackTrace();
		        return null;
		      }
		      return medicinesList;
		    }
	  public boolean create(Medicines medicines) {
		  
		  // データベース接続
		    try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		    	
		    	   // INSERT文の準備(idは自動連番なので指定しなくてよい）
		        String sql = "INSERT ALL INTO MEDICINES(NAME, TYPE) VALUES(?, ?) INTO MEDICINES_TIMING(MEDICINES_ID, TIMING) VALUES(?, ?, ) SELECT * FROM dual;";
		        PreparedStatement pStmt = conn.prepareStatement(sql);
		        
		        // INSERT文中の「?」に使用する値を設定しSQLを完成
		        pStmt.setString(1, medicines.getName());
		        pStmt.setString(2, medicines.getType());
		        pStmt.setString(2, medicines.getMedicines_id());
		        pStmt.setString(2, medicines.getTiming());

		        // INSERT文を実行（resultには追加された行数が代入される）
		        int result = pStmt.executeUpdate();
		        if (result != 1) {
		          return false;
		        }
		      } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		      }
		      return true;
		    }
		  
		    
	  }


