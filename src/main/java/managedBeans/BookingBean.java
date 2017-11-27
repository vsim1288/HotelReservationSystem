package managedBeans;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -981016187367342441L;
	private Date checkIn;
	private Date checkOut;
	private String numberOfPeople;
	private String numberOfRooms;
	private String status;
	
	@PostConstruct
	public void init() {
		status = "No error";
	}

	/**
	 * @return the checkIn
	 */
	public Date getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn
	 *            the checkIn to set
	 */
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut
	 *            the checkOut to set
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the numberOfPeople
	 */
	public String getNumberOfPeople() {
		return numberOfPeople;
	}

	/**
	 * @param numberOfPeople
	 *            the numberOfPeople to set
	 */
	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	/**
	 * @return the numberOfRooms
	 */
	public String getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * @param numberOfRooms
	 *            the numberOfRooms to set
	 */
	public void setNumberOfRooms(String numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public void book() {
		System.out.println(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BookingBean [checkIn=" + checkIn + ", checkOut=" + checkOut + ", numberOfPeople=" + numberOfPeople
				+ ", numberOfRooms=" + numberOfRooms + "]";
	}
}
