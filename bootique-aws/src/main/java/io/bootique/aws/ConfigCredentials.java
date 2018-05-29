package io.bootique.aws;

import com.amazonaws.auth.AWSCredentials;

public class ConfigCredentials implements AWSCredentials {

    private String accessKeyId;
    private String secretAccessKey;

    public ConfigCredentials(String accessKeyId, String secretAccessKey) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
    }

    @Override
    public String getAWSAccessKeyId() {
        return accessKeyId;
    }

    @Override
    public String getAWSSecretKey() {
        return secretAccessKey;
    }
}
