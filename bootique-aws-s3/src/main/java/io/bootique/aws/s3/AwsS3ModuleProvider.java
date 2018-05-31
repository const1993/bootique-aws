package io.bootique.aws.s3;

import com.google.inject.Module;
import io.bootique.BQModuleProvider;

public class AwsS3ModuleProvider implements BQModuleProvider {

    @Override
    public Module module() {
        return new AwsS3Module();
    }
}
