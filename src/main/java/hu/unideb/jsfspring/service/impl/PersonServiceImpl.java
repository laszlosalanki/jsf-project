package hu.unideb.jsfspring.service.impl;

import hu.unideb.jsfspring.entity.PersonDTO;
import hu.unideb.jsfspring.repositry.PersonRepo;
import hu.unideb.jsfspring.service.PersonService;
import hu.unideb.jsfspring.uito.PersonUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public List<PersonUITO> getAllPerson() {
        List<PersonUITO> personUITOLst = new ArrayList<>();
        List<PersonDTO> personDTOLst = personRepo.findAll();

        personDTOLst.forEach(dto -> {
            PersonUITO tmpUiTO = new PersonUITO();

            BeanUtils.copyProperties(dto, tmpUiTO);
            personUITOLst.add(tmpUiTO);
        });

        return personUITOLst;
    }

    @Override
    public PersonUITO getPerson(PersonUITO personUITO) {
        System.out.println(">>>>> " + personUITO.getPersonName());
        PersonDTO dto = personRepo.findTitleByPersonName(personUITO.getPersonName());
        PersonUITO uito = new PersonUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }
}
