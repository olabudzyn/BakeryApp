package com.budzynska.service;

import com.budzynska.domain.Address;
import com.budzynska.domain.User;
import com.budzynska.exception.ResourceNotFoundException;
import com.budzynska.repository.AddressRepo;
import com.budzynska.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo repository;
    private final UserRepo userRepository;

    public Address findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("address", "id", id));
    }

    public List<Address> getAllAddress(){
        return repository.findAll();
    }

    public void addAddress(Address address){
        repository.save(address);
    }

    public List<Address> findAllByUser(Long id){
        User tempUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("address.user", "id", id));
        return repository.findAddressesByUser(tempUser);
    }
}
