
package edu.altair.crmfaltas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @Column(name = "departamento_codigo", nullable = false, length = 10)
    private String departamento_codigo;

    @Column(name = "nombre_departamento", nullable = false, length = 30)
    private String nombre_departamento;

    @OneToMany(
        mappedBy = "departamento",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.LAZY
    )
    private List<Profesor> profesores = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String departamento_codigo, String nombre_departamento) {
        this.departamento_codigo = departamento_codigo;
        this.nombre_departamento = nombre_departamento;
    }

    public void addProfesor(Profesor profesor) {
        profesores.add(profesor);
        profesor.setDepartamento(this);
    }

    public void removeProfesor(Profesor profesor) {
        profesores.remove(profesor);
        profesor.setDepartamento(null);
    }

    public String getDepartamento_codigo() {
        return departamento_codigo;
    }

    public void setDepartamento_codigo(String departamento_codigo) {
        this.departamento_codigo = departamento_codigo;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
}
