package hu.unideb.jsfspring.uito;

import java.io.Serializable;
import java.util.List;

public class PersonUITO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long personId;
    private String personName;
    private Long personAge;

    private List<FoodUITO> foodUITOLst;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Long getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Long personAge) {
        this.personAge = personAge;
    }

    public List<FoodUITO> getFoodUITOLst() {
        return foodUITOLst;
    }

    public void setFoodUITOLst(List<FoodUITO> foodUITOLst) {
        this.foodUITOLst = foodUITOLst;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((personId == null) ? 0 : personId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonUITO other = (PersonUITO) obj;
        if (personId == null) {
            if (other.personId != null)
                return false;
        } else if (!personId.equals(other.personId))
            return false;
        return true;
    }
}
