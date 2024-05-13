package com.vieira.hexagonal.application.ports.out;

import com.vieira.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPort {

    Address findAddresByZipcode(String zipCode);

}
