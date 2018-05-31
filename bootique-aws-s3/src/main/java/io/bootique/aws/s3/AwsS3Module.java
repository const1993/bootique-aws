package io.bootique.aws.s3;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.bootique.ConfigModule;
import io.bootique.aws.AwsConfig;
import io.bootique.config.ConfigurationFactory;

public class AwsS3Module extends ConfigModule {

    @Provides
    @Singleton
    AmazonS3 provideS3Client(
            ConfigurationFactory configurationFactory,
            AWSCredentialsProvider credentialsProvider,
            AwsConfig config) {
        return configurationFactory.config(S3Factory.class, configPrefix).createS3(credentialsProvider, config);
    }
}
