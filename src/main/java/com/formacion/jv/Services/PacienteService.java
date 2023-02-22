package com.formacion.jv.Services;

import com.formacion.jv.Entity.Paciente;
import com.formacion.jv.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
  @Autowired //NO hace falta instaciar, spring lo hará por sí
  PacienteRepository Pac_repo;

    public List<Paciente> obtenerPacientes() {
        return this.Pac_repo.findAll(); //muestra todos los medicos
    }

    public Paciente guardarPacietes(Paciente paciente) {
        return this.Pac_repo.save(paciente); //recibe la informacion y la devuelve con el id para poder recargar la info
    }

    public List<Paciente> obtenerPorNumTarjeta(String paciente){
        return Pac_repo.findByNumTarjeta(paciente);//Causa una excepcion si falla, se pone como opcional por si damos una Id que no está
    }

    public Optional<Paciente> obtenerPorId(long id){
        return Pac_repo.findById(id);//Causa una excepcion si falla, se pone como opcional por si damos una Id que no está
    }


    public boolean eliminarpaciente(long id){
        try{
            Pac_repo.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }


    public ArrayList<Paciente> obtenerPorUsuario(String usuario){
        return Pac_repo.findByUsuario(usuario); //Usamos el metodo abstracto que declaramos en repo
    }

    public ArrayList<Paciente> obtenerPorNss(String usuario){
        return Pac_repo.findByNss(usuario); //Usamos el metodo abstracto que declaramos en repo
    }

}