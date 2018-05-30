package io.bootique.aws.s3;

import io.bootique.test.junit.BQModuleProviderChecker;
import org.junit.Test;

public class AwsS3ModuleProviderTest {

    @Test
    public void testAutoLoading() {
        BQModuleProviderChecker.testAutoLoadable(AwsS3ModuleProvider.class);
    }
}
