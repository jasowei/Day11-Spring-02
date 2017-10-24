package com.lanou.dao;

import com.lanou.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by dllo on 17/10/24.
 */

//@Repository("personDao")
public class PersonDaoImpl {

//    private Person person = new Person("jaso","123456");
    private Person person ;

    public boolean login(String name, String pwd){
        if (name.equals(person.getName()) &&
                pwd.equals(person.getPassword())){
            return true;
        }
        return false;
    }

    public Person getPerson() {
        return person;
    }

//    @Autowired
    public void setPerson(Person person) {
        this.person = person;
    }
}
