package com.formacion.jv.Controllers;

import com.formacion.jv.DTO.PacienteDto;
import com.formacion.jv.Entity.Medico;
import com.formacion.jv.Entity.Paciente;
import com.formacion.jv.Services.MedicoService;
import com.formacion.jv.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService Pac_service;


    @GetMapping
    public List<PacienteDto> obtenerPacientes() {
        return Pac_service.obtenerPacientes();//invocamos el metodo del servicio
    }

    @PostMapping()
    public Paciente guardarPacientes(@RequestBody Paciente medico) {
        return this.Pac_service.guardarPacietes(medico);//llamamos el metodo del servicio
    }

    @GetMapping(path = "/{id}")// pacientes/id
    public Optional<Paciente> obtenerPacientes(@PathVariable("id") Long id) {
        return Pac_service.obtenerPorId(id); //invocamos el metodo del servicio
    }

    @GetMapping("/query")
    public List<PacienteDto> obtenerPacientebyusuario(@RequestParam("usuario") String usuario){
        return this.Pac_service.obtenerPorUsuario(usuario);//ejemplo: local.../usuario?usuario=GOD
    }
    @GetMapping("/query1")
    public List<Paciente> obtenerPacientebynumTarjeta(@RequestParam("numTarjeta") String numTarjeta){
        return this.Pac_service.obtenerPorNumTarjeta(numTarjeta);//ejemplo: local.../usuario/query?usuario=GOD
    }
    @GetMapping("/query2")
    public List<Paciente> obtenerPacientebyNss(@RequestParam("nss") String Nss){
        return this.Pac_service.obtenerPorNss(Nss);//ejemplo: local.../usuario/query?usuario=GOD
    }

    @DeleteMapping(path = "{id}")
    public String eliminarporId(@PathVariable("id") Long id){
        boolean ok = this.Pac_service.eliminarpaciente(id);
        if (ok){
            return "Usuario eliminado con id"+ id;
        }else{
            return "No se puedo eliminar el usuario con id"+ id;
        }

    }


}
