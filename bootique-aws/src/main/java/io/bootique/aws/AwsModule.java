package io.bootique.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import io.bootique.ConfigModule;
import io.bootique.config.ConfigurationFactory;

public class AwsModule extends ConfigModule {

    @Provides
    @Singleton
    AwsConfigFactory provideConfigFactory(ConfigurationFactory configurationFactory) {
        return configurationFactory.config(AwsConfigFactory.class, configPrefix);
    }

    @Provides
    @Singleton
    AWSCredentialsProvider provideCredentialsProvider(AwsConfigFactory configFactory) {
        return configFactory.createCredentialsProvider();
    }

    @Provides
    @Singleton
    AwsConfig provideConfig(AwsConfigFactory configFactory) {
        return configFactory.createConfig();
    }
}
