package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validators.FirstNameValidator")
public class FirstNameValidator implements Validator {
	private static final String namePattern = "[A-Za-z]";
	
	private Pattern pattern;
	private Matcher matcher;
	
	public FirstNameValidator() {
		pattern = Pattern.compile(namePattern);
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		matcher = pattern.matcher(value.toString());
		if (!matcher.find()) {

			FacesMessage msg = new FacesMessage("Name validation failed.", "Invalid name format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	}

}
