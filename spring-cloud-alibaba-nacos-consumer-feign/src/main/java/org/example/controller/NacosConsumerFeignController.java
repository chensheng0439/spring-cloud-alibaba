package org.example.controller;

import org.example.feign.ProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConsumerFeignController {

    @Autowired
    private ProviderFeign providerFeign;

    @GetMapping(value = "/test/hi")
    public String test() {
        return providerFeign.test("Hi Feign");
    }

}
