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

	/*public List<Pc> findAll() {
		List<Pc> pcList = new ArrayList<>();*/

	public List<Pc> findByRank(String rank,String pcclass) {
		List<Pc> pcList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT DISTINCT PCID,PCCLASS,RANK,GENNO,MODELNO,URL,DATE,ELECTRIC FROM PC WHERE RANK = ? AND PCCLASS = ? ORDER BY GENNO DESC LIMIT 1";//OFFSET 0 ROWS FETCH NEXT 1 LOWS ONLY

		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setString(1, rank );
		      pStmt.setString(2, pcclass );

		      ResultSet rs = pStmt.executeQuery();

		      while (rs.next()) {
		    	  String pcId = rs.getString("PCID");
		    	  String pcClass = rs.getString("PCCLASS");
		    	  String pcrank = rs.getString("RANK");
		    	  String genNo = rs.getString("GENNO");
		    	  String modelNo = rs.getString("MODELNO");
		    	  String url = rs.getString("URL");
		    	  String electric = rs.getString("ELECTRIC");
		    	  String date = rs.getString("DATE");
		    	  Pc pc =new Pc(pcId,pcClass,pcrank,genNo,modelNo,url,electric,date);
		    	  pcList.add(pc);
		      }
		}catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
		return pcList;
	}
}

