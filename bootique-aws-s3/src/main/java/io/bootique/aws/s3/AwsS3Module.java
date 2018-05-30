package io.bootique.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.bootique.ConfigModule;
import io.bootique.config.ConfigurationFactory;

public class AwsS3Module extends ConfigModule {

    @Provides
    @Singleton
    AmazonS3 provideS3Client(ConfigurationFactory configurationFactory) {
        return configurationFactory.config(S3Factory.class, configPrefix).createS3();
    }
}
