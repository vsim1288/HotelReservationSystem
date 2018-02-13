package com.hotel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "rooms")
public class Rooms {

	@Id
	@Column(name = "room_id")
	private Integer roomId;

	@Column(name = "occupied")
	private Boolean occupied;

	@ManyToOne
	@JoinColumn(name = "roomtypes_id")
	private RoomTypes roomTypes;
	
	@Transient
	private List<Booking> bookingList;
	
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
