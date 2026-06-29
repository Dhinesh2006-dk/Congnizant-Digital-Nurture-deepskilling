package com.example.employeemanagementsystem.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class PrimaryDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "org.h2.Driver");

        dataSource.setUrl(
                "jdbc:h2:mem:primarydb");

        dataSource.setUsername("sa");
        dataSource.setPassword("password");

        return dataSource;
    }
}