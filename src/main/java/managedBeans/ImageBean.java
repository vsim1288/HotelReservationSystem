package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.Photo;
import service.PhotoService;

@ManagedBean(name="imagesView")
@ViewScoped
public class ImageBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7907300671134715356L;
	private List<Photo> images;
    
    @PostConstruct
    public void init() {
        
    }
 
    public List<Photo> getImages() {
    	PhotoService photoService = new PhotoService();
        images = photoService.getAll();
        
        for(Photo photo: images) {
        	System.out.println(photo);
        }
    	
        return images;
    }
}
