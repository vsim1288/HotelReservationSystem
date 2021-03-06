package entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "booking")
public class Booking {
	@EmbeddedId
	private BookingCompositeKey roomIdStartDate;

	@Column(name = "EndDate", updatable = false)
	@Temporal(value = TemporalType.DATE)
	private Date endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private User username;

	/**
	 * @return the roomIdStartDate
	 */
	public BookingCompositeKey getRoomIdStartDate() {
		return roomIdStartDate;
	}

	/**
	 * @param roomIdStartDate
	 *            the roomIdStartDate to set
	 */
	public void setRoomIdStartDate(BookingCompositeKey roomIdStartDate) {
		this.roomIdStartDate = roomIdStartDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Booking [roomIdStartDate=" + roomIdStartDate + ", endDate=" + endDate + ", username=" + username + "]";
	}

//	/**
//	 * @return the username
//	 */
//	public User getUsername() {
//		return username;
//	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(User username) {
		this.username = username;
	}

}
