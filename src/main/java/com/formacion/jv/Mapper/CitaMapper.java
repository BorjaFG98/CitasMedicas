package com.formacion.jv.Mapper;

import com.formacion.jv.DTO.CitaDto;
import com.formacion.jv.Entity.Cita;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CitaMapper {
    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);
    CitaDto citaToCitaDto(Cita cita);
}
