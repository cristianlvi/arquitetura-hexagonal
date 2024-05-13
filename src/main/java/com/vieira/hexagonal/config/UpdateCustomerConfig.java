package com.vieira.hexagonal.config;

import com.vieira.hexagonal.adapters.out.FindAddressByZipcodeAdapter;
import com.vieira.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.vieira.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import com.vieira.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {


    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUserCase findCustomerByIdUserCase,
            FindAddressByZipcodeAdapter findAddressByZipcodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUserCase, findAddressByZipcodeAdapter, updateCustomerAdapter);
    }

}
