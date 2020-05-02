import java.util.List;

import dao.PcDAO;
import model.Pc;

public class SelectPcSample {
	public static void main(String[] args) {
		PcDAO pcDAO = new PcDAO();
		List<Pc> pcList = pcDAO.findAll();

		for(Pc pc : pcList) {
			System.out.println("名称:" + pc.getPcClass());
			System.out.println("URL:" + pc.getUrl());
		}
	}


}
