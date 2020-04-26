package com.marcin.config;

import com.marcin.StorageProperities;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final String FILESYSTEM_ACCESS = "file:";
    private final StorageProperities storageProperities;

    public WebMvcConfiguration(StorageProperities storageProperities) {
        this.storageProperities = storageProperities;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path path = Paths.get(storageProperities.getLocation());
        registry
                .addResourceHandler("/images/**")
                .addResourceLocations(FILESYSTEM_ACCESS + path.toAbsolutePath().toString() + "/");
    }
}
