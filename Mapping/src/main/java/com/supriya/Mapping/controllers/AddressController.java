package com.supriya.Mapping.controllers;

import com.supriya.Mapping.models.Address;
import com.supriya.Mapping.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService service;

    @GetMapping(value = "/allAddress")
    public List<Address> getAllAddress(){
        return service.getAllAddress();
    }

    @PostMapping(value = "/address")
    public String addAddress(@Valid @RequestBody Address address){
        return service.addAddress(address);
    }

    @DeleteMapping(value = "/eraseAddress/{id}")
    public String deleteAddress(@PathVariable String id){
        return service.deleteAddress(id);
    }
}
