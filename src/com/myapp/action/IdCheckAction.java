package com.myapp.action;

import com.myapp.dao.LoginDao;
import com.myapp.model.LoginVo;
import com.myapp.model.LoginVoTemp;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class IdCheckAction extends ActionSupport implements Preparable,ModelDriven<Object> {
	private static final long serialVersionUID = -637169884870886869L;
	private LoginVo vo;
	private LoginVoTemp voTemp;
	private LoginDao dao;
	
	public IdCheckAction() throws Exception{
		dao = LoginDao.getInstance();
	}
	
	public String execute() throws Exception {
		voTemp = dao.checkUserEmail(vo.getEmail());
		if (voTemp != null) { 
			vo.setEmail(voTemp.getEmail());
			vo.setIdCheck(voTemp.isIdCheck()); 
		} else {
			vo.setIdCheck(false); 
		}
		return Action.SUCCESS;
	}	
	
	@Override
	public Object getModel() {
		return vo;
	}

	@Override
	public void prepare() throws Exception {
		vo = new LoginVo();
	}
}
