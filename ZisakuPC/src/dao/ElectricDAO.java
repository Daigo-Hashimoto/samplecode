package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Electric;

public class ElectricDAO{
	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	/*public List<Pc> findAll() {
		List<Pc> pcList = new ArrayList<>();*/

	public List<Electric> findByCapacity(double cap) {
		List<Electric> elcList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT * FROM ELECTRIC WHERE CAPACITY <= ? ";

		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setDouble(1, cap );

		      ResultSet rs = pStmt.executeQuery();

		      while (rs.next()) {
		    	  String elcId = rs.getString("ELCID");
		    	  String elcModelNo = rs.getString("ELCMODELNO");
		    	  double capacity = rs.getDouble("CAPACITY");
		    	  String url = rs.getString("URL");
		    	  String date = rs.getString("DATE");
		    	  Electric elc =new Electric(elcId,elcModelNo,capacity,url,date);
		    	  elcList.add(elc);
		      }
		}catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
		return elcList;
	}
}

