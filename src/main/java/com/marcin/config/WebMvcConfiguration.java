package com.marcin.config;

import com.marcin.StorageProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private static final String FILESYSTEM_ACCESS = "file:";
    private final StorageProperties storageProperties;

    public WebMvcConfiguration(StorageProperties storageProperties)
    {
        this.storageProperties = storageProperties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path path = Paths.get(storageProperties.getLocation());
        registry
                .addResourceHandler("/images/**")
                .addResourceLocations(FILESYSTEM_ACCESS + path.toAbsolutePath().toString() + "/");
    }

    }
