package com.formacion.jv.Services;

import com.formacion.jv.DTO.CitaDto;
import com.formacion.jv.Entity.Cita;
import com.formacion.jv.Exception.NotFoundException;
import com.formacion.jv.Mapper.CitaMapper;
import com.formacion.jv.Repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    @Autowired
    CitaRepository Cita_repo;

    public List<CitaDto> obtenerCitas() {
        List<CitaDto> citasDTO = new ArrayList<>();
        for (Cita cita : Cita_repo.findAll()) {
            citasDTO.add(CitaMapper.INSTANCE.citaToCitaDto(cita));
        }

        return citasDTO;
    }

    public Cita guardarCitas(Cita cita) {
        return this.Cita_repo.save(cita); //recibe la informacion y la devuelve con el id para poder recargar la info
    }

    public CitaDto obtenerPorId(Long id) {
        Optional<Cita> cita = Cita_repo.findById(id);
        if (cita.isEmpty()) {
            throw new NotFoundException("Medico not found : " + id);
        }

        return CitaMapper.INSTANCE.citaToCitaDto(cita.get());
    }

    public boolean eliminarCita (long id) {
        try {
            Cita_repo.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }

    }

}
