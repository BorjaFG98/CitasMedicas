package com.formacion.jv.Services;

import com.formacion.jv.DTO.MedicoDto;
import com.formacion.jv.Entity.Medico;
import com.formacion.jv.Exception.NotFoundException;
import com.formacion.jv.Mapper.MedicoMapper;
import com.formacion.jv.Repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MedicoService {
    @Autowired //NO hace falta instaciar, spring lo hará por sí
    MedicoRepository Med_repo;

    public List<MedicoDto> obtenerMedicos() {
        List<MedicoDto> medicoDtos = new ArrayList<>();
        for (Medico medico : Med_repo.findAll()) {
            MedicoDto medicoDto = MedicoMapper.INSTANCE.medicoToMedicoDto(medico);
            medicoDtos.add(medicoDto);
        }
        return medicoDtos;
    } //muestra todos los medicos

    public MedicoDto guardarMedicos (Medico user){
        Medico medico = Med_repo.save(user);
        return MedicoMapper.INSTANCE.medicoToMedicoDto(user);//recibe la informacion y la devuelve con el id para poder recargar la info

    }

    public MedicoDto obtenerPorId(Long id){
        Optional <Medico> medico = Med_repo.findById(id);
        if (medico.isEmpty()){
            throw new NotFoundException("Medico not found : " + id);
        }
        return MedicoMapper.INSTANCE.medicoToMedicoDto(medico.get());
    }

    public List<MedicoDto> obtenerPorNumColegiado(String user){
        List<MedicoDto> medicoDtos = new ArrayList<>();
        for (Medico medico : Med_repo.findByNumColegiado(user)) {
            MedicoDto medicoDto = MedicoMapper.INSTANCE.medicoToMedicoDto(medico);
            medicoDtos.add(medicoDto);
        }
        return medicoDtos; //Usamos el metodo abstracto que declaramos en repo
    }

    public List<MedicoDto> obtenerPorUsuario(String user){
        List<MedicoDto> medicoDtos = new ArrayList<>();
        for (Medico medico : Med_repo.findByNumColegiado(user)) {
            MedicoDto medicoDto = MedicoMapper.INSTANCE.medicoToMedicoDto(medico);
            medicoDtos.add(medicoDto);
        }
        return medicoDtos; //Usamos el metodo abstracto que declaramos en repo
    }

    public boolean eliminarmedico(long id){
        try{
            Med_repo.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }




}