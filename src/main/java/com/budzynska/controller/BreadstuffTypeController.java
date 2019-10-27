package com.budzynska.controller;

import com.budzynska.dto.BreadstuffTypeDTO;
import com.budzynska.mapper.BreadstuffTypeMapper;
import com.budzynska.service.BreadstuffTypeService;
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
@RequestMapping("/breadstufftype")
public class BreadstuffTypeController {

    private final BreadstuffTypeService service;
    private final BreadstuffTypeMapper mapper;

    @GetMapping
    public List<BreadstuffTypeDTO> getAll(){
        return mapper.toBreadstuffTypeDTOs(service.getAll());
    }

    @PostMapping
    public boolean addType(@RequestBody BreadstuffTypeDTO breadstuffType){
        return service.addBreadstuffType(mapper.toBreadstuffType(breadstuffType));
    }
}
