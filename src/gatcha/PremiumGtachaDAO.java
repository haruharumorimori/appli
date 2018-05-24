package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PremiumGtachaDAO {
	public ArrayList<PremiumGatchaBeans> pgatcha(int x) throws DAOException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			//準備
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/application?serverTimezone=UTC";
			String user="root";
			String pass="sht30";
			con= DriverManager.getConnection(url,user,pass);
			//アレイリストに入れる範囲を指定4
			String sql1="SELECT * from cha WHERE star=?";
			st=con.prepareStatement(sql1);
			st.setInt(1, x);
			rs=st.executeQuery();
			//アレイリストに格納
			ArrayList<PremiumGatchaBeans> al=new ArrayList<PremiumGatchaBeans>();
			//アレイリストから検出されなくなるまで繰り返し
			while(rs.next()) {
				String NAME=rs.getString("name");
				int STAR=rs.getInt("star");
				String EXPLAIN=rs.getString("exprain");
				//Beanにれてアレイリストへ格納
				PremiumGatchaBeans gb=new PremiumGatchaBeans(NAME,STAR,EXPLAIN);
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
