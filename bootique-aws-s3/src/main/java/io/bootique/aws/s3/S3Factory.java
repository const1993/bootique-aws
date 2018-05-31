package io.bootique.aws.s3;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.bootique.aws.AwsConfig;

// TODO: other builder settings... once we have extra properties make this BQConfig...
public class S3Factory {

    public AmazonS3 createS3(AWSCredentialsProvider credentialsProvider, AwsConfig config) {
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder
                .standard()
                .withCredentials(credentialsProvider);

        config.getDefaultRegion().ifPresent(builder::withRegion);

        return builder.build();
    }
}
