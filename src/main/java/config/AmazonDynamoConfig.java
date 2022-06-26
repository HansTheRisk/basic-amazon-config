package config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class AmazonDynamoConfig extends AmazonBasicConfig {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
        AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(amazonAWSCredentials());
        builder.setCredentials(provider);

        if (Objects.nonNull(amazonBasicProperties.getDynamoEndpoint()))
            builder.setEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonBasicProperties.getDynamoEndpoint(),
                                                                                        amazonBasicProperties.getRegion()));
        return builder.build();
    }

}
