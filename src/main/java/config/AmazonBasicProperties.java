package config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("amazon")
@Data
public class AmazonBasicProperties {
    @NotBlank
    private String region = "us-east-1";
    @NotBlank
    private String accessKey;
    @NotBlank
    private String secretKey;
    private String dynamoEndpoint;
    private String snsEndpoint;
    private String sqsEndpoint;
}
