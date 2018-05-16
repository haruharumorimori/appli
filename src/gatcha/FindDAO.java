package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FindDAO {
	PreparedStatement st=null;
	ResultSet rs=null;
	Connection con;
	public ArrayList<GatchaBeans> findAll()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/application?serverTimezone=UTC";
			String user="root";
			String pass="sht30";
			con=DriverManager.getConnection(url,user,pass);
			String sql="SELECT * FROM cha";
			ArrayList<GatchaBeans> al=new ArrayList<GatchaBeans>();
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			while(rs.next()) {
				int ID=rs.getInt("id");
				String NAME=rs.getString("name");
				int STAR=rs.getInt("star");

				GatchaBeans gb=new GatchaBeans(ID,NAME,STAR);
				al.add(gb);
			}
			return al;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(rs!=null)rs.close();
				if(st!=null)st.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
