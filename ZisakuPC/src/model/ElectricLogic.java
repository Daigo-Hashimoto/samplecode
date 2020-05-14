package model;

import java.util.ArrayList;
import java.util.List;

import bean.ElcBean;
import dao.ElectricDAO;

public class ElectricLogic {
	public List<ElcBean> excute(double cap) {
		List<ElcBean> beanList = new ArrayList<>();
		ElectricDAO elcDAO = new ElectricDAO();
		List<Electric> elcList = elcDAO.findByCapacity(cap);


		for (Electric elc: elcList) {
			ElcBean elcBean = new ElcBean();
			elcBean.setElcModelNo(elc.getElcModelNo());
			elcBean.setCapacity(elc.getCapacity());
			elcBean.setUrl(elc.getUrl());
			beanList.add(elcBean);
		}
		return beanList ;
 	}
}

