package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDAO {
	public ArrayList<RecordBean> findAll(String name,String pass){
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {//SQL接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/sample2?serverTimezone=UTC";
			String user="root";
			String pa="sht30";
			con=DriverManager.getConnection(url,user,pa);
			//SQLに命令
			String sql="SELECT * FROM user2 WHERE name=? AND pass=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			//リスト作成
			ArrayList<RecordBean> al=new ArrayList<RecordBean>();
			while(rs.next()) {//データ取得
				String NAME=rs.getString("name");
				String PASS=rs.getString("pass");
				int STONE=rs.getInt("STONE");
				RecordBean rb=new RecordBean(NAME,PASS,STONE);
				al.add(rb);
			}
			return al;
		} catch (ClassNotFoundException e) {//以下エラー処理
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}finally {
			if(rs!=null||ps!=null||con!=null)
				try {
					rs.close();
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}


	}
}
