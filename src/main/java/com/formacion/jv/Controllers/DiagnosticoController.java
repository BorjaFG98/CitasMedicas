package com.formacion.jv.Controllers;


import com.formacion.jv.DTO.DiagnosticoDto;
import com.formacion.jv.Entity.Diagnostico;
import com.formacion.jv.Services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diagnosticos")
public class DiagnosticoController {

    @Autowired
    DiagnosticoService Diagn_service;

    @GetMapping
    public List<DiagnosticoDto> obtenerDiagnosticos() {
        return Diagn_service.obtenerDiagnosticos();//invocamos el metodo del servicio
    }

    @PostMapping()
    public Diagnostico guardarDiagnosticos(@RequestBody Diagnostico diagnostico) {
        return this.Diagn_service.guardarDiagnostico(diagnostico);//llamamos el metodo del servicio
    }

    @GetMapping(path = "/{id}")// usuario/id
    public DiagnosticoDto obtenerCitas(@PathVariable("id") Long id) {
        return Diagn_service.obtenerPorId(id); //invocamos el metodo del servicio
    }


    @DeleteMapping(path = "{id}")
    public String eliminarporId(@PathVariable("id") Long id){
        boolean ok = this.Diagn_service.eliminarDiagnostico(id);
        if (ok){
            return "Usuario eliminado con id"+ id;
        }else{
            return "No se puedo eliminar el usuario con id"+ id;
        }

    }

}