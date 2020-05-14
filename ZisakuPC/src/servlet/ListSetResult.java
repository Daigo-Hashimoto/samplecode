package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ElcBean;
import bean.PcBean;
import model.ElectricLogic;

/**
 * Servlet implementation class ListSetResult
 */
@WebServlet("/ListSetResult")
public class ListSetResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PcBean> pcList = (List<PcBean>)request.getAttribute("pcList");

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
		String rank = request.getParameter("rank");
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

	}

}
