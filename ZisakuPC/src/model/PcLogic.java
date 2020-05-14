package model;

import java.util.ArrayList;
import java.util.List;

import bean.PcBean;
import dao.PcDAO;

public class PcLogic {
	public List<PcBean> excute(String rank) {
		List<PcBean> beanList = new ArrayList<>();
		PcDAO pcDAO = new PcDAO();
		List<Pc> cpuList = pcDAO.findByRank(rank,"CPU");
		List<Pc> motherList = pcDAO.findByRank(rank,"MOTHER");
		List<Pc> storageList = pcDAO.findByRank(rank,"STORAGE");
		List<Pc> gpuList = pcDAO.findByRank(rank,"GPU");

		List<Pc> pcList = new ArrayList<>();
		pcList.addAll(cpuList);
		pcList.addAll(motherList);
		pcList.addAll(storageList);
		pcList.addAll(gpuList);


		for (Pc module: pcList) {
			PcBean pcBean = new PcBean();
			pcBean.setPcClass(module.getPcClass());
			pcBean.setModelNo(module.getModelNo());
			pcBean.setElectric(module.getElectric());
			pcBean.setUrl(module.getUrl());
			beanList.add(pcBean);
		}
		return beanList ;
 	}
}

