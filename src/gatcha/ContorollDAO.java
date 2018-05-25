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

	public int add(String name,int star,String explain) {
		//SQL接続
		connect();
		//SQL命令
		String sql="INSERT INTO cha(name,star,exprain) values(?,?,?)";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, star);
			st.setString(3, explain);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}
	//キャラ追加用
	public int update(String name,int star,String explain,int id) {
		//SQL接続
		connect();
		//SQL命令
		String sql="UPDATE cha SET name=?,star=?,exprain=? WHERE id=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setInt(2, star);
			st.setString(3, explain);
			st.setInt(4, id);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}

	//キャラ削除用
	public int delete(int id) {
		connect();
		String sql="DELETE FROM cha WHERE id=?";
		try {
			st=con.prepareStatement(sql);
			st.setInt(1, id);

			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}
	//SQL接続メソッド
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

	public void close() {
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
