package gatcha;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionlistServlet
 */
@WebServlet("/QuestionlistServlet")
public class QuestionlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//確認済み問い合わせを表示するためだけのサーブレット
		QuestionDAO qd=new QuestionDAO();
		ArrayList<QuestionBeans> al=new ArrayList<QuestionBeans>();
		al=qd.select2();
		request.setAttribute("questionlist2", al);
		RequestDispatcher rd=request.getRequestDispatcher("/application/questionlist.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
