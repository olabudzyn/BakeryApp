package com.budzynska.mapper;

import com.budzynska.domain.BreadstuffType;
import com.budzynska.dto.BreadstuffTypeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public abstract class BreadstuffTypeMapper {

    public abstract BreadstuffType toBreadstuffType(BreadstuffTypeDTO breadstuffType);

    public abstract BreadstuffTypeDTO toBreadstuffTypeDTO(BreadstuffType breadstuffType);

    public abstract List<BreadstuffTypeDTO> toBreadstuffTypeDTOs(List<BreadstuffType> breadstuffTypes);
}
