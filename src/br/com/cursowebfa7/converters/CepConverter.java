package br.com.cursowebfa7.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cursowebfa7.model.Cep;

@FacesConverter(value="cep.converter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext contex, UIComponent arg1, String str) {
		String cepArr[] = null;
		try {
			cepArr = str.split("-");
			new Long(cepArr[0]);
			new Long(cepArr[1]);
		
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
			FacesMessage message = 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,  "Converter Error",
									contex.getApplication().evaluateExpressionGet(contex, "#{msg['cep.invalido']}", String.class));
			throw new ConverterException(message);
		}
		
		return new Cep(cepArr[0], cepArr[1]);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Cep cep  = (Cep) obj;
		
		return cep.getRegiao()+ "-" + cep.getSufixo();
	}

}
