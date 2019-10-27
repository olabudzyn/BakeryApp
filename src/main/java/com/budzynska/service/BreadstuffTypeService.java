package com.budzynska.service;

import com.budzynska.domain.BreadstuffType;
import com.budzynska.repository.BreadstuffTypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BreadstuffTypeService {

    private final BreadstuffTypeRepo repository;

    public List<BreadstuffType> getAll(){
        return repository.findAll();
    }

    public boolean addBreadstuffType(BreadstuffType breadstuffType) {
        BreadstuffType temp = repository.findBreadstuffTypeByType(breadstuffType.getType());
        if(temp != null){
            return false;
        }
        repository.save(breadstuffType);
        return true;
    }
}
