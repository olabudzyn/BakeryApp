package com.budzynska.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long id;

    private String city;

    private String street;

    private String number;

    private String userEmail;
}
