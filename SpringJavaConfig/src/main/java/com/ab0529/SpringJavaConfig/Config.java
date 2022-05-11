package com.ab0529.SpringJavaConfig;

import com.ab0529.SpringJavaConfig.models.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean("Student")
    public Student getStudent() {
        return new Student();
    }
}
