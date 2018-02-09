package com.hotel.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterForm {
	@Length(min = 3, message = "*First name must be at least 3 characters long")
	@NotEmpty(message = "*Please provide your first name")
	private String firstname;

	@Length(min = 3, message = "*Last name must be at least 3 characters long")
	@NotEmpty(message = "*Please provide your last name")
	private String lastname;
	
	private String address;

	@Length(message = "*It must be at least 10 digits long", min = 10)
	@NotEmpty(message = "*Please provide your phone number")
	private String phone;

	@Length(min = 6, message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String username;

	@Length(min = 7, message = "*Your password must be between 7 and 14 characters long!")
	@NotEmpty(message = "*Please provide your password")
	private String password;

	/**
	 * 
	 */
	public RegisterForm() {
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param phone
	 * @param username
	 * @param password
	 */
	public RegisterForm(String firstname, String lastname, String address, String phone, String username,
			String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegisterForm [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", phone="
				+ phone + ", username=" + username + ", password=" + password + "]";
	}

}
