package com.budzynska.dto;

import lombok.Data;

@Data
public class AddressPostDTO {

    private Long id;

    private String city;

    private String street;

    private String number;

    private Long userId;
}
