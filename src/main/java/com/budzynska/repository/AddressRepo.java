package com.budzynska.repository;

import com.budzynska.domain.Address;
import com.budzynska.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

    public List<Address> findAddressesByUser(User user);
}
