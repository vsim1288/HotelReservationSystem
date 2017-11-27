package entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roomtypes")
public class RoomTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoomTypesId", insertable = false, updatable = false)
	private int roomTypesId;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="NumberOfBeds")
	private int numberOfBeds;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roomTypes")
	private List<Rooms> roomsList = new LinkedList<>();

	/**
	 * @return the roomTypesId
	 */
	public int getRoomTypesId() {
		return roomTypesId;
	}

	/**
	 * @param roomTypesId the roomTypesId to set
	 */
	public void setRoomTypesId(int roomTypesId) {
		this.roomTypesId = roomTypesId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the numberOfBeds
	 */
	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	/**
	 * @param numberOfBeds the numberOfBeds to set
	 */
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	/**
	 * @return the roomsList
	 */
	public List<Rooms> getRoomsList() {
		return roomsList;
	}

	/**
	 * @param roomsList the roomsList to set
	 */
	public void setRoomsList(List<Rooms> roomsList) {
		this.roomsList = roomsList;
	}
	
	
}
