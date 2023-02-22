package com.formacion.jv.Repositories;

import com.formacion.jv.Entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    public abstract ArrayList<Medico> findByNumColegiado(String Medico);
    public abstract ArrayList<Medico> findByUsuario(String usuario);
}