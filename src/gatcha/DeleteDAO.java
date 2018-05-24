package gatcha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
 public int delete(String name,String pass)  {
	 Connection con=null;
	 PreparedStatement st=null;
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 String url="jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
		 String user ="root";
		 String key="sht30";
		 con=DriverManager.getConnection(url,user,key);
		 String sql="DELETE FROM user2 WHERE name=? AND pass=?";
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
	}
  }
}
