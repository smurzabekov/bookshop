package ru.sferum.bookmvp.mapper;

import org.mapstruct.Mapper;
import ru.sferum.bookmvp.dto.DealDto;
import ru.sferum.bookmvp.model.Deal;

@Mapper(componentModel = "spring")
public interface DealMapper {
    DealDto fromEntityToDto(Deal deal);

    Deal fromDtoToEntity(DealDto dealDto);
}
