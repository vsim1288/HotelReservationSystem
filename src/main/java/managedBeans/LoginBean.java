package managedBeans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import entities.User;

@ManagedBean(name = "loginBean")
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

	public String login() throws JsonParseException, JsonMappingException, IOException {
		String path = "http://localhost:8080/rest/user/get/" + username + "/" + password;
		Client client = Client.create();
		WebResource webResource = client.resource(path.toString());
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		System.out.println("login");
		if (response.getStatus() == 200) {
			try {
				JSONObject myObject = response.getEntity(JSONObject.class);
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
				User returnedUser = mapper.readValue(myObject.toString(), User.class);
				System.out.println(" Name:" + returnedUser.getUsername() + " Password: " + returnedUser.getPassword()
						+ " Role: " + returnedUser.getRole().getRoleName());

				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(false);

				session.setAttribute("username", username);

				return "ok";
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect Username or Password",
						"Please enter correct username and Password"));

				return null;
			}
		} else {
			FacesContext.getCurrentInstance().addMessage("loginForm:loginMsg",
					new FacesMessage("Incorrect Username or Password", "Please enter correct username and Password"));
			return null;
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "login";
	}
}
