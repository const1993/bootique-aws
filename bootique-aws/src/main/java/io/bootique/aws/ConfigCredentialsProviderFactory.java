package io.bootique.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;

import java.util.Objects;

@BQConfig
public class ConfigCredentialsProviderFactory {

    private String accessKey;
    private String secretKey;

    @BQConfigProperty("Sets AWS account credentials 'accessKey'")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @BQConfigProperty("AWS account credentials 'secretKey'")
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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
