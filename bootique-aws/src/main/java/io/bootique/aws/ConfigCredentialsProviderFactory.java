package io.bootique.aws;

import com.amazonaws.auth.AWSCredentialsProvider;
import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;

import java.util.Objects;

@BQConfig
public class ConfigCredentialsProviderFactory {

    private String accessKeyId;
    private String secretAccessKey;

    @BQConfigProperty("Sets AWS account 'accessKeyId'")
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    @BQConfigProperty("Sets AWS account 'secretAccessKey'")
    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public AWSCredentialsProvider createCredentialsProvider() {
        ConfigCredentials credentials = createCredentials();
        return new ConfigCredentialsProvider(credentials);
    }

    protected ConfigCredentials createCredentials() {
        Objects.requireNonNull(accessKeyId, "'accessKeyId' is null");
        Objects.requireNonNull(secretAccessKey, "'secretAccessKey' is null");
        return new ConfigCredentials(accessKeyId, secretAccessKey);
    }

}
