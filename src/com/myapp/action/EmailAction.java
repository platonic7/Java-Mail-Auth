package com.myapp.action;

import java.net.URL;
import java.util.UUID;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.myapp.dao.LoginDao;
import com.myapp.model.LoginVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmailAction extends ActionSupport implements ModelDriven<Object>, Preparable {
	private static final long serialVersionUID = 1864307099461602776L;
	private LoginVo vo;
	private LoginDao dao;
	
	public EmailAction() throws Exception {
		dao = LoginDao.getInstance();
	}
	
	// 仮登録登録Action
	public String execute() throws Exception {
		// ユニティキー生成 -> 文字列の整理 -> 8数字まで出力
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		
		// 仮登録時にユニークキーセッティング
		vo.setAuthentication(uuid);  
		
		// 仮登録
		dao.insert(vo);
		// 登録された、会員のユニットキーを変数に入れる
		String auth = vo.getAuthentication(); 

		// ユニットキーで、会員シーケンス番号を取得する
		vo = dao.selectAuthId(auth); 
		
		 //メール送信, Send Mail
		try {
			HtmlEmail email = new HtmlEmail(); // Html Mail Object 
//			email.setHostName(); // SMTP Host設定
			email.setSmtpPort(587); // Port番号
			email.setCharset("UTF-8");
//			email.setAuthentication(); // SMTP　Authentication
			email.addTo(vo.getEmail(), "");
//			email.setFrom(); 
			email.setSubject("会員登録確認メールです"); // Title
			
			//　イメージを参考する時。
			URL url = new URL("http://www.interline.co.jp/wp/wp-content/themes/interline/images/img_toplogo.jpg");
			String cid = email.embed(url, "Apache logo");
			email.setHtmlMsg("<html><img src=\"cid:" + cid + "\"><br><h3>  認証メール</h3><br><br>"
					+ "<a href=http://localhost:8080/InterlineLoginMail3/UpdateCheck.action?authentication=" 
					+  vo.getAuthentication() + " target='_blank'>認証完了リンク </a></html>");	
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		vo = new LoginVo();
	}
	@Override
	public Object getModel() {
		return vo;
	}
}
