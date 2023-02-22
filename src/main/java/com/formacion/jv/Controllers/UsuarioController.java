package com.formacion.jv.Controllers;

import java.lang.*;
import java.util.*;

import com.formacion.jv.DTO.UsuarioDto;
import com.formacion.jv.Entity.Usuario;
import com.formacion.jv.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService U_service;




    @GetMapping
    public List<UsuarioDto> obtenerUsuarios() {
        return U_service.obtenerUsuarios();}//Llamamos al método del servicio

    @PostMapping()
    public UsuarioDto guardarUsuario(@RequestBody Usuario usuario) {
        return this.U_service.guardarUsuario(usuario);//llamamos el metodo del servicio
    }

    @GetMapping(path = "/{id}")// usuario/id
    public UsuarioDto obtenerUsuarios(@PathVariable("id") Long id) {
        return U_service.obtenerPorId(id); //invocamos el metodo del servicio
    }

    @GetMapping("/query")
    public List<UsuarioDto> obtenerUsuariobyusuario(@RequestParam("usuario") String usuario){
        return this.U_service.obtenerPorUsuario(usuario);//ejemplo: local.../usuario?usuario=GOD
    }

    @DeleteMapping(path = "{id}")
    public String eliminarporId(@PathVariable("id") Long id){
        boolean ok = this.U_service.eliminarusuario(id);
        if (ok){
            return "Usuario eliminado con id"+ id;
        }else{
            return "No se puedo eliminar el usuario con id"+ id;
        }

    }


}




