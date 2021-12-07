package hu.unideb.jsfspring.service;

import hu.unideb.jsfspring.uito.PersonUITO;

import java.util.List;

public interface PersonService {
    List<PersonUITO> getAllPerson();

    PersonUITO getPerson(PersonUITO personUITO);
}
