package config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class AmazonMessagingConfig extends AmazonBasicConfig{

    @Bean
    public AmazonSNS amazonSNS() {
        AmazonSNSClientBuilder amazonSNS = AmazonSNSClient.builder()
                                                          .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()));

        if(Objects.nonNull(amazonBasicProperties.getSnsEndpoint())) {
            amazonSNS.setEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonBasicProperties.getSnsEndpoint(),
                                                                                          amazonBasicProperties.getRegion()));
        } else {
            amazonSNS.withRegion(amazonBasicProperties.getRegion());
        }
        return amazonSNS.build();
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(
            AmazonSNS amazonSNS) {
        return new NotificationMessagingTemplate(amazonSNS);
    }

    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        AmazonSQSAsyncClientBuilder sqsAsync = AmazonSQSAsyncClient.asyncBuilder()
                                                                   .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()));

        if(Objects.nonNull(amazonBasicProperties.getSqsEndpoint())) {
            sqsAsync.setEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonBasicProperties.getSqsEndpoint(),
                                                                                         amazonBasicProperties.getRegion()));
        } else {
            sqsAsync.withRegion(amazonBasicProperties.getRegion());
        }
        return sqsAsync.build();
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(
            AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }
}
