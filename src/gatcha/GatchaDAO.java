package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GatchaDAO {
	PreparedStatement st;
	ResultSet rs;
	Connection con;

	public ArrayList<GatchaBeans> gatcha() throws DAOException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/application?serverTimezone=UTC";
			String user="root";
			String pass="sht30";
			con= DriverManager.getConnection(url,user,pass);
			String sql="SELECT * from cha";

			st=con.prepareStatement(sql);
			rs=st.executeQuery();

			ArrayList<GatchaBeans> al=new ArrayList<GatchaBeans>();
			while(rs.next()) {
				String NAME=rs.getString("name");
				int STAR=rs.getInt("star");

				GatchaBeans gb=new GatchaBeans(NAME,STAR);
				al.add(gb);
			}
			return al;

		} catch (SQLException e) {
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
			if(con !=null)
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	public ArrayList<GatchaBeans> pgatcha() throws DAOException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url="jdbc:mysql://localhost/application?serverTimezone=UTC";
			String user="root";
			String pass="sht30";
			con= DriverManager.getConnection(url,user,pass);
			String sql="SELECT * from cha WHERE star=>3";
			st=con.prepareStatement(sql);
			rs=st.executeQuery();

			ArrayList<GatchaBeans> al=new ArrayList<GatchaBeans>();
			while(rs.next()) {
				String NAME=rs.getString("name");
				int STAR=rs.getInt("star");

				GatchaBeans gb=new GatchaBeans(NAME,STAR);
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
				if(con !=null)
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
			}
		}
	}
}
