package hu.unideb.jsfspring.utills;

import hu.unideb.jsfspring.service.PersonService;
import hu.unideb.jsfspring.uito.PersonUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class PersonConverter implements Converter {

    @Autowired
    private PersonService personService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        PersonUITO personUITO = new PersonUITO();
        personUITO.setPersonName(string);
        personUITO = personService.getPerson(personUITO);
        System.out.println(personUITO.toString());
        return personUITO;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {

        if (obj instanceof PersonUITO) {
            PersonUITO per = (PersonUITO) obj;
            return per.getPersonName();
        } else {
            StringBuilder sbError = new StringBuilder("The object of class ");
            sbError.append(obj.getClass().getName()).append(" is not of PersonUITO");
            throw new ClassCastException(sbError.toString());
        }
    }
}
