package gatcha;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFormServlet
 */
@WebServlet("/DeleteFormServlet")
public class DeleteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteDAO dd=new DeleteDAO();
		//文字化け防止
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {//パラメータ取得
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			if(name!=""&&pass!="") {
				String reason=request.getParameter("reason");
				int id=0;
				switch(reason) {
					case "a":
						id=1;
						break;
					case "b":
						id=2;
						break;
					case "c":
						id=3;
						break;
					case "d":
						id=4;
						break;
					}
				ReasonDAO rd= new ReasonDAO();
				int rows2=dd.delete(name, pass);
				if (rows2!=0) {
					int rows1=rd.add1(id);
					request.setAttribute("message", "退会致しました。ご利用ありがとうございました。");
					RequestDispatcher rr=request.getRequestDispatcher("/application/deleteresult.jsp");
					rr.forward(request, response);
				}else {
						request.setAttribute("message","Errorです");
						RequestDispatcher re=request.getRequestDispatcher("/application/delete.jsp");
						re.forward(request, response);
				}
			}else{
				request.setAttribute("message","Errorです");
				RequestDispatcher re=request.getRequestDispatcher("/application/delete.jsp");
				re.forward(request, response);
			}
		}catch(NullPointerException e) {
			request.setAttribute("message","Errorです");
			RequestDispatcher re=request.getRequestDispatcher("/application/delete.jsp");
			re.forward(request, response);
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
