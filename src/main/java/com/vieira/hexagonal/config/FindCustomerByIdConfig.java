package com.vieira.hexagonal.config;

import com.vieira.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.vieira.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {


    @Bean
    public FindCustomerByIdUserCase findCustomerByIdUserCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUserCase(findCustomerByIdAdapter);
    }

}
