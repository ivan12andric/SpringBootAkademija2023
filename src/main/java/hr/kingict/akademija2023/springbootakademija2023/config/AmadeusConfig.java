package hr.kingict.akademija2023.springbootakademija2023.config;

import com.amadeus.Amadeus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmadeusConfig {

    @Value("${amadeus.client-id}")
    private String clientId;

    @Value("${amadeus.client-secret}")
    private String clientSecret;

    @Bean
    public Amadeus getAmadeus() {
        return Amadeus
                .builder("RuRNwWDrX0F4G3nLKVGDGEZiOPGoIlew", "jOHSRFlXPsGwDFyz")
                .build();
    }
}
