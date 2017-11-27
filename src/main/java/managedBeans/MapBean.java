package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name="mapBean")
@ViewScoped
public class MapBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4837266299746887231L;
	private MapModel model = new DefaultMapModel();

	public MapBean() {
		model.addOverlay(new Marker(new LatLng(46.771210, 23.623635), "Tristar"));
	}

	public MapModel getModel() {
		return this.model;
	}
}
