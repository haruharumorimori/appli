package gatcha;

import java.io.IOException;

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
		NewDAO nd=new NewDAO();
		StoneDAO SD=new StoneDAO();
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		if(name.equals(null)||pass.equals(null)) {
			request.setAttribute("message", "登録できません");
			RequestDispatcher rd=request.getRequestDispatcher("/appli/application/premium.jsp");
			rd.forward(request, response);
		}else {
			int rows=nd.add(name, pass);
			HttpSession hs=request.getSession();
			SD.add(name);
			hs.setAttribute("name", name);
			request.setAttribute("message", "登録完了致しました");
			RequestDispatcher rd=request.getRequestDispatcher("/application/PremiumGatcha.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
