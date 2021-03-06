package org.example.config;


import org.example.properties.PersonProperties;
import org.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PersonProperties.class)
@ConditionalOnClass({PersonService.class})
@ConditionalOnProperty(prefix = "spring.person", value = "enabled", matchIfMissing = true)
public class PersonServiceAutoConfiguration {

    @Autowired
    private PersonProperties properties;

    @Bean
    // 当容器中没有指定Bean的情况下，自动配置PersonService类
    @ConditionalOnMissingBean(PersonService.class)
    public PersonService personService(){
        PersonService personService = new PersonService(properties);
        return personService;
    }
}
