package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="imagesView")
@ViewScoped
public class ImageBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7907300671134715356L;
	private List<String> images;
    
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            images.add("hotel-" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
