package com.formacion.jv.Mapper;

import com.formacion.jv.DTO.UsuarioDto;
import com.formacion.jv.Entity.Usuario;
import org.apache.logging.log4j.CloseableThreadContext;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    UsuarioDto usuarioToUsuarioDTO(Usuario usuario);
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
}
