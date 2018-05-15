package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContorollDAO {
	Connection con;
	PreparedStatement st=null;
	ResultSet rs=null;
	public void findAll(String name,int star)  {
		connect();
		String sql="SELECT * FROM cha";
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			ArrayList<GatchaBeans> al=new ArrayList<GatchaBeans> a();S
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public int add(String name,int star) {
		connect();
		String sql="INSERT INTO cha(name,star) values(?,?)";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, star);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}

	public int update(String name,int star,int id) {
		connect();
		String sql="UPDATE cha SET name=?,star=? WHERE id=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, star);
			st.setInt(3, id);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}

	public int delete(String name,int star) {
		connect();
		String sql="DELETE FROM cha WHERE name=? AND star=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, star);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/application?serverTimezone=UTC";
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
