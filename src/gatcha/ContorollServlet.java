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
		//下準備
		request.setCharacterEncoding("UTF-8");
		ContorollDAO cd=new ContorollDAO();
		FindDAO fd=new FindDAO();
		//パラメータ取得
		String action=request.getParameter("action");
		//パラメータによる分岐その１
		if(action.equals("add")) {//キャラ追加
			//初期化
			String name=null;
			String star=null;
			String explain=null;
			int s=0;
			//パラメータ取得
			name=request.getParameter("name");
			star=request.getParameter("star");
			explain=request.getParameter("exprain");
			try{//int型へキャスト
				s=Integer.parseInt(star);
				//キャラをデータベースに追加
				int rows=cd.add(name, s,explain);
				if(rows!=0) {//エラー処理
					request.setAttribute("message", rows+"件追加いたしました");
					ArrayList<GatchaBeans> ad=fd.findAll();

					request.setAttribute("list", ad);
					RequestDispatcher rs=request.getRequestDispatcher("/application/login.jsp");
					rs.forward(request, response);
				}else {
					request.setAttribute("message", "ERRORです。");
					RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
					rd.forward(request, response);
				}
			}catch(NumberFormatException e) {
				request.setAttribute("message", "ERRORです。");
				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
			}
		//分岐その２
		}else if(action.equals("update")) {//キャラ追加用
			//各種パラメータ取得
			String ID=request.getParameter("id");
			String name=request.getParameter("name");
			String star=request.getParameter("star");
			String explain=request.getParameter("exprain");
			//ローカル変数により初期化
			int s=0;
			int id=0;
			try{
				//変換
				s=Integer.parseInt(star);
				id=Integer.parseInt(ID);

				int rows=cd.update(name, s,explain,id);
				if(rows!=0) {//エラー処理
					ArrayList<GatchaBeans> ad=fd.findAll();

					request.setAttribute("list", ad);
					request.setAttribute("message", rows+"件更新しました");
					RequestDispatcher rs=request.getRequestDispatcher("/application/login.jsp");
					rs.forward(request, response);
				}else {
					request.setAttribute("message", "ERRORです。");
					RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
					rd.forward(request, response);
				}
			}catch(NumberFormatException e) {//エラー処理その2
				request.setAttribute("message", "ERRORです。");
				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
			}
		//分岐その3
		}else if(action.equals("delete")){//キャラ削除用
			String id=request.getParameter("id");
			int s=0;
			try{
				s=Integer.parseInt(id);

				int rows=cd.delete(s);
				if(rows!=0) {//エラー処理
					request.setAttribute("message", rows+"件削除いたしました");
					ArrayList<GatchaBeans> ad=fd.findAll();

					request.setAttribute("list", ad);

					RequestDispatcher rs=request.getRequestDispatcher("/application/login.jsp");
					rs.forward(request,response);
				}else {
					request.setAttribute("message", "ERRORです。");
					RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
					rd.forward(request, response);
				}
			}catch(NumberFormatException e) {//エラー処理その2
				request.setAttribute("message", "ERRORです。");
				RequestDispatcher rd=request.getRequestDispatcher("/application/login.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
