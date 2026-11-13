
package com.studentmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.studentmanagement.service",
        "com.studentmanagement.repository"
})
public class PersistenceConfig {

    // Database Configuration
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setDriverClassName(
                "com.mysql.cj.jdbc.Driver"
        );

        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/student_management_db"
        );

        dataSource.setUsername("root");

        dataSource.setPassword("Root");

        return dataSource;
    }

    // EntityManagerFactory Configuration
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setDataSource(dataSource());

        factory.setPackagesToScan(
                "com.studentmanagement.entity"
        );

        factory.setJpaVendorAdapter(
                new HibernateJpaVendorAdapter()
        );

        Properties properties = new Properties();

        properties.put(
                "hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect"
        );

        properties.put(
                "hibernate.hbm2ddl.auto",
                "update"
        );

        properties.put(
                "hibernate.show_sql",
                "true"
        );

        properties.put(
                "hibernate.format_sql",
                "true"
        );

        factory.setJpaProperties(properties);

        return factory;
    }

    // Transaction Manager
    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager transactionManager =
                new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(
                entityManagerFactory().getObject()
        );

        return transactionManager;
    }
}
