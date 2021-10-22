package com.prosegur.sol.servicebilling.complement.api;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import com.prosegur.sol.utils.EnableSolUtils;
import com.prosegur.sol.utils.annotations.SolApisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.WebApplicationInitializer;


@EnableSolUtils
@SolApisProperties
@SpringBootApplication(scanBasePackages = "com.prosegur.sol.servicebilling.complement.api")
@EntityScan(basePackages = "com.prosegur.sol.servicebilling.complement.api")
@EnableJpaRepositories(repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class SolServiceBillingComplementApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(SolServiceBillingComplementApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(SolServiceBillingComplementApplication.class);
    }
}