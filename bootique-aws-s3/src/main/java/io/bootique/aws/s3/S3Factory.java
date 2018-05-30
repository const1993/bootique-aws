package io.bootique.aws.s3;

import com.amazonaws.services.s3.AmazonS3;
import io.bootique.annotation.BQConfig;

@BQConfig("Configures Amazon S3 client")
public class S3Factory {

    public AmazonS3 createS3() {
        throw new UnsupportedOperationException("TODO");
    }
}
