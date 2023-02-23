package com.formacion.jv.Controllers;


import com.formacion.jv.DTO.CitaDto;
import com.formacion.jv.Entity.Cita;
import com.formacion.jv.Services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    CitaService Cita_service;

    @GetMapping
    public List<CitaDto> obtenerCitas() {
        return Cita_service.obtenerCitas();//invocamos el metodo del servicio
    }

    @PostMapping()
    public Cita guardarCitas(@RequestBody Cita cita) {
        return this.Cita_service.guardarCitas(cita);//llamamos el metodo del servicio
    }

    @GetMapping(path = "/{id}")// usuario/id
    public CitaDto obtenerCitas(@PathVariable("id") Long id) {
        return Cita_service.obtenerPorId(id); //invocamos el metodo del servicio
    }


    @DeleteMapping(path = "{id}")
    public String eliminarporId(@PathVariable("id") Long id){
        boolean ok = this.Cita_service.eliminarCita(id);
        if (ok){
            return "Usuario eliminado con id"+ id;
        }else{
            return "No se puedo eliminar el usuario con id"+ id;
        }

    }

}
