package entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class BookingCompositeKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4103057799035321019L;
	@Column(name="RoomId")
	private Integer roomId;
	@Column(name="StartDate")
	@Temporal(value = TemporalType.DATE)
	private Date startDate;
	
	public BookingCompositeKey() {
	}
	
	public BookingCompositeKey(Integer roomId, Timestamp startDate) {
		this.roomId = roomId;
		this.startDate = startDate;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		
		if(!(o instanceof BookingCompositeKey)) {
			return false;
		}
		
		BookingCompositeKey bck = (BookingCompositeKey) o;
		
		return bck.roomId.equals(roomId) && bck.startDate.equals(startDate);
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 31 * result + roomId;
		result = 31 * result + startDate.hashCode();
		
		return result;
	}

	/**
	 * @return the roomId
	 */
	public Integer getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
}
