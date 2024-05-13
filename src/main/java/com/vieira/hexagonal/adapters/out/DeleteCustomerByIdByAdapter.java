package com.vieira.hexagonal.adapters.out;

import com.vieira.hexagonal.adapters.out.repository.CustomerRepository;
import com.vieira.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCustomerByIdByAdapter implements DeleteCustomerByIdOutputPort {

    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }
}
