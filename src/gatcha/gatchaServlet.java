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


@WebServlet("/gatchaServlet")
public class gatchaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//下準備
		Random r= new Random();
		ArrayList<GatchaBeans> al=new ArrayList<GatchaBeans>();

		GatchaDAO gd=new GatchaDAO();
		//確率調整
		int w=r.nextInt(200);
		int x=0;
		if(0<=w&&w<=5) {
			x=5;
		}else if(6<=w&&w<=26) {
			x=4;
		}else if(27<=w&&w<=77) {
			x=3;
		}else if(78<=w&&w<=148) {
			x=2;
		}else if(148<=w&&w<=199){
			x=1;
		}else {
			x=0;
		}
		//ガチャスタート
		try {
			//リストに格納
			al=gd.gatcha(x);
			//乱数生成
			int a=r.nextInt(al.size());
			//リストから抽出
			al.get(a);
			//データ取得
			String NAME=al.get(a).getName();
			int STAR=al.get(a).getStar();
			String explain=al.get(a).getExplain();
			//スコープ格納
			request.setAttribute("name1", NAME);
			request.setAttribute("STAR1", STAR);
			request.setAttribute("EXPLAIN1",explain);
			//送信
			RequestDispatcher rd=request.getRequestDispatcher("/application/result.jsp");
			rd.forward(request, response);
			//セッション作成（記録用）
			HttpSession hs=request.getSession();
			//スコープに格納
			hs.setAttribute("name3", NAME);
			hs.setAttribute("STAR3", STAR);
			hs.setAttribute("EXPLAIN3", explain);
			//送信
			RequestDispatcher ra=request.getRequestDispatcher("/application/recorded.jsp");
			ra.forward(request, response);
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
