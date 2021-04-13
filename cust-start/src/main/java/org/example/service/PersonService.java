package org.example.service;

import org.example.properties.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonProperties personProperties;

    public PersonService(PersonProperties personProperties) {
        this.personProperties = personProperties;
    }

    public PersonService() {
    }


    public void sayHello(){
        System.out.println("大家好，我叫: " + personProperties.getName() + ", 今年" + personProperties.getAge() + "岁"
                + ", 性别: " + personProperties.getSex());
    }
}
