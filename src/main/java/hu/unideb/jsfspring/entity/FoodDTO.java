package hu.unideb.jsfspring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FOOD_DIARY")
@NamedQuery(name = "FoodDTO.findAll", query = "SELECT a FROM FoodDTO a")
public class FoodDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;

    @Column(name = "FOOD_NAME")
    private String foodName;

    @Column(name = "GRAMS")
    private Long grams;

    @Column(name = "CALORIES_PER_GRAM")
    private Long caloriesPerGram;

    @Column(name = "EAT_TIME")
    private Long eatTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private PersonDTO personDTO;

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Long getGrams() {
        return grams;
    }

    public void setGrams(Long grams) {
        this.grams = grams;
    }

    public Long getCaloriesPerGram() {
        return caloriesPerGram;
    }

    public void setCaloriesPerGram(Long caloriesPerGram) {
        this.caloriesPerGram = caloriesPerGram;
    }

    public Long getEatTime() {
        return eatTime;
    }

    public void setEatTime(Long eatTime) {
        this.eatTime = eatTime;
    }

    public PersonDTO getPersonDTO() {
        return personDTO;
    }

    public void setPersonDTO(PersonDTO personDTO) {
        this.personDTO = personDTO;
    }
}
