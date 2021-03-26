package org.example.feign;

import org.example.feign.fullbak.FallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-provider",fallback = FallbackServiceImpl.class)
public interface ProviderFeign {

    @GetMapping("/test/{message}")
    String test(@PathVariable String message);
}
