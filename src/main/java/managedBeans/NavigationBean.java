package managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="navBean")
@SessionScoped
public class NavigationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4727223978310400084L;
	private String page;
	
	@PostConstruct
	public void init() {
		page = "home";
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}
}
