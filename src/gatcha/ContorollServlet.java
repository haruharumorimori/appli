package gatcha;

import java.io.IOException;
import java.util.ArrayList;

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
		request.setCharacterEncoding("UTF-8");
		ContorollDAO cd=new ContorollDAO();
		FindDAO fd=new FindDAO();

		String action=request.getParameter("action");
		if(action.equals("add")) {
			String name=request.getParameter("name");
			String star=request.getParameter("star");
			if(name.equals(null)||star.equals(null)) {
				request.setAttribute("message", "ERRORです。");
				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
			}
			int s=Integer.parseInt(star);
			int rows=cd.add(name, s);
			request.setAttribute("message", rows+"件追加いたしました");
			ArrayList<GatchaBeans> ad=fd.findAll();

			request.setAttribute("list", ad);
			RequestDispatcher rs=request.getRequestDispatcher("/application/login.jsp");
			rs.forward(request, response);

		}else if(action.equals("update")) {
			String ID=request.getParameter("id");
			String name=request.getParameter("name");
			String star=request.getParameter("star");
			if(ID.equals(null)||name.equals(null)||star.equals(null)) {
				request.setAttribute("message", "ERRORです。");
				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
			}
			int s=Integer.parseInt(star);
			int id=Integer.parseInt(ID);
			int rows=cd.update(name, s, id);
			ArrayList<GatchaBeans> ad=fd.findAll();

			request.setAttribute("list", ad);
			request.setAttribute("message", rows+"件更新しました");
			RequestDispatcher rs=request.getRequestDispatcher("/application/login.jsp");
			rs.forward(request, response);

		}else if(action.equals("delete")){
			String id=request.getParameter("id");
			if(id.equals(null)) {
				request.setAttribute("message", "ERRORです。");
				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
			}
			int s=Integer.parseInt(id);
			int rows=cd.delete(s);
			request.setAttribute("message", rows+"件削除いたしました");
			ArrayList<GatchaBeans> ad=fd.findAll();

			request.setAttribute("list", ad);

			RequestDispatcher rs=request.getRequestDispatcher("/application/login.jsp");
			rs.forward(request,response);
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
