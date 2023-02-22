package com.formacion.jv.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.formacion.jv.Entity.Medico} entity
 */
public class MedicoDto implements Serializable {
    private final String nombre;
    private final String apellidos;
    private final String usuario;
    private final String clave;
    private final String numColegiado;
    private List<PacienteDto> pacientes;

    private List<CitaDto> citas;

    public MedicoDto(String nombre, String apellidos, String usuario, String clave, String numColegiado, PacienteDto pacientes, CitaDto citas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.numColegiado = numColegiado;
        this.pacientes= (List<PacienteDto>) pacientes;
        this.citas= (List<CitaDto>) citas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public List<PacienteDto> getPacientes() {return pacientes;}

    public void setPacientes(List<PacienteDto> pacientes) {this.pacientes = pacientes;}

    public List<CitaDto> getCitas() {return citas;}

    public void setCitas(List<CitaDto> citas) {this.citas = citas;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoDto entity = (MedicoDto) o;
        return Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.apellidos, entity.apellidos) &&
                Objects.equals(this.usuario, entity.usuario) &&
                Objects.equals(this.clave, entity.clave) &&
                Objects.equals(this.pacientes, entity.pacientes) &&
                Objects.equals(this.citas  , entity.citas) &&
                Objects.equals(this.numColegiado, entity.numColegiado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, usuario, clave, numColegiado, pacientes, citas);
    }

    @Override
    public String toString() {
        return "MedicoDto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", numColegiado='" + numColegiado + '\'' +
                ", pacientes=" + pacientes +
                ", citas=" + citas +
                '}';
    }
}