package com.vieira.hexagonal.config;

import com.vieira.hexagonal.adapters.out.DeleteCustomerByIdByAdapter;
import com.vieira.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.vieira.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUserCase findCustomerByIdUserCase,
            DeleteCustomerByIdByAdapter deleteCustomerByIdByAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUserCase, deleteCustomerByIdByAdapter);
    }


}
