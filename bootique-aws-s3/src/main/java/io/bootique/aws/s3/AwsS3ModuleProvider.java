package io.bootique.aws.s3;

import com.google.inject.Module;
import io.bootique.BQModuleProvider;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

public class AwsS3ModuleProvider implements BQModuleProvider {

    @Override
    public Module module() {
        return new AwsS3Module();
    }

    @Override
    public Map<String, Type> configs() {
        return Collections.singletonMap("awss3", S3Factory.class);
    }
}
