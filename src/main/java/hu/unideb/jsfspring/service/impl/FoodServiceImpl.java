package hu.unideb.jsfspring.service.impl;

import hu.unideb.jsfspring.entity.FoodDTO;
import hu.unideb.jsfspring.entity.PersonDTO;
import hu.unideb.jsfspring.repositry.FoodRepo;
import hu.unideb.jsfspring.service.FoodService;
import hu.unideb.jsfspring.uito.FoodUITO;
import hu.unideb.jsfspring.uito.PersonUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepo foodRepo;

    @Override
    @Transactional(readOnly = false)
    public FoodUITO doSaveFood(FoodUITO foodUITO) {
        FoodDTO dto = UiToToDto(foodUITO);
        dto = foodRepo.save(dto);
        BeanUtils.copyProperties(dto, foodUITO);

        dtoToUito(foodUITO, dto);
        return foodUITO;
    }

    private void dtoToUito(FoodUITO foodUITO, FoodDTO dto) {
        PersonUITO uitTO = new PersonUITO();
        BeanUtils.copyProperties(dto.getPersonDTO(), uitTO);
        foodUITO.setPersonUITO(uitTO);
    }

    private FoodDTO UiToToDto(FoodUITO foodUITO) {
        FoodDTO dto = new FoodDTO();
        PersonDTO personDTO = new PersonDTO();
        BeanUtils.copyProperties(foodUITO, dto);
        BeanUtils.copyProperties(foodUITO.getPersonUITO(), personDTO);
        dto.setPersonDTO(personDTO);
        List<FoodDTO> lst = new ArrayList<>();
        lst.add(dto);
        personDTO.getFooddtolst().addAll(lst);
        return dto;
    }

    @Override
    public List<FoodUITO> doFetchAllFood() {
        List<FoodDTO> dtoLst = foodRepo.findAll();
        List<FoodUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            FoodUITO tmpUiTO = new FoodUITO();
            System.out.println(dto.getPersonDTO());
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public FoodUITO doGetFood(FoodUITO foodUITO) {
        if (null != foodUITO.getFoodId()) {
            FoodDTO dto = new FoodDTO();

            BeanUtils.copyProperties(foodUITO, dto);
            dto = foodRepo.getOne(dto.getFoodId());

            BeanUtils.copyProperties(dto, foodUITO);
        }
        return foodUITO;
    }

    @Override
    @Transactional
    public void doDeleteFood(FoodUITO foodUITO) {
        foodRepo.deleteById(foodUITO.getFoodId());
    }
}
