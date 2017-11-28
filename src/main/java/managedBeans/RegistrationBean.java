package managedBeans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Role;
import entities.User;
import entities.UserInformation;
import service.UserService;

@ManagedBean(name = "regBean")
@SessionScoped
public class RegistrationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7004635309385698873L;
	private String firstName;
	private String lastName;
	private String address;
	private int phone;
	private String email;
	private String password;

	public RegistrationBean() {
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	public void validate() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user = new User();
		Role role = new Role();
		UserInformation userInfo = new UserInformation();
		UserService userService = new UserService();

		role.setRoleName("user");
		role.setRoleId(1);

		userInfo.setAddress(address);
		userInfo.setEmail(email);
		userInfo.setFirstName(firstName);
		userInfo.setLastName(lastName);
		userInfo.setPhone(phone);

		user.setPassword(password);
		user.setUsername(email);

		user.setUserInfo(userInfo);
		user.setRole(role);
		System.out.println("register");
		if (userService.save(user)) {
			context.addMessage(null, new FacesMessage("Success", "Username created!"));
			return;
		}

		context.addMessage(null, new FacesMessage("Sorry", "Something went wrong! Please try again later"));
	}
}
