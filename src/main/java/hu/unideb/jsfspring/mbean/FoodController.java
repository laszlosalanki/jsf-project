package hu.unideb.jsfspring.mbean;

import hu.unideb.jsfspring.service.FoodService;
import hu.unideb.jsfspring.service.PersonService;
import hu.unideb.jsfspring.uito.FoodUITO;
import hu.unideb.jsfspring.uito.PersonUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("foodController")
@SessionScope
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private PersonService personService;

    private String actionLabel;
    private FoodUITO foodUITO;
    private List<FoodUITO> foodUITOList;

    private List<PersonUITO> personUITOList;


    public void doSaveInfoFood() {
        System.out.println(this.getFoodUITO());
        foodService.doSaveFood(this.getFoodUITO());
        getAllFood();
        this.setFoodUITO(new FoodUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Food Details", "Food Details added/updated Successfully."));
    }

    @PostConstruct
    public void getAllFood() {
        if (!this.getFoodUITOList().isEmpty()) {
            this.getFoodUITOList().clear();
            this.getPersonUITOList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + foodService);
        this.getFoodUITOList().addAll(foodService.doFetchAllFood());
        this.getPersonUITOList().addAll(personService.getAllPerson());
        this.setActionLabel("Add");
    }

    public void deleteFood(FoodUITO foodUITO) {
        foodService.doDeleteFood(foodUITO);
        getAllFood();
    }

    public void editFood(FoodUITO foodUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(foodUITO, this.getFoodUITO());
        System.out.println(this.getFoodUITO());
    }

    public FoodUITO getFoodUITO() {
        if (foodUITO == null) {
            foodUITO = new FoodUITO();
        }
        return foodUITO;
    }

    public void setFoodUITO(FoodUITO foodUITO) {
        this.foodUITO = foodUITO;
    }

    public List<FoodUITO> getFoodUITOList() {
        if (null == foodUITOList) {
            foodUITOList = new ArrayList<>();
        }
        return foodUITOList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
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
