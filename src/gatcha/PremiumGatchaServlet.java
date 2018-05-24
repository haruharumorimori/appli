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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PremiumGatchaServlet
 */
@WebServlet("/PremiumGatchaServlet")
public class PremiumGatchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下準備
		response.setContentType("text/html;UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		RecordDAO rd=new RecordDAO();
		PremiumGtachaDAO pgd=new PremiumGtachaDAO();
		StoneDAO sd=new StoneDAO();
		HttpSession hs=request.getSession();
		//セッションに入っている名前、パスワードを取り出す
		String name=(String)hs.getAttribute("name");
		String pass=(String)hs.getAttribute("pass");

		//アレイリスト作成
		ArrayList<RecordBean> al=rd.findAll(name,pass);
		//アレイリスト内の石情報獲得
		int stone=al.get(0).getStone();
		//石の数による吟味
		if(stone<10) {
			request.setAttribute("message", "石が足りません");
			request.setAttribute("stone", stone);
			RequestDispatcher ra=request.getRequestDispatcher("/application/PremiumGatcha.jsp");
			ra.forward(request, response);
		}else if(stone>=10) {

		try {//ガチャスタート
			Random r=new Random();
			sd.decrease(name);
			int x=r.nextInt(100);
			int z=0;
			//★3未満をはじく
			if(0<=x&&x<=50) {
				z=3;
			}else if(51<=x&&x<=87) {
				z=4;
			}else if(88<=x&&x<=100) {
				z=5;
			}
			//アレイリストに入れたものを取り出す一連の流れ
			int STAR=0;
			String NAME=null;
			String EXPLAIN=null;
			ArrayList<PremiumGatchaBeans> az=pgd.pgatcha(z);
			int a=r.nextInt(az.size());
			NAME=az.get(a).getName();
			STAR=az.get(a).getStar();
			EXPLAIN=az.get(a).getExplain();

			//排出したものをJSPに飛ばす。
			request.setAttribute("premiumname1", NAME);
			request.setAttribute("premiumSTAR1", STAR);
			request.setAttribute("premiumEXPLAIN1", EXPLAIN);

			RequestDispatcher sa=request.getRequestDispatcher("/application/PremiumGatchaResult.jsp");
			sa.forward(request, response);
			hs.setAttribute("name3", NAME);
			hs.setAttribute("STAR3",STAR);
			hs.setAttribute("EXPLAIN3", EXPLAIN);
			RequestDispatcher rs=request.getRequestDispatcher("/application/recorded.jsp");
			rs.forward(request, response);
		} catch (DAOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
		}
	}
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
