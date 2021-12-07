package hu.unideb.jsfspring.uito;

import java.io.Serializable;

public class FoodUITO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long foodId;
    private String foodName;
    private Long grams;
    private Long caloriesPerGram;
    private Long eatTime;
    private PersonUITO personUITO;

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

    public PersonUITO getPersonUITO() {
        return personUITO;
    }

    public void setPersonUITO(PersonUITO personUITO) {
        this.personUITO = personUITO;
    }

    @Override
    public String toString() {
        return "FoodUITO{" +
                "foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", grams=" + grams +
                ", caloriesPerGram=" + caloriesPerGram +
                ", eatTime=" + eatTime +
                ", personUITO=" + personUITO +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
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
        FoodUITO other = (FoodUITO) obj;
        if (foodName == null) {
            if (other.foodName != null)
                return false;
        } else if (!foodName.equals(other.foodName))
            return false;
        return true;
    }
}
