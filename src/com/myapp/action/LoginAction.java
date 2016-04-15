/**
 * @author JIN
 *
 */
package com.myapp.action;

import java.util.UUID;

import com.myapp.dao.LoginDao;
import com.myapp.model.LoginVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements Preparable, ModelDriven<Object> {
	//Object serialization
	private static final long serialVersionUID = -6241973184315627790L;
	
	private LoginVo vo;
	private LoginDao dao;

	public LoginAction() throws Exception {
		dao = LoginDao.getInstance();
	}
	
	// 初期ログイン画面 / Login Page
	public String signUpPage() throws Exception {
		return SUCCESS;
	}
	
	// 会員登録画面 / Sign Up Page
	public String information() throws Exception {
		return SUCCESS;
	}

	// 仮登録登録Action / First Sign Up Action 
	public String SignUp() throws Exception {
		// Create Unity Key
		// 36자 유니트키 생성 -> - 문자열 정리 - > 8자리 숫자까지 출력
		// ユニティキー生成 -> 文字列の整理 -> 8数字まで出力
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		
		// Setting to Unity Key
		// 가등록시 유니크키 세팅
		// 仮登録時にユニークキーセッティング
		vo.setAuthentication(uuid);  
		
		// First Sign Up
		// 가등록
		// 仮登録
		dao.insert(vo);
		
		// 현재 등록한 회원의 유니트키 변수에 넣어주기
		// 登録された、会員のユニットキーを変数に入れる
//		String auth = vo.getAuthentication(); 
		
		// 유니트키로 회원 번호 가져오기
		// ユニットキーで、会員シーケンス番号を取得する
//		vo = dao.selectAuthId(auth); 
		
		
		/*
		 * メール送信のコードを作成予定
		 * 이 밑부터 Email 송신 코드 작성 예정
		 */

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