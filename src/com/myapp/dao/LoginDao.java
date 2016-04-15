/**
 * @author JIN
 *
 */
package com.myapp.dao;

import java.sql.SQLException;

import com.myapp.model.LoginVo;
import com.myapp.util.SqlMapLocator;

public class LoginDao {
	private static LoginDao singleton;
	private LoginDao() {};
	public static LoginDao getInstance() {
		if (singleton == null) {
			singleton = new LoginDao();
		}
		return singleton;
	}
	
	// First Sign Up
	// 가등록
	// 仮登録
	public void insert(Object obj) throws SQLException {
		SqlMapLocator.getMapper().insert("SiginUpReady",(LoginVo) obj);
	}
	
	// 유니트키로 회원 번호 가져오기
	// ユニットキーで、会員シーケンス番号を取得する	
	public LoginVo selectAuthId(Object obj) throws SQLException {
		LoginVo vo = (LoginVo) SqlMapLocator.getMapper().queryForObject("GetId", obj);
		return vo;
	}
}
