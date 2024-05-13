package com.vieira.hexagonal.adapters.out.client.mapper;

import com.vieira.hexagonal.adapters.out.client.response.AddressResponse;
import com.vieira.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
