package com.formacion.jv.Entity;



import jakarta.persistence.*;

@Entity
@Table(name = "Diagnosticos")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(name = "valoracion", nullable = false)
    private String valoracion;

    @Column(name = "enfermedad", nullable = false)
    private String enfermedad;

    @OneToOne()
    @JoinColumn(name="CITA_ID")
    private Cita cita;

    public Diagnostico() {
    }

    public Diagnostico(Long id, String valoracion, String enfermedad, Cita cita) {
        super();
        this.id = id;
        this.valoracion = valoracion;
        this.enfermedad = enfermedad;
        this.cita = cita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {this.valoracion = valoracion;}


    public String getEnfermedad() {return enfermedad;}

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public Cita getCita() {return cita;}
    public void setCita(Cita cita) {this.cita = cita;}


}


