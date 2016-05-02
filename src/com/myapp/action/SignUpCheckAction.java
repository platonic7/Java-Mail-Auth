package com.myapp.action;

import com.myapp.dao.LoginDao;
import com.myapp.model.LoginVo;
import com.myapp.model.LoginVoTemp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class SignUpCheckAction extends ActionSupport implements Preparable, ModelDriven<Object>{
	private static final long serialVersionUID = 608503429836593719L;
	private LoginVo vo;
	private LoginVoTemp voTemp;
	private LoginDao dao;
	
	public SignUpCheckAction() throws Exception {
		dao = LoginDao.getInstance();
	}

	public String execute() throws Exception {
		voTemp = dao.checkEmail(vo.getEmail()); 
		if (voTemp == null) {
			return SUCCESS;
		} else if (voTemp.getEmail() != null) { 
			addActionError("<font color=bule>登録された</font>メールアドレスです。もう一度ご確認お願いします。");
			return INPUT;
		}
		return SUCCESS; 
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
