package com.budzynska.mapper;

import com.budzynska.domain.Address;
import com.budzynska.dto.AddressDTO;
import com.budzynska.dto.AddressPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    @Mapping(target = "userEmail", source = "user.email")
    public abstract AddressDTO toAddressDTO(Address address);

    @Mapping(target = "user.id", source = "userId")
    public abstract Address toAddress(AddressPostDTO addressPostDTO);

    @Mapping(target = "userId", source = "user.id")
    public abstract AddressPostDTO toAddressPostDTO(Address address);

    public abstract List<AddressDTO> toAddressDTOs(List<Address> addressList);


}
