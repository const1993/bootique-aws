package io.bootique.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

/**
 * An {@link AWSCredentialsProvider} based on Bootique config facilities. Does not support credentials refreshing.
 */
public class ConfigCredentialsProvider implements AWSCredentialsProvider {

    private ConfigCredentials credentials;

    public ConfigCredentialsProvider(ConfigCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public AWSCredentials getCredentials() {
        return credentials;
    }

    @Override
    public void refresh() {
        // do nothing
    }
}
