package com.formacion.jv.Entity;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "medicos")
@PrimaryKeyJoinColumn(name = "id")
public class Medico extends Usuario {
    @Column(name = "numColegiado", nullable = false, unique = true)
    private String numColegiado;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "medicos")
    private List<Paciente> pacientes = new ArrayList<>();

    @OneToMany(mappedBy = "medicos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    // Constructor vacío
    public Medico() {}

    // Constructor con parámetros
    public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado, ArrayList<Paciente> pacientes, List<Cita> citas) {
        super(nombre, apellidos, usuario, clave);
        this.numColegiado = numColegiado;
        this.pacientes= pacientes;
        this.citas= citas;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}

