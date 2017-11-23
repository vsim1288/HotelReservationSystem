package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class Photo {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PhotoId")
	private int photoId;
	
	@Column(name="PhotoName")
	private String photoName;

	/**
	 * @return the photoId
	 */
	public int getPhotoId() {
		return photoId;
	}

	/**
	 * @param photoId the photoId to set
	 */
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	/**
	 * @return the photoName
	 */
	public String getPhotoName() {
		return photoName;
	}

	/**
	 * @param photoName the photoName to set
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	@Override
	public String toString() {
		return photoName;
	}
}
