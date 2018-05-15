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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String log=request.getParameter("log");
		if(log.equals("login")) {
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String NAME=null;
			String PASS=null;
			MasterDAO md=new MasterDAO();
			ArrayList<MasterBean> al=md.findALL(name, pass);
			for(MasterBean a:al) {
				NAME=a.getName();
				PASS=a.getPass();
			}
			if(name.equals(NAME)&&pass.equals(PASS)) {
			HttpSession hs=request.getSession();
			hs.setAttribute("NAME", NAME);
			RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
			rd.forward(request, response);
			}else {
			request.setAttribute("message", "パスワードが違います");
			RequestDispatcher rd=request.getRequestDispatcher("/application/Master.jsp");
			rd.forward(request, response);
			}
		}else if(log.equals("logout")) {
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
