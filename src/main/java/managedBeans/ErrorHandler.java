package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="error")
@RequestScoped
public class ErrorHandler {
	private String statusCode;
	private String message;
	private String reqURI;
	
	public String getStatusCode() {		
		statusCode = String.valueOf((Integer) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.status_code"));

		return statusCode;
	}

	public String getMessage() {				
		message = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.get("javax.servlet.error.message");
		
		return message;
	}
	
	public String getReqURI() {
		reqURI =  (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("javax.servlet.error.request_uri");
		
		return reqURI;
	}
}
