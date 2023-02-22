package com.formacion.jv.Services;

import com.formacion.jv.Entity.Cita;
import com.formacion.jv.Repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    CitaRepository Cita_repo;

    public List<Cita> obtenerCitas() {
        return this.Cita_repo.findAll(); //muestra todos los usuarios
    }

    public Cita guardarCitas(Cita cita) {
        return this.Cita_repo.save(cita); //recibe la informacion y la devuelve con el id para poder recargar la info
    }

    public Optional<Cita> obtenerPorId(long id){
        return Cita_repo.findById(id);//Causa una excepcion si falla, se pone como opcional por si damos una Id que no está
    }

    public boolean eliminarCita(long id) {
        try {
            Cita_repo.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }

    }

}
