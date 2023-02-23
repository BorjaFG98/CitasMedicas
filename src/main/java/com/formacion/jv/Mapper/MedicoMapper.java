package com.formacion.jv.Mapper;

import com.formacion.jv.DTO.MedicoDto;
import com.formacion.jv.Entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface MedicoMapper {
    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    MedicoDto medicoToMedicoDto(Medico medico);

}
