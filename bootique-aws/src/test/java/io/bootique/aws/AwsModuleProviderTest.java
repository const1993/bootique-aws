package io.bootique.aws;

import io.bootique.test.junit.BQModuleProviderChecker;
import org.junit.Test;

public class AwsModuleProviderTest {

    @Test
    public void testAutoLoading() {
        BQModuleProviderChecker.testAutoLoadable(AwsModuleProvider.class);
    }
}
