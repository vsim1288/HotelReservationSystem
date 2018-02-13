package com.hotel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "Username")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String username;

	@Column(name = "Password")
	@Length(min = 7, message = "*Your password must be between 7 and 14 characters long!")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	@Column(name = "Enabled")
	private byte enabled;

	@ManyToOne
	@JoinColumn(name = "RoleId")
	private Roles roleId;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	@Transient
	private UserInformation userInfo;

	@Transient
	private List<Booking> bookingList;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the enabled
	 */
	public byte getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the roleId
	 */
	public Roles getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Roles roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the userInfo
	 */
	public UserInformation getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            the userInfo to set
	 */
	public void setUserInfo(UserInformation userInfo) {
		this.userInfo = userInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", enabled=" + enabled + ", roleId=" + roleId
				+ ", userInfo=" + userInfo + ", bookingList=" + bookingList + "]";
	}
	
	

}
