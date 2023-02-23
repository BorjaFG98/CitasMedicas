package com.formacion.jv.Mapper;

import com.formacion.jv.DTO.PacienteDto;
import com.formacion.jv.Entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDto pacienteToPacienteDTO(Paciente paciente);
}
