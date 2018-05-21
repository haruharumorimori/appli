package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PremiumGtachaDAO {
	public ArrayList<PremiumGatchaBeans> pgatcha() throws DAOException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url="jdbc:mysql://localhost/application?serverTimezone=UTC";
			String user="root";
			String pass="sht30";
			con= DriverManager.getConnection(url,user,pass);
			String sql1="SELECT * from cha WHERE star >= 3";
			st=con.prepareStatement(sql1);
			rs=st.executeQuery();

			ArrayList<PremiumGatchaBeans> al=new ArrayList<PremiumGatchaBeans>();
			while(rs.next()) {
				String NAME=rs.getString("name");
				int STAR=rs.getInt("star");

				PremiumGatchaBeans gb=new PremiumGatchaBeans(NAME,STAR);
				al.add(gb);
			}
			return al;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
			}
		}
	}
}
