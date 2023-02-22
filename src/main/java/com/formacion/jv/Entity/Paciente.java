package com.formacion.jv.Entity;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Usuario {


    @Column(name = "Nss", nullable = false, unique = true)
    private String nss;
    @Column(name = "numTarjeta", nullable = false)
    private String numTarjeta;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "direccion", nullable = false)
    private String direccion;
    @OneToMany(mappedBy = "pacientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "medicos_pacientes",
            inverseJoinColumns = @JoinColumn(name = "medico_id"))
    private List<Medico> medicos = new ArrayList<>();



    // Constructor vacío
    public Paciente() {
    }

    // Constructor con parámetros
    public Paciente(String nombre, String apellidos, String usuario, String clave, String nss, String numTarjeta, String telefono, String direccion, List<Cita> citas, ArrayList<Medico> Medicos) {
        super( nombre, apellidos, usuario, clave);
        nss = nss;
        this.numTarjeta = numTarjeta;
        this.telefono = telefono;
        this.direccion = direccion;
        this.medicos=Medicos;
        this.citas=citas;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
