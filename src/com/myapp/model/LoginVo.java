/**
 * 
 */
/**
 * @author JIN
 *
 */
package com.myapp.model;

public class LoginVo {
	private String id; //Sequence
	private String lastName;
	private String firstName;
	private String nickName;
	private String password;
	private String email;
	private String createdTime;
	private String updatedTime;
	private String authentication;
	private String role;
	private String imagepath;

	@Override
	public String toString() {
		return "LoginVo [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", nickName=" + nickName
				+ ", password=" + password + ", email=" + email + ", createdTime=" + createdTime + ", updatedTime="
				+ updatedTime + ", authentication=" + authentication + ", role=" + role + ", imagepath=" + imagepath
				+ "]";
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getAuthentication() {
		return authentication;
	}
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}	
}