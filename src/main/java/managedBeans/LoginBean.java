package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.User;
import rest.UserService;

@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8615978761172511778L;
	
	public LoginBean() {
		
	}
	
	private String username;
	private String password;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		UserService us = new UserService();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		System.out.println("login");
		if(us.findByUser(user)) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
	
}
