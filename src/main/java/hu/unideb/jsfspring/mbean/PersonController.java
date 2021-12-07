package hu.unideb.jsfspring.mbean;

import hu.unideb.jsfspring.service.FoodService;
import hu.unideb.jsfspring.service.PersonService;
import hu.unideb.jsfspring.uito.FoodUITO;
import hu.unideb.jsfspring.uito.PersonUITO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller("personController")
@SessionScope
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private FoodService foodService;

    private List<PersonUITO> personUITOList;
    private List<FoodUITO> foodUITOList;

    @PostConstruct
    public void getAllPerson() {
        if (!this.getPersonUITOList().isEmpty()) {
            this.getPersonUITOList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + personService);
        this.getPersonUITOList().addAll(personService.getAllPerson());
    }

    public List<PersonUITO> getPersonUITOList() {
        if (personUITOList == null) {
            personUITOList = new ArrayList<>();
        }
        return personUITOList;
    }

    public void setPersonUITOList(List<PersonUITO> personUITOList) {
        this.personUITOList = personUITOList;
    }
}
