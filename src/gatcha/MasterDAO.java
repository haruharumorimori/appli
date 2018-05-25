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
		try {//SQL接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/sample2?serverTimezone=UTC";
			String user="student";
			String pa="himitu";
			con=DriverManager.getConnection(url,user,pa);
			//SQLに命令
			String sql="SELECT * FROM user WHERE name=? AND pass=?";
			st=con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, pass);

			rs=st.executeQuery();
			//リスト生成
			ArrayList<MasterBean> al=new ArrayList<MasterBean>();

			while(rs.next()) {//データべース情報をアレイリストに格納
				String NAME=rs.getString("name");
				String PASS=rs.getString("pass");
				//JAVABEANSインスタンス化
				MasterBean mb=new MasterBean(NAME,PASS);
				//アレイリストに追加
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
				try {//メモリ圧迫回避
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
