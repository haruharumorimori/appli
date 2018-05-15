package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MasterDAO {
	PreparedStatement st=null;
	ResultSet rs=null;
	Connection con;
	public ArrayList<MasterBean> findALL(String name,String pass){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/sample2?serverTimezone=UTC";
			String user="student";
			String pa="himitu";
			con=DriverManager.getConnection(url,user,pa);
			String sql="SELECT * FROM user WHERE name=? AND pass=?";
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pass);

			rs=st.executeQuery();
			ArrayList<MasterBean> al=new ArrayList<MasterBean>();
			while(rs.next()) {
				String NAME=rs.getString("name");
				String PASS=rs.getString("pass");

				MasterBean mb=new MasterBean(NAME,PASS);
				al.add(mb);
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
			if(rs!=null||st!=null||con!=null) {
				try {
					rs.close();
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}

	}
}
