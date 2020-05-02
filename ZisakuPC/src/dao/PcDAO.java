package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pc;

public class PcDAO{
	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Pc> findAll() {
		List<Pc> pcList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT * FROM PC WHERE RANK = ? ";
		      /*sql.setString(1, HIGH);
		      sql.setString(2, MID);
		      sql.setString(3, LOW);*/
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setString(1, HIGH);
		      pStmt.setString(2, MID);
		      pStmt.setString(3, LOW);

		      ResultSet rs = pStmt.executeQuery();

		      while (rs.next()) {
		    	  String pcId = rs.getString("PCID");
		    	  String pcClass = rs.getString("PCCLASS");
		    	  String rank = rs.getString("RANK");
		    	  String genNo = rs.getString("GENNO");
		    	  String modelNo = rs.getString("MODELNO");
		    	  String url = rs.getString("URL");
		    	  String date = rs.getString("DATE");
		    	  Pc pc =new Pc(pcId,pcClass,rank,genNo,modelNo,url,date);
		    	  pcList.add(pc);
		      }
		}catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
		return pcList;
	}
}

