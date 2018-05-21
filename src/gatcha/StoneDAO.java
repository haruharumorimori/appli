package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoneDAO {
	Connection con;
	PreparedStatement st=null;
	ResultSet rs=null;
	int rows=0;
	public ArrayList<RecordBean> find(String name){
		connect();
		String sql="SELECT * from user2 WHERE name=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			rs=st.executeQuery();
			ArrayList<RecordBean> al=new ArrayList<RecordBean>();
			while(rs.next()) {
				String NAME=rs.getString("name");
				String PASS=rs.getString("pass");
				int STONE=rs.getInt("STONE");

				RecordBean rb=new RecordBean(NAME,PASS,STONE);
				al.add(rb);
			}
			return al;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}finally {
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
	public int add(String name) {
		connect();
		String sql="UPDATE user2 SET stone=stone+200 WHERE name=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
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
	public int decrease(String name) {
		connect();
		String sql="UPDATE user2 SET STONE=STONE-10 WHERE name=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
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
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/sample2?serverTimezone=UTC";
			String user="root";
			String pass="sht30";
			con=DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
