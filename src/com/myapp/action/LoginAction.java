/**
 * @author JIN
 *
 */
package com.myapp.action;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.myapp.dao.LoginDao;
import com.myapp.model.LoginVo;
import com.myapp.model.LoginVoTemp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements Preparable, ModelDriven<Object>, SessionAware {
	private static final long serialVersionUID = -6241973184315627790L;
	private LoginVo vo;
	private LoginVoTemp voTemp;
	private LoginDao dao;

	private SessionMap<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}	

	public LoginAction() throws Exception {
		dao = LoginDao.getInstance();
	}

	public String SignUpPage() throws Exception {
		return SUCCESS;
	}

	public String SignUpCheck() throws Exception {
		return SUCCESS;
	}

	public String Auth() throws Exception {
		String auth = vo.getAuthentication(); 
		System.out.println(auth);
		voTemp = dao.checkEmail(auth);
		if (voTemp == null) {
			addActionError("存在しないIDです。");
			return INPUT;
		} else {
			if (voTemp.getPassword().equals(vo.getPassword())) {
				if (vo.getEmail().equals(voTemp.getEmail()) && vo.getAuthentication().equals(voTemp.getAuthentication())) {
					vo.setFirstName(voTemp.getFirstName());
					vo.setLastName(voTemp.getLastName());
					vo.setNickName(voTemp.getNickName());
					dao.firstLogin(vo);
					vo = dao.checkEmail2(vo.getEmail());
					sessionMap.put("email", vo.getEmail());
					sessionMap.put("firstName", vo.getFirstName());
					sessionMap.put("role", vo.getRole());
					EmailSetUp();
					return SUCCESS;
				} else {
					return ERROR;
				}
			} else {
				addActionError("パスワードが一致しません。");
				return INPUT;
			}
		}
	}

	private void EmailSetUp() throws EmailException, MalformedURLException {
		HtmlEmail email = new HtmlEmail();
//		email.setHostName();
		email.setSmtpPort(587);
		email.setCharset("UTF-8");
//		email.setAuthentication();
		email.addTo(vo.getEmail(), "");
//		email.addBcc();
//		email.setFrom(); 
		email.setSubject("会員本登録通知");
		URL url = new URL("http://www.interline.co.jp/wp/wp-content/themes/interline/images/img_toplogo.jpg");
		String cid = email.embed(url, "Apache logo");
		email.setHtmlMsg("<html><img src=\"cid:" + cid + "\"><br><br>"
				+ voTemp.getLastName() +" "+ voTemp.getFirstName() + "様<br><br>"
				+ "会員登録ありがとう！<br><br>"
				+ "<p>ご登録内容</p>"
				+ "<ul>"
				+ "<li>お名前 : " + voTemp.getLastName() +" "+ voTemp.getFirstName() + "</li>"
				+ "<li>ニックネーム : " + voTemp.getNickName() + "</li>"
				+ "<li>メールアドレス : " + voTemp.getEmail() + "</li>"
				+ "</ul>"
				+ "<br><br>"
				+ "今後とも当サービスをよろしくお願いいたします。"
				+ "<br><br>"
				+  "</html>");	
		email.send();
	}
	
	public String LogoutAction() throws Exception {
		 if(sessionMap!=null){  
		        sessionMap.invalidate();  
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