package io.bootique.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import io.bootique.test.junit.BQTestFactory;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AwsModuleIT {

    @Rule
    public BQTestFactory testFactory = new BQTestFactory();

    @Test
    public void testInjectableAWSCredentialsProvider() {
        AWSCredentialsProvider provider = testFactory
                .app()
                .autoLoadModules()
                .property("bq.aws.accessKey", "xyz")
                .property("bq.aws.secretKey", "abc")
                .createRuntime()
                .getInstance(AWSCredentialsProvider.class);

        AWSCredentials credentials = provider.getCredentials();

        assertNotNull(credentials);
        assertEquals("xyz", credentials.getAWSAccessKeyId());
        assertEquals("abc", credentials.getAWSSecretKey());
    }
}
