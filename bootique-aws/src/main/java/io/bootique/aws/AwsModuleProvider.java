package io.bootique.aws;

import com.google.inject.Module;
import io.bootique.BQModuleProvider;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

public class AwsModuleProvider implements BQModuleProvider {

    @Override
    public Module module() {
        return new AwsModule();
    }

    @Override
    public Map<String, Type> configs() {
        return Collections.singletonMap("aws", AwsConfigFactory.class);
    }
}
