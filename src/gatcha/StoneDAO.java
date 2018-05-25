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
	public ArrayList<RecordBean> find(String name){//石数表示用
		connect();
		//SQLに命令
		String sql="SELECT * from user2 WHERE name=?";
		try {
			//位置指定
			st=con.prepareStatement(sql);
			st.setString(1, name);
			//実行
			rs=st.executeQuery();
			//リスト生成
			ArrayList<RecordBean> al=new ArrayList<RecordBean>();
			while(rs.next()) {//データ取得
				String NAME=rs.getString("name");
				String PASS=rs.getString("pass");
				int STONE=rs.getInt("STONE");
				//Beansに入れて、リストに格納
				RecordBean rb=new RecordBean(NAME,PASS,STONE);
				al.add(rb);
			}
			return al;
		} catch (SQLException e) {//エラー処理
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
	public int add(String name) {//ログインボーナス
		connect();
		//ログインする度10個石が付与される
		String sql="UPDATE user2 SET stone=stone+10 WHERE name=?";
		try {
			st=con.prepareStatement(sql);
			//位置指定
			st.setString(1, name);
			//実行
			rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {//エラー処理
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

	public int decrease(String name) {//ガチャを引いた際に石が10個引かれるようにするためのmメソッド
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
	public void connect() {//SQL接続用メソッド
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
