package org.example.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.person")
//@Component
@Data
public class PersonProperties {

    private String name;

    private Integer age;

    private String sex = "M";

}
