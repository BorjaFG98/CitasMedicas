package com.formacion.jv.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.formacion.jv.Entity.Diagnostico} entity
 */
@Data
public class DiagnosticoDto implements Serializable {
    private  Long id;
    @NotEmpty
    private String valoracion;
    @NotEmpty
    private String enfermedad;
    @NotNull
    private  CitaDto cita;

    public DiagnosticoDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public CitaDto getCita() {
        return cita;
    }

    public void setCita(CitaDto cita) {
        this.cita = cita;
    }
}