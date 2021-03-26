package org.example.feign.fullbak;

import org.example.feign.ProviderFeign;
import org.springframework.stereotype.Component;

@Component
public class FallbackServiceImpl implements ProviderFeign {

    @Override
    public String test(String message) {
        return "test fallback";
    }
}
