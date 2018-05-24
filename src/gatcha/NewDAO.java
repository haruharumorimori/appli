package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewDAO {
	public int add(String name,String pass) {
		Connection con=null;
		PreparedStatement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/sample2?serverTimezone=UTC";
			String user="root";
			String key="sht30";
			con=DriverManager.getConnection(url,user,key);
			String sql="INSERT into user2 (name,pass,STONE) VALUES (?,?,200)";
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pass);
			int rows=st.executeUpdate();
			return rows;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}finally{
			try {
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
