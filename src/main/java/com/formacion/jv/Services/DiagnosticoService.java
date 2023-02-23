package com.formacion.jv.Services;

import com.formacion.jv.DTO.DiagnosticoDto;
import com.formacion.jv.Entity.Diagnostico;
import com.formacion.jv.Exception.NotFoundException;
import com.formacion.jv.Mapper.DiagnosticoMapper;
import com.formacion.jv.Repositories.DiagnosticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoService {

    @Autowired
    DiagnosticoRepository Diagn_repo;


    public List<DiagnosticoDto> obtenerDiagnosticos() {
        List<DiagnosticoDto> diagnosticosDTO = new ArrayList<DiagnosticoDto>();
        for (Diagnostico diagnostico : Diagn_repo.findAll()) {
            diagnosticosDTO.add(DiagnosticoMapper.INSTANCE.diagnosticoToDiagnosticoDTO(diagnostico));
        }
        return diagnosticosDTO;
    }
    public Diagnostico guardarDiagnostico(Diagnostico diagnostico){return this.Diagn_repo.save(diagnostico);}
    public DiagnosticoDto obtenerPorId(Long id) {
        Optional<Diagnostico> diagnostico = Diagn_repo.findById(id);
        if (diagnostico.isEmpty()) {
            throw new NotFoundException("Diagnostico not found : " + id);
        }

        return DiagnosticoMapper.INSTANCE.diagnosticoToDiagnosticoDTO(diagnostico.get());
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
