
package edu.altair.crmfaltas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @Column(name = "DNI", nullable = false, length = 9)
    private String DNI;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @OneToMany(
        mappedBy = "estudiante",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.LAZY
    )
    private List<Matricula> matriculas = new ArrayList<>();

    public Estudiante() {
    }

    public Estudiante(String DNI, String nombre) {
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
        matricula.setEstudiante(this);
    }

    public void removeMatricula(Matricula matricula) {
        matriculas.remove(matricula);
        matricula.setEstudiante(null);
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
