package gatcha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContorollServlet")
public class ContorollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContorollDAO cd=new ContorollDAO();
		String action=request.getParameter("action");
		if(action.equals("add")) {
			String name=request.getParameter("name");
			String star=request.getParameter("star");
			int s=Integer.parseInt(star);
			int rows=cd.add(name, s);
			request.setAttribute("message", rows+"件追加いたしました");
			RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
			rd.forward(request, response);
		}else if(action.equals("update")) {
			String ID=request.getParameter("id");
			String name=request.getParameter("name");
			String star=request.getParameter("star");
			int s=Integer.parseInt(star);
			int id=Integer.parseInt(ID);
			int rows=cd.update(name, s, id);
			request.setAttribute("message", rows+"件更新しました");
			RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
			rd.forward(request, response);
		}else if(action.equals("delete")){
			String name=request.getParameter("name");
			String star=request.getParameter("star");
			int s=Integer.parseInt(star);
			int rows=cd.delete(name, s);
			request.setAttribute("message", rows+"件削除いたしました");
			RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
			rd.forward(request,response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
