package com.BeanUtils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public   class   modelMapper {
    @Bean
    public  ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
