package com.vieira.hexagonal.adapters.out.client;

import com.vieira.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipcodeClient",
        url = "${vieira.client.address.url}"
)
public interface FindAddressByZipcodeClient {

    @GetMapping("/{zipcode}")
    AddressResponse find(@PathVariable("zipcode") String zipcode);
}
