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

/**
 * Servlet implementation class PremiumServlet
 */
@WebServlet("/PremiumServlet")
public class PremiumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//Hiddenパラメータ取得
		String record=request.getParameter("record");
		//下準備
		String NAME=null;
		String PASS=null;
		StoneDAO sd=new StoneDAO();
		RecordDAO rd=new RecordDAO();
		////分岐
		if(record.equals("login")) {
			//パラメータ取得とともにデータベースと照合
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			ArrayList<RecordBean> al=rd.findAll(name,pass);
			for(RecordBean r:al) {
				NAME=r.getName();
				PASS=r.getPass();
				}
			if(name.equals(NAME)&&pass.equals(PASS)) {
				//セッション処理
				HttpSession hs=request.getSession();
				sd.add(name);
				ArrayList<RecordBean> ar=sd.find(name);
				int stone=ar.get(0).getStone();
				request.setAttribute("stone", stone);
				hs.setAttribute("name",name);
				hs.setAttribute("pass", pass);
				RequestDispatcher rp=request.getRequestDispatcher("/application/PremiumGatcha.jsp");
				rp.forward(request, response);
			}else {//違うとき
				request.setAttribute("message", "ログイン失敗");
				RequestDispatcher rp=request.getRequestDispatcher("/application/premium.jsp");
				rp.forward(request, response);
			}
		}else if(record.equals("Logout")) {//ログアウト
			HttpSession hs=request.getSession(false);
			if(hs==null) {
				request.setAttribute("message", "ログアウトしました");
				RequestDispatcher rs=request.getRequestDispatcher("/application/premium.jsp");
				rs.forward(request, response);
			}else if(hs!=null) {
				hs.invalidate();
				request.setAttribute("message", "ログアウトしました");
				RequestDispatcher rs=request.getRequestDispatcher("/application/premium.jsp");
				rs.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
