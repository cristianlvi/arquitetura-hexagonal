package com.vieira.hexagonal.adapters.in.controller;


import com.vieira.hexagonal.adapters.in.controller.Request.CustomerRequest;
import com.vieira.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.vieira.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.vieira.hexagonal.application.core.domain.Customer;
import com.vieira.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.vieira.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.vieira.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.vieira.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {


    private InsertCustomerInputPort insertCustomerInputPort;
    private CustomerMapper customerMapper;
    private FindCustomerByIdInputPort customerByIdInputPort;
    private UpdateCustomerInputPort updateCustomerInputPort;
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;


    @PostMapping
    public ResponseEntity<Void> insertCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.mapToCustomer(customerRequest);

        insertCustomerInputPort.insert(customer, customerRequest.getZipcode());

        return ResponseEntity.status(201).build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable("id") String id) {
        Customer customer = customerByIdInputPort.findById(id);

        CustomerResponse customerResponse = customerMapper.mapToCustomerResponse(customer);

        return ResponseEntity.ok().body(customerResponse);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("id") String id, @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.mapToCustomer(customerRequest);
        customer.setId(id);

        updateCustomerInputPort.updateCustomer(customer, customerRequest.getZipcode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") String id) {
        deleteCustomerByIdInputPort.deleteCustomerById(id);

        return ResponseEntity.noContent().build();
    }


}
