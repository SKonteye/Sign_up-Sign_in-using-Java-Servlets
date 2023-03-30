package com.groupeisi.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	
	private PreparedStatement pstm;
	private ResultSet rs;
	private int result;
	private Connection cnx;
	
	public void openConnection() {
		String userMysql = "root";
		String passwordMysql = "";
		String url = "jdbc:mysql://localhost:3306/company";
		try {
			//chargement du pilote
			Class.forName("com.mysql.jdbc.Driver") ;
			 cnx = DriverManager.getConnection(url, userMysql, passwordMysql);
			System.out.println("Connexion ok");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void initPrepar(String sql) {
		try {
			openConnection();
			pstm = cnx.prepareStatement(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	public ResultSet executeSelect () {
		try {
			rs =pstm.executeQuery();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
	public int executeMaj() {
		try {
			result = pstm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	public void closeConnection() {
		try {
			if (cnx !=null) {
				cnx.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public PreparedStatement getPstm() {
		return this.pstm;
	}
	
	
	
	
	
	
	
	/*public void closeConnection() {
		try {
			if (cnx != null) {
				cnx.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
