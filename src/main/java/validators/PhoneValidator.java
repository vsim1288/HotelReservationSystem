package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.PhoneValidator")
public class PhoneValidator implements Validator {
	public static final String PHONE_PATTERN = "[0-9]";

	private Pattern pattern;
	private Matcher matcher;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if(!matcher.find()){

			FacesMessage msg =
				new FacesMessage("Phone validation failed.",
						"Invalid phone format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}	
	}

}
