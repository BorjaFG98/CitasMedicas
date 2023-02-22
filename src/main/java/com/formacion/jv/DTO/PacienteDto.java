package com.formacion.jv.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link com.formacion.jv.Entity.Paciente} entity
 */
public class PacienteDto implements Serializable {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String clave;
    private String numColegiado;
    private List<MedicoDto> medicos;

    private List<CitaDto> citas;

    public PacienteDto(String nombre, String apellidos, String usuario, String clave, String numColegiado, MedicoDto medicos, CitaDto citas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.numColegiado = numColegiado;
        this.medicos= (List<MedicoDto>) medicos;
        this.citas= (List<CitaDto>) citas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    public List<MedicoDto> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoDto> medicos) {
        this.medicos = medicos;
    }

    public List<CitaDto> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaDto> citas) {
        this.citas = citas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PacienteDto entity = (PacienteDto) o;
        return Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.apellidos, entity.apellidos) &&
                Objects.equals(this.usuario, entity.usuario) &&
                Objects.equals(this.clave, entity.clave) &&
                Objects.equals(this.medicos, entity.medicos) &&
                Objects.equals(this.citas, entity.citas) &&
                Objects.equals(this.numColegiado, entity.numColegiado);
    }


    @Override
    public String toString() {
        return "PacienteDto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", numColegiado='" + numColegiado + '\'' +
                ", medicos=" + medicos +
                ", citas=" + citas +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, usuario, clave, numColegiado, medicos, citas);
    }

}