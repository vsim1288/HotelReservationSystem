package entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "Username")
	private String username;
	@Column(name = "Password")
	private String password;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roleId")
	private Role role;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="Username")
	private UserInformation userInfo;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "username", cascade = CascadeType.ALL)
	private List<Booking> bookingRecords = new LinkedList<Booking>();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * @return the userInfo
	 */
	public UserInformation getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInformation userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the bookingRecords
	 */
	public List<Booking> getBookingRecords() {
		return bookingRecords;
	}

	/**
	 * @param bookingRecords the bookingRecords to set
	 */
	public void setBookingRecords(List<Booking> bookingRecords) {
		this.bookingRecords = bookingRecords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", userInfo=" + userInfo
				+ ", bookingRecords=" + bookingRecords + "]";
	}
	
	
}
