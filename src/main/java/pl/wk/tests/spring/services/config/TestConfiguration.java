package pl.wk.tests.spring.services.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Fumik on 5/26/2017.
 */
@Configuration
@PropertySource( value = {"classpath:/default_config.properties", "file:config/sample_config.properties"}, ignoreResourceNotFound = true)
public class TestConfiguration {

    @Value("${sample.value}")
    private String sampleValue;

    public String getSampleValue() {
        return sampleValue;
    }

    public void setSampleValue(String sampleValue) {
        this.sampleValue = sampleValue;
    }
}
