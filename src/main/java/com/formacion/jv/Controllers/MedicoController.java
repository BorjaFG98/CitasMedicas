package com.formacion.jv.Controllers;

import com.formacion.jv.DTO.MedicoDto;
import com.formacion.jv.Entity.Medico;
import com.formacion.jv.Services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    MedicoService Med_service;


    @GetMapping
    public List<MedicoDto> obtenerUsuarios() {
        return Med_service.obtenerMedicos();//invocamos el metodo del servicio
    }

    @PostMapping()
    public MedicoDto guardarMedico(@RequestBody Medico medico) {
        return this.Med_service.guardarMedicos(medico);//llamamos el metodo del servicio
    }

    @GetMapping(path = "/{id}")// Medicos/id
    public MedicoDto obtenerMedicosPorId(@PathVariable("id") Long id) {
        return Med_service.obtenerPorId(id); //invocamos el metodo del servicio
    }

    @GetMapping("/query")
    public List<MedicoDto> obtenerMedicobyusuario(@RequestParam("usuario") String usuario){
        return this.Med_service.obtenerPorUsuario(usuario);//ejemplo: local.../usuario?usuario=GOD
    }
    @GetMapping("/query1")
    public List<MedicoDto> obtenerMedicobynumColegiado(@RequestParam("numColegiado") String numColegiado){
        return this.Med_service.obtenerPorNumColegiado(numColegiado);//ejemplo: local.../usuario/query?usuario=GOD
    }

    @DeleteMapping(path = "{id}")
    public String eliminarporId(@PathVariable("id") Long id){
        boolean ok = this.Med_service.eliminarmedico(id);
        if (ok){
            return "Usuario eliminado con id"+ id;
        }else{
            return "No se puedo eliminar el usuario con id"+ id;
        }

    }


}
