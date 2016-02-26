package br.com.cursowebfa7.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.cursowebfa7.model.Cep;

@FacesValidator(value="cep.validator")
public class CepValidator  implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent arg1, Object obj)	throws ValidatorException {
		FacesMessage message = null;
		try {
			Cep cep = (Cep) obj;
			if(cep.getRegiao().length() != 5 || cep.getSufixo().length() != 3) {
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de validação", 
						context.getApplication().evaluateExpressionGet(context, "#{msg['cep.invalido']}", String.class));
				throw new ValidatorException(message);
			}
		} catch(Exception e) {
			throw new ValidatorException(message);
 
		}
			
	}

}
