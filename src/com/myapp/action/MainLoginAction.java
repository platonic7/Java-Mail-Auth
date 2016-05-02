package com.myapp.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myapp.dao.LoginDao;
import com.myapp.model.LoginVo;
import com.myapp.model.LoginVoTemp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class MainLoginAction extends ActionSupport implements Preparable, ModelDriven<Object>, SessionAware {
	private static final long serialVersionUID = 6031288019760994499L;
	private LoginVo vo;
	private LoginVoTemp voTemp;
	private LoginDao dao;
	private SessionMap<String, Object> sessionMap;

	public MainLoginAction() throws Exception {
		dao = LoginDao.getInstance();
	}

	// Main Login Action
	public String execute() throws Exception {
		voTemp = dao.checkUserEmail(vo.getEmail());
		if (voTemp == null) {
			addActionError("存在しないIDです。");
			return INPUT;
		} else {
			if (voTemp.getPassword().equals(vo.getPassword())) {
				if (vo.getEmail().equals(voTemp.getEmail()) && voTemp.getRole().equals("ROLE_USER") || voTemp.getRole().equals("ROLE_USER")) {
					voTemp = dao.checkUserEmail(vo.getEmail());
					sessionMap.put("email", voTemp.getEmail());
					sessionMap.put("firstName", voTemp.getFirstName());
					sessionMap.put("role", voTemp.getRole());
					return SUCCESS;
				} else {
					return ERROR;
				}
			} else {
				return INPUT;
			}	
		}
	}
	
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map; 
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
