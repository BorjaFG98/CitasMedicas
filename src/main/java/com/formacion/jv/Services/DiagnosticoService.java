package com.formacion.jv.Services;

import com.formacion.jv.Entity.Diagnostico;
import com.formacion.jv.Repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    @Autowired
    DiagnosticoRepository Diagn_repo;


    public List<Diagnostico> obtenerDiagnosticos(){return this.Diagn_repo.findAll();}
    public Diagnostico guardarDiagnostico(Diagnostico diagnostico){return this.Diagn_repo.save(diagnostico);}
    public Optional<Diagnostico> obtenerPorId(long id){
        return Diagn_repo.findById(id);
    }


    public boolean eliminarDiagnostico(Long id) {
        try{
            Diagn_repo.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }

    }
}
