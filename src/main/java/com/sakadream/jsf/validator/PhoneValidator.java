package com.sakadream.jsf.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by Phan Ba Hai on 21/07/2017.
 */

@FacesValidator("com.sakadream.jsf.validator.PhoneValidator")
public class PhoneValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        System.out.println(o.toString().length());
        if(!o.toString().startsWith("0")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone validation failed: ", "Invalid Phone Number!"));
        } else if(o.toString().length() != 10 && o.toString().length() != 11) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Phone validation failed: ", "Phone number must be 10 or 11 numbers!"));
        }
    }
}
