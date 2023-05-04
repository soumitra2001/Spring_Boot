package com.supriya.Mapping.services;

import com.supriya.Mapping.models.Address;
import com.supriya.Mapping.repositories.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepo addressRepo;

    public List<Address> getAllAddress(){
        return (List<Address>) addressRepo.findAll();
    }

    public String addAddress(Address address){
        addressRepo.save(address);
        return "Address saved successfully..!";
    }

    public String deleteAddress(String id){
        List<Address> addresses=getAllAddress();
        for(Address address:addresses){
            if(address.getAddressId()==Long.parseLong(id)){
                addressRepo.deleteById(Long.parseLong(id));
                return "Address deleted successfully..(*_*)";
            }
        }
        return "Invalid user input..!";
    }
}
