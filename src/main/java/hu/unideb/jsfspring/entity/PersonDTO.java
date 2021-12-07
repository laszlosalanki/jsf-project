package hu.unideb.jsfspring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PEOPLE")
public class PersonDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "PERSON_AGE")
    private Long personAge;

    @OneToMany(mappedBy = "personDTO")
    private List<FoodDTO> fooddtolst;

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

    public List<FoodDTO> getFooddtolst() {
        if (null == fooddtolst)
            fooddtolst = new ArrayList<>();
        return fooddtolst;
    }

    public void setFooddtolst(List<FoodDTO> fooddtolst) {
        this.fooddtolst = fooddtolst;
    }
}
