/**
 * @author JIN
 *
 */
package com.myapp.dao;

import java.sql.SQLException;

import com.myapp.model.LoginVo;
import com.myapp.model.LoginVoTemp;
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
	
	// 仮登録
	public void insert(Object obj) throws SQLException {
		SqlMapLocator.getMapper().insert("SiginUpReady",(LoginVo) obj);
	}

	// ユニットキーで、会員シーケンス番号を取得する	
	public LoginVo selectAuthId(Object obj) throws SQLException {
		LoginVo vo = (LoginVo) SqlMapLocator.getMapper().queryForObject("GetId", obj);
		return vo;
	}

	public LoginVoTemp checkEmail(Object email) throws SQLException {
		LoginVoTemp emailOne = (LoginVoTemp) SqlMapLocator.getMapper().queryForObject("GetEmailOne", email);
		System.out.println("DAO selectAuthId email " + email);
		System.out.println("DAO selectAuthId emailOne " + emailOne);
		return emailOne;
	}

	public LoginVoTemp checkUserEmail(Object email) throws SQLException {
		LoginVoTemp emailOneUser = (LoginVoTemp) SqlMapLocator.getMapper().queryForObject("GetEmailOneUser", email);
		return emailOneUser;
	}	

	public LoginVo checkEmail2(Object email) throws SQLException {
		LoginVo emailOne2 = (LoginVo) SqlMapLocator.getMapper().queryForObject("GetEmailOne2", email);
		return emailOne2;
	}		

	public void firstLogin(Object obj) throws SQLException {
		SqlMapLocator.getMapper().insert("FirstLogin", (LoginVo) obj);
	}	
}
