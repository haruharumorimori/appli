package gatcha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RecordServlet")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String NAME;
	String PASS;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String record=request.getParameter("record");
	RecordDAO rd=new RecordDAO();
	try {
		if(record.equals("login")) {
			//パラメータ取得
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			//データベースの情報をアレイリストに格納
			ArrayList<RecordBean> al=rd.findAll(name,pass);
			//アレイリスト内の名前、パスワードを取り出す
				NAME=al.get(0).getName();
				PASS=al.get(0).getPass();

				if(name.equals(NAME)&&pass.equals(PASS)) {//打ち込まれたものとデータべ＾スの情報を照合
					//セッション処理
					HttpSession hs=request.getSession();
					hs.setAttribute("name",name);
					RequestDispatcher rp=request.getRequestDispatcher("/application/recorded.jsp");
					rp.forward(request, response);
				}else {
					request.setAttribute("message", "ログイン失敗");
					RequestDispatcher rp=request.getRequestDispatcher("/application/record.jsp");
					rp.forward(request, response);
				}
		} else if(record.equals("Logout")) {
			//ログアウトの一連のやつ
			HttpSession hs=request.getSession(false);
			if(hs==null) {
				request.setAttribute("message", "ログアウトしました");
				RequestDispatcher rs=request.getRequestDispatcher("/application/record.jsp");
				rs.forward(request, response);
			}else if(hs!=null){
				hs.invalidate();
				request.setAttribute("message", "ログアウトしました");
				RequestDispatcher rs=request.getRequestDispatcher("/application/record.jsp");
				rs.forward(request, response);
			}
		}
	}catch(IndexOutOfBoundsException e) {
		request.setAttribute("message", "ログイン失敗");
		RequestDispatcher rp=request.getRequestDispatcher("/application/record.jsp");
		rp.forward(request, response);
	}
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
