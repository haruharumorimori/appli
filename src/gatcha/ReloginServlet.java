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
 * Servlet implementation class ReloginServlet
 */
@WebServlet("/ReloginServlet")
public class ReloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//確認済み問い合わせ画面から戻るときの表示用
		FindDAO fd=new FindDAO();
		ArrayList<GatchaBeans> ad=fd.findAll();
		request.setAttribute("list", ad);
		QuestionDAO qd=new QuestionDAO();
		ArrayList<QuestionBeans> q=qd.select();
		request.setAttribute("questionlist",q);
		RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
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
