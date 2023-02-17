package io.menglibay.springcourse.util;

import io.menglibay.springcourse.dao.PersonDAO;
import io.menglibay.springcourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDAO peopleDAO;

    @Autowired
    public PersonValidator(PersonDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person people = (Person) o;

        if(peopleDAO.getPersonByFullName(people.getFullName()).isPresent()) {
            errors.rejectValue("fullName","","This is person have");
        }
    }
}
