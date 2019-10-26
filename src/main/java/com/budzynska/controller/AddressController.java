package com.budzynska.controller;

import com.budzynska.dto.AddressDTO;
import com.budzynska.dto.AddressPostDTO;
import com.budzynska.mapper.AddressMapper;
import com.budzynska.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper mapper;

    @GetMapping
    public List<AddressDTO> getAllAddresses(){
        return mapper.toAddressDTOs(addressService.getAllAddress());
    }

    @GetMapping("/{id}")
    public AddressDTO getById(@PathVariable Long id){
        return mapper.toAddressDTO(addressService.findById(id));
    }

    @GetMapping("/user/{id}")
    public List<AddressDTO> getByUser(@PathVariable Long id){
        return mapper.toAddressDTOs(addressService.findAllByUser(id));
    }


    @PostMapping
    public void addUser(@RequestBody AddressPostDTO addressPostDTO){
        addressService.addAddress(mapper.toAddress(addressPostDTO));
    }

}
