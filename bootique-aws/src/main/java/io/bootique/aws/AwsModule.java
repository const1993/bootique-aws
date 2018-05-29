package io.bootique.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.bootique.ConfigModule;
import io.bootique.config.ConfigurationFactory;

public class AwsModule extends ConfigModule {

    @Provides
    @Singleton
    AWSCredentialsProvider provideCredentialsProvider(ConfigurationFactory configurationFactory) {
        return configurationFactory
                .config(ConfigCredentialsProviderFactory.class, configPrefix)
                .createCredentialsProvider();
    }
}
