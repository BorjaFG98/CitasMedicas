package com.formacion.jv.DTO;

import java.io.Serializable;
import java.util.Objects;
import jakarta.validation.constraints.NotEmpty;

/**
 * A DTO for the {@link com.formacion.jv.Entity.Usuario} entity
 */
public class UsuarioDto implements Serializable {
    private Long id;

    @NotEmpty(message = "nombre must not be empty")
    private String nombre;
    @NotEmpty(message = "apellidos must not be empty")
    private String apellidos;
    @NotEmpty(message = "usuario must not be empty")
    private String usuario;
    @NotEmpty(message = "clave must not be empty")
    private  String clave;

    public UsuarioDto(Long id, String nombre, String apellidos, String usuario, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {this.id = id;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public void setUsuario(String usuario) {this.usuario = usuario;}

    public void setClave(String clave) {this.clave = clave;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto entity = (UsuarioDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.apellidos, entity.apellidos) &&
                Objects.equals(this.usuario, entity.usuario) &&
                Objects.equals(this.clave, entity.clave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, usuario, clave);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "apellidos = " + apellidos + ", " +
                "usuario = " + usuario + ", " +
                "clave = " + clave + ")";
    }
}