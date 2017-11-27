package managedBeans;

import java.io.Serializable;
import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

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
		System.out.println("checkin");
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
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (checkIn == null || checkOut == null || numberOfPeople.equals("") || numberOfRooms.equals("")) {
			context.addMessage(null, new FacesMessage("Error", "There are still empty fields left!"));
			return;
		}

		if (checkIn.after(checkOut)) {
			System.out.println("wrong dates");
			context.addMessage(null, new FacesMessage("Error", "Check-in day or Check-out day is wrong!"));
		}
		
		if(numberOfPeople.compareTo(numberOfRooms) < 0) {
			context.addMessage(null, new FacesMessage("Error", "Too few people for selected rooms!"));
		}
		
		String path = "http://localhost:8080/rest/user/insert/" + checkIn + "/" + checkOut + "/" + numberOfPeople + "/" + numberOfRooms;
		Client client = Client.create();
		WebResource webResource = client.resource(path.toString());
		ClientResponse response = webResource.accept("application/json").put(ClientResponse.class);
		
		if (response.getStatus() == 200) {
			try {
//				JSONObject myObject = response.getEntity(JSONObject.class);
//				ObjectMapper mapper = new ObjectMapper();
//				mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
//				Booking returnedBooking = mapper.readValue(myObject.toString(), Booking.class);

				context.addMessage(null, new FacesMessage("Booking successful", "See you on the booked day!"));
			} catch (Exception e) {
				context.addMessage(null, new FacesMessage("Error", "Something went wrong! Please try again later!"));
			}
		} 
		
		context.addMessage(null, new FacesMessage("Sorry", "There is no room left!"));
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
