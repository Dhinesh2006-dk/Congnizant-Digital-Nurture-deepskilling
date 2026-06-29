package com.example.employeemanagementsystem.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SecondaryDataSourceConfig {

    @Bean(name = "secondaryDataSource")
    public DataSource secondaryDataSource() {

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "org.h2.Driver");

        dataSource.setUrl(
                "jdbc:h2:mem:secondarydb");

        dataSource.setUsername("sa");
        dataSource.setPassword("password");

        return dataSource;
    }
}