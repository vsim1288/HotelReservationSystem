package com.hotel.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "roomtypes")
public class RoomTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoomTypesId", nullable = false)
	private Integer roomTypesId;

	@Column(name = "description")
	private String description;

	@Column(name = "NumberOfBeds")
	private Integer numberOfBeds;

	@Transient
	private List<Integer> rooms;

	/**
	 * @return the roomTypesId
	 */
	public Integer getRoomTypesId() {
		return roomTypesId;
	}

	/**
	 * @param roomTypesId
	 *            the roomTypesId to set
	 */
	public void setRoomTypesId(Integer roomTypesId) {
		this.roomTypesId = roomTypesId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the numberOfBeds
	 */
	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}

	/**
	 * @param numberOfBeds
	 *            the numberOfBeds to set
	 */
	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	/**
	 * @return the rooms
	 */
	public List<Integer> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms
	 *            the rooms to set
	 */
	public void setRooms(List<Integer> rooms) {
		this.rooms = rooms;
	}

}
