package com.formacion.jv.Entity;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;


@Entity
@Table(name = "CITAS")
public class Cita {
    @Id
    @SequenceGenerator(name = "CITA_ID_SEQ", sequenceName = "CITA_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CITA_ID_SEQ")
    @Column(name = "ID")
    private Long id;


    @Column(name = "fechaHora")
    @JdbcTypeCode(SqlTypes.TIMESTAMP_UTC)
    private LocalDateTime fechaHora;

    @Column(name = "MOTIVO_CITA", nullable = false)
    private String motivoCita;

    @ManyToOne
    @JoinColumn(name = "MEDICO_ID")
    private Medico medicos;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID")
    private Paciente pacientes;

    @OneToOne(mappedBy = "cita")
    private Diagnostico diagnostico;


    public Cita() {
    }

    public Cita(Long iD, LocalDateTime fechaHora,
                String motivoCita, Medico medico,
                Paciente paciente, Diagnostico diagnostico) {
        super();
        id = iD;
        this.fechaHora = fechaHora;
        this.motivoCita = motivoCita;
        this.medicos = medico;
        this.pacientes = paciente;
        this.diagnostico=diagnostico;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}