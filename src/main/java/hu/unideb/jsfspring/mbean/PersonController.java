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
import java.util.Objects;

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
        if (!this.getFoodUITOList().isEmpty())
            this.getFoodUITOList().clear();
        System.out.println(" >>>>>>>>>>>>> " + personService);
        this.getPersonUITOList().addAll(personService.getAllPerson());
        this.getFoodUITOList().addAll(foodService.doFetchAllFood());
    }

    public List<FoodUITO> getFoodByPerson(Long id) {
        getAllPerson();
        List<FoodUITO> foodList = new ArrayList<>();
        for(FoodUITO f : foodUITOList)
            if (f.getPersonUITO().getPersonId().equals(id))
                foodList.add(f);
        return foodList;
    }

    public List<FoodUITO> getFoodUITOList() {
        if (foodUITOList == null) {
            foodUITOList = new ArrayList<>();
        }

        return foodUITOList;
    }

    public void setFoodUITOList(List<FoodUITO> foodUITOList) {
        this.foodUITOList = foodUITOList;
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
