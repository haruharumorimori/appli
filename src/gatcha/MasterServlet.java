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


@WebServlet("/MasterServlet")
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionDAO qd=new QuestionDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String log=request.getParameter("log");
		FindDAO fd=new FindDAO();

		if(log.equals("login")) {
			//パラメータ取得
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			//初期化
			String NAME=null;
			String PASS=null;
			MasterDAO md=new MasterDAO();
			//アレイリスト作成とともにデータベースの情報取得
			ArrayList<MasterBean> al=md.findALL(name, pass);
			for(MasterBean a:al) {
				//代入
				NAME=a.getName();
				PASS=a.getPass();
			}

			if(name.equals(NAME)&&pass.equals(PASS)) {
				//セッション処理
				HttpSession hs=request.getSession();
				hs.setAttribute("PASS", PASS);
				hs.setAttribute("NAME", NAME);
				ArrayList<GatchaBeans> ad=fd.findAll();
				request.setAttribute("list", ad);
				//お問い合わせ確認
				ArrayList<QuestionBeans> q=qd.select();
					request.setAttribute("questionlist",q);

				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
				//お問い合わせ処理
				for(QuestionBeans z:q) {
					String question=z.getQuestion();
					String user=z.getName();
					qd.add2(question, user);
					qd.delete(user);
				}
			}else {
				//パスワード、名前が違うとき
				request.setAttribute("message", "名前またはパスワードが違います");
				RequestDispatcher rd=request.getRequestDispatcher("/application/Master.jsp");
				rd.forward(request, response);
			}
		}else if(log.equals("logout")) {
			//ログアウト
			HttpSession hs=request.getSession(false);
			if(hs!=null) {
				hs.invalidate();
				request.setAttribute("message", "ログアウトしました");
				RequestDispatcher rd=request.getRequestDispatcher("/application/Master.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "ログアウトしました");
				RequestDispatcher rd=request.getRequestDispatcher("/application/Master.jsp");
				rd.forward(request, response);
			}
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
