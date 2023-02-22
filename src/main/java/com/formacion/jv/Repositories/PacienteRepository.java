package com.formacion.jv.Repositories;

import com.formacion.jv.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.ArrayList;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    public abstract List<Paciente> findByNumTarjeta(String Paciente);
    public abstract ArrayList<Paciente> findByNss(String Paciente);
    public abstract ArrayList<Paciente> findByUsuario(String usuario);
}
