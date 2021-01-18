package config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AmazonBasicProperties.class)
public class AmazonBasicConfig {

    @Autowired
    protected AmazonBasicProperties amazonBasicProperties;

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonBasicProperties.getAccessKey(), amazonBasicProperties.getSecretKey());
    }

}
