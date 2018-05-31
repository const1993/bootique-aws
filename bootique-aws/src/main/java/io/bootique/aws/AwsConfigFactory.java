package io.bootique.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;

import java.util.Objects;
import java.util.Optional;

@BQConfig
public class AwsConfigFactory {

    private String accessKey;
    private String secretKey;
    private String defaultRegion;

    @BQConfigProperty("Sets AWS account credentials 'accessKey'")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @BQConfigProperty("AWS account credentials 'secretKey'")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @BQConfigProperty("Optional default region to use for AWS calls.")
    public void setDefaultRegion(String defaultRegion) {
        this.defaultRegion = defaultRegion;
    }

    public AwsConfig createConfig() {
        Optional<Regions> region = Optional.ofNullable(defaultRegion).map(Regions::fromName);
        return new AwsConfig(region);
    }

    public AWSCredentialsProvider createCredentialsProvider() {
        AWSCredentials credentials = createCredentials();
        return new AWSStaticCredentialsProvider(credentials);
    }

    protected AWSCredentials createCredentials() {
        Objects.requireNonNull(accessKey, "'accessKey' is null");
        Objects.requireNonNull(secretKey, "'secretKey' is null");

        return new BasicAWSCredentials(accessKey, secretKey);
    }

}
