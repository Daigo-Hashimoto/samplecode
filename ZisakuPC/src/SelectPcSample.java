import java.util.ArrayList;
import java.util.List;

import bean.PcBean;
import dao.PcDAO;
import model.Pc;
import model.PcLogic;

public class SelectPcSample {
	public static void main(String[] args) {
		PcDAO pcDAO = new PcDAO();
		List<Pc> cpuList = pcDAO.findByRank(args[0],"CPU");
		List<Pc> motherList = pcDAO.findByRank(args[0],"MOTHER");
		List<Pc> storageList = pcDAO.findByRank(args[0],"STORAGE");
		List<Pc> gpuList = pcDAO.findByRank(args[0],"GPU");

		List<Pc> pcList = new ArrayList<>();
		pcList.addAll(cpuList);
		pcList.addAll(motherList);
		pcList.addAll(storageList);
		pcList.addAll(gpuList);

		for(Pc pc : pcList) {
			System.out.println("名称:" + pc.getPcClass());
			System.out.println("URL:" + pc.getUrl());
			System.out.println("ID:" + pc.getPcId());
			System.out.println("RANK:" + pc.getRank());
			System.out.println("GENNO.:" + pc.getGenNo());
			System.out.println("MODELNO:" + pc.getModelNo());
			System.out.println("ELECTRIC:" + pc.getElectric());
			System.out.println("DATE:" + pc.getDate());
			System.out.println("\n");
		}
		PcLogic pclogic = new PcLogic();
		pclogic.excute(args[0]);
		List<PcBean> pcBeanList = pclogic.excute(args[0]);

		System.out.println("\n" + "↓以下、PcBeanの内容");

		for (PcBean pcBean: pcBeanList) {
			System.out.println(pcBean.getPcClass() + ":" +  pcBean.getModelNo() + ":" +  pcBean.getElectric()+ ":" +  pcBean.getUrl());

		}
	}


}
