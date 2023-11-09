package com.medical.common.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ConfigService {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
