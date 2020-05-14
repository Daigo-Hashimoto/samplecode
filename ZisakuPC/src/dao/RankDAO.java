package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RankDAO {
	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	/*public List<Pc> findAll() {
		List<Pc> pcList = new ArrayList<>();*/

	public String findByRank(String rank) {
		String rankName = "";

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "SELECT RANKNAME FROM RANK WHERE RANK = ? ";

		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setString(1, rank );

		      ResultSet rs = pStmt.executeQuery();

		      while (rs.next()) {
		    	   rankName = rs.getString("RANKNAME");

		      }
		}catch (SQLException e) {
			e.printStackTrace();
			return null ;
		}
		return rankName;
	}

}
