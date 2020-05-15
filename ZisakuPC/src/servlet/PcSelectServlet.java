package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ElcBean;
import bean.PcBean;
import dao.RankDAO;
import model.ElectricLogic;
import model.PcLogic;

/**
 * Servlet implementation class TopPageServlet
 */
@WebServlet("/PcSelectServlet")
public class PcSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String rank = request.getParameter("rank");
		RankDAO rankDAO = new RankDAO();
		String rankName = rankDAO.findByRank(rank);


		String errorMsg = "";

		PcLogic pcLogic = new PcLogic();
		List<PcBean> pcList = pcLogic.excute(rank);

		request.setAttribute("pcList", pcList);
		request.setAttribute("rankName", rankName);



		double sum = 0.0;
		double coe = 0.0;

		for (PcBean module: pcList) {
			String str =  module.getElectric();
			if(str == null||str.equals("")){
				str = "0.0" ;
			}
			double electlic = Double.parseDouble(str);
			sum += electlic;

		}
		switch(rank) {
			case  "LOW":
			case  "MID":
				coe = 1.2;
				break;
			case "HIGH":
				coe = 1.5 ;
				break;
		}
		sum *= coe;

		ElectricLogic electricLogic = new ElectricLogic();
		List<ElcBean> elcList = electricLogic.excute(sum);

		request.setAttribute("sum", sum);
		request.setAttribute("elcList", elcList);



		RequestDispatcher despatcher = request.getRequestDispatcher("/WEB-INF/jsp/ListSetResult.jsp");
		despatcher.forward(request, response);

	}
}
