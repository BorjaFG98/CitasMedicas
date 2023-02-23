package com.formacion.jv.Services;


import com.formacion.jv.Entity.Usuario;
import com.formacion.jv.Mapper.UsuarioMapper;
import com.formacion.jv.DTO.UsuarioDto;
import com.formacion.jv.Exception.NotFoundException;
import com.formacion.jv.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service //declaramos capa servicio
public class UsuarioService {
    @Autowired //NO hace falta instanciar, spring lo hará por sí
    UsuarioRepository User_repo;

    public List<UsuarioDto> obtenerUsuarios() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        for (Usuario usuario : User_repo.findAll()) {
            UsuarioDto usuarioDto = UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
            usuarioDtos.add(usuarioDto);
        }
        return usuarioDtos;
    }
    public List<UsuarioDto> obtenerPorUsuario(String user){
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        for (Usuario usuario : User_repo.findByUsuario(user)) {
            UsuarioDto usuarioDto = UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
            usuarioDtos.add(usuarioDto);
        }
        return usuarioDtos; //Usamos el metodo abstracto que declaramos en repo
    }


    public UsuarioDto guardarUsuario(Usuario user) {
        Usuario usuario = User_repo.save(user);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario);
    }


    public UsuarioDto obtenerPorId(Long id) {
        Optional <Usuario> usuario = User_repo.findById(id);//Causa una excepcion si falla, se pone como opcional por si damos una Id que no está
        if (usuario.isEmpty()) {
            throw new NotFoundException("Usuario not found : " + id);
        }
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDTO(usuario.get());
    }

    public boolean eliminarusuario(long id){
        try{
            User_repo.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }

}