package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDAO {
	//下準備
	Connection con=null;
	PreparedStatement st=null;
	ResultSet rs=null;
	public ArrayList<QuestionBeans> select(){//未確認用
		//接続メソッド
		connect();
		String sql="SELECT * FROM question";
		try {//SQLに命令
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			//リスト生成
			ArrayList<QuestionBeans> al=new ArrayList<QuestionBeans>();
			while(rs.next()) {//データ取得
				String QUESTION=rs.getString("question");
				String NAME=rs.getString("name");
				//Beansに入れてリストへ格納
				QuestionBeans qb=new QuestionBeans(QUESTION,NAME);
				al.add(qb);
			}
			return al;
		} catch (SQLException e) {//エラー処理
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<QuestionBeans> select2(){//確認済み用
		connect();
		String sql="SELECT * FROM question2";
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			ArrayList<QuestionBeans> al=new ArrayList<QuestionBeans>();
			while(rs.next()) {
				String QUESTION=rs.getString("question");
				String NAME=rs.getString("name");
				QuestionBeans qb=new QuestionBeans(QUESTION,NAME);
				al.add(qb);
			}
			return al;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
	public int add(String question,String name) {//未確認をデータベースに追加
		try {
			connect();
			String sql="INSERT question (question,name) values (?,?)";
			st=con.prepareStatement(sql);
			st.setString(1, question);
			st.setString(2, name);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}
	public int add2(String question,String name) {//確認済みをデータベースに追加
		connect();
		String sql ="INSERT question2 (question, name) values (?,?)";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, question);
			st.setString(2, name);
			int rows=st.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return 0;
		}
	}
	public int delete(String name) {//削除用
		connect();
		String sql="DELETE FROM question WHERE name=?";
		try {
			st=con.prepareStatement(sql);
			st.setString(1, name);
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
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
