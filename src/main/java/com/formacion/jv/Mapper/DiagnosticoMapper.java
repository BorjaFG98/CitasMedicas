package com.formacion.jv.Mapper;

import com.formacion.jv.DTO.DiagnosticoDto;
import com.formacion.jv.Entity.Diagnostico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DiagnosticoMapper {
    DiagnosticoMapper INSTANCE = Mappers.getMapper(DiagnosticoMapper.class);

    DiagnosticoDto diagnosticoToDiagnosticoDTO(Diagnostico diagnostico);
}
