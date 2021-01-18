package config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClient;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonMessagingConfig extends AmazonBasicConfig{

    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClient.builder().withRegion(amazonBasicProperties.getRegion())
                                        .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
                                        .build();
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(
            AmazonSNS amazonSNS) {
        return new NotificationMessagingTemplate(amazonSNS);
    }

    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClient.asyncBuilder().withRegion(amazonBasicProperties.getRegion())
                                                  .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
                                                  .build();
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(
            AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }
}
