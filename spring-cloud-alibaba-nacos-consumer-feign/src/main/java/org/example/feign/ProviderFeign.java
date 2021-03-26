package org.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-provider")
public interface ProviderFeign {

    @GetMapping("/test/{message}")
    String test(@PathVariable String message);
}
