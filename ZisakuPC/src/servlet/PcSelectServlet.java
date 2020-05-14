package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.PcBean;
import dao.RankDAO;
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

		RequestDispatcher despatcher = request.getRequestDispatcher("/WEB-INF/jsp/ListSetResult.jsp");
		despatcher.forward(request, response);

	}
}
