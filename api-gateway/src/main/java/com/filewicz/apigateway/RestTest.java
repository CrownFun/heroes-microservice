package com.filewicz.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RestTest {

    @Value("${info.property}")
    private String property;

    @GetMapping("/message")
    String property() {
        return property;
    }

}
