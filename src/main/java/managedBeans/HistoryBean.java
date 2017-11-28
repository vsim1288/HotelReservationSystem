package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Booking;
import service.BookingService;

@ManagedBean(name="historyBean")
@ViewScoped
public class HistoryBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8872424083462552964L;
	private List<Booking> historyList;
	BookingService bookingService = new BookingService();
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	@PostConstruct
	public void init() {
		historyList = bookingService.getAll(loginBean.getUsername());
	}

	/**
	 * @return the historyList
	 */
	public List<Booking> getHistoryList() {
		return historyList;
	}

	/**
	 * @param historyList the historyList to set
	 */
	public void setHistoryList(List<Booking> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the loginBean
	 */
	public LoginBean getLoginBean() {
		return loginBean;
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	
}
