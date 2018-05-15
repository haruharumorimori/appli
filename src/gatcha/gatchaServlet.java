package gatcha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gatchaServlet")
public class gatchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random r= new Random();
		int a=r.nextInt(10);
		GatchaDAO gd=new GatchaDAO();

		try {
			ArrayList<GatchaBeans> al=gd.gatcha( );
			System.out.println(a);
			al.get(a);
			String NAME=al.get(a).getName();
			int STAR=al.get(a).getStar();
			request.setAttribute("name1", NAME);
			request.setAttribute("STAR1", STAR);
			RequestDispatcher rd=request.getRequestDispatcher("/application/result.jsp");
			rd.forward(request, response);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
