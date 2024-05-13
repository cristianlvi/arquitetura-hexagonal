package com.vieira.hexagonal.adapters.out;

import com.vieira.hexagonal.adapters.out.client.FindAddressByZipcodeClient;
import com.vieira.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.vieira.hexagonal.adapters.out.client.response.AddressResponse;
import com.vieira.hexagonal.application.core.domain.Address;
import com.vieira.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FindAddressByZipcodeAdapter implements FindAddressByZipCodeOutPort {

    private FindAddressByZipcodeClient findAddressByZipcodeClient;
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address findAddresByZipcode(String zipCode) {
        AddressResponse addressResponse = findAddressByZipcodeClient.find(zipCode);

        return addressResponseMapper.toAddress(addressResponse);
    }
}
