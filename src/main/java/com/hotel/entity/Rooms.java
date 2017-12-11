package com.hotel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Rooms {

	@Id
	@Column(name = "RoomId")
	private Integer roomId;

	@Column(name = "Occupied")
	private Boolean occupied;

	@ManyToOne
	@JoinColumn(name = "RoomTypesID")
	private RoomTypes roomTypes;
	
	public Rooms() {}

	public Rooms(Integer roomId, Boolean occupied, RoomTypes roomTypes) {
		this.roomId = roomId;
		this.occupied = occupied;
		this.roomTypes = roomTypes;
	}

	/**
	 * @return the roomId
	 */
	public Integer getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId
	 *            the roomId to set
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the occupied
	 */
	public Boolean getOccupied() {
		return occupied;
	}

	/**
	 * @param occupied
	 *            the occupied to set
	 */
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	/**
	 * @return the roomTypes
	 */
	public RoomTypes getRoomTypes() {
		return roomTypes;
	}

	/**
	 * @param roomTypes
	 *            the roomTypes to set
	 */
	public void setRoomTypes(RoomTypes roomTypes) {
		this.roomTypes = roomTypes;
	}

}
