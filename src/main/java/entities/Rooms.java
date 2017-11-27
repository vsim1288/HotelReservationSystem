package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	@Id
	@Column(name="RoomId")
	private int roomId;
	
	@ManyToOne
	@JoinColumn(name="RoomTypesId", nullable=false)
	private RoomTypes roomTypes;
	
	@Column(name="Occupied")
	private boolean occupied;

	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the roomType
	 */
	public RoomTypes getRoomType() {
		return roomTypes;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(RoomTypes roomTypes) {
		this.roomTypes = roomTypes;
	}

	/**
	 * @return the occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * @param occupied the occupied to set
	 */
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	
}
