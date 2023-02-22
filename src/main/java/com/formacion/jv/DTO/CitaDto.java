package com.formacion.jv.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * A DTO for the {@link com.formacion.jv.Entity.Cita} entity
 */
@Data
public class CitaDto implements Serializable {
    private Long id;
    @NotEmpty
    private LocalDateTime fechaHora;
    @NotEmpty
    private String motivoCita;
    @NotEmpty
    private MedicoDto medico;

    @NotEmpty
    private PacienteDto paciente;
    @NotEmpty
    private DiagnosticoDto diagnostico;

    public CitaDto() {}

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

    public MedicoDto getMedico() {
        return medico;
    }

    public void setMedico(MedicoDto medico) {
        this.medico = medico;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public DiagnosticoDto getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(DiagnosticoDto diagnostico) {
        this.diagnostico = diagnostico;
    }
}