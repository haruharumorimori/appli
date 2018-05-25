package gatcha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け阻止
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//パラメータ取得
		String question=request.getParameter("question");
		String name=request.getParameter("name");
		QuestionDAO qd=new QuestionDAO();
		//リストに追加
		int rows=qd.add(question, name);
		//表示メッセージ作成＆送信
		request.setAttribute("message", "お問い合わせ承りました。ご利用ありがとうございました。");
		RequestDispatcher rd=request.getRequestDispatcher("/application/questionresult.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
