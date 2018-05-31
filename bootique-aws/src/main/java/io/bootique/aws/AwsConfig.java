package io.bootique.aws;

import com.amazonaws.regions.Regions;

import java.util.Optional;

public class AwsConfig {

    private Optional<Regions> defaultRegion;

    public AwsConfig(Optional<Regions> defaultRegion) {
        this.defaultRegion = defaultRegion;
    }

    public Optional<Regions> getDefaultRegion() {
        return defaultRegion;
    }
}
