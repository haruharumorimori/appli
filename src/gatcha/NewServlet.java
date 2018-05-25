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


@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下準備
		NewDAO nd=new NewDAO();
		StoneDAO sd=new StoneDAO();
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		if(name.equals("")||pass.equals("")) {//エラー処理
			request.setAttribute("message", "登録できません");
			RequestDispatcher rd=request.getRequestDispatcher("/appli/application/premium.jsp");
			rd.forward(request, response);
		}else {
			RecordDAO rd=new RecordDAO();
			//データベースに登録
			int rows=nd.add(name, pass);
			//ArrayListへ格納
			ArrayList<RecordBean> al=rd.findAll(name, pass);
			//session作成
			HttpSession hs=request.getSession();
			//石データ取得
			int stone=al.get(0).getStone();
			//sessionスコープに格納
			hs.setAttribute("name", name);
			hs.setAttribute("pass", pass);
			hs.setAttribute("stone", stone);
			request.setAttribute("message", "登録完了致しました");
			//射出
			RequestDispatcher rr=request.getRequestDispatcher("/application/PremiumGatcha.jsp");
			rr.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
