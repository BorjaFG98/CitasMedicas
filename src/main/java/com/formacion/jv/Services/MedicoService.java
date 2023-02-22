package com.formacion.jv.Services;

import com.formacion.jv.Entity.Medico;
import com.formacion.jv.Entity.Usuario;
import com.formacion.jv.Repositories.MedicoRepository;
import com.formacion.jv.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired //NO hace falta instaciar, spring lo hará por sí
    MedicoRepository Med_repo;

    public List<Medico> obtenerMedicos() {
        return this.Med_repo.findAll(); //muestra todos los medicos
    }

    public Medico guardarMedicos(Medico medico) {
        return this.Med_repo.save(medico); //recibe la informacion y la devuelve con el id para poder recargar la info
    }

    public ArrayList<Medico> obtenerPorNumColegiado(String Medico){
        return Med_repo.findByNumColegiado(Medico);//Causa una excepcion si falla, se pone como opcional por si damos una Id que no está
    }

    public Optional<Medico> obtenerPorId(long id){
        return Med_repo.findById(id);//Causa una excepcion si falla, se pone como opcional por si damos una Id que no está
    }


    public boolean eliminarmedico(long id){
        try{
            Med_repo.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }


    public ArrayList<Medico> obtenerPorUsuario(String usuario){
        return Med_repo.findByUsuario(usuario); //Usamos el metodo abstracto que declaramos en repo
    }


}