package hu.unideb.jsfspring.service;

import hu.unideb.jsfspring.uito.FoodUITO;

import java.util.List;

public interface FoodService {
    FoodUITO doSaveFood(FoodUITO foodUITO);

    List<FoodUITO> doFetchAllFood();

    FoodUITO doGetFood(FoodUITO foodUITO);

    void doDeleteFood(FoodUITO foodUITO);
}
