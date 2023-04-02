package com.example.springswagger.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import io.opentelemetry.extension.trace.propagation.B3MultiConfigurablePropagator;
import io.opentelemetry.extension.trace.propagation.B3Propagator;

@Configuration
public class RequestLoggingConfig {
    
    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
          = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA: ");
        return filter;
    }

    @Bean
    public B3Propagator b3Propagator() {
        return B3Propagator.injectingMultiHeaders();
    }

    // Need to use RestTemplateBuilder so b3 headers are propagated in outgoing HTTP calls
    @Bean 
    public RestTemplate restTemplate(RestTemplateBuilder builder) { return builder.build(); }
}