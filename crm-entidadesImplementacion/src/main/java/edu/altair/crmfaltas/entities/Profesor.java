
package edu.altair.crmfaltas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private Long profesorId;

    @Column(name = "DNI", nullable = false, unique = true, length = 9)
    private String DNI;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "departamento_codigo",
        nullable = false,
        foreignKey = @ForeignKey(name = "fk_profesores_departamento")
    )
    private Departamento departamento;

    @OneToMany(
        mappedBy = "profesor",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE},
        fetch = FetchType.LAZY
    )
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Profesor() {
    }

    public Profesor(Long profesorId, String DNI, String nombre) {
        this.profesorId = profesorId;
        this.DNI = DNI;
        this.nombre = nombre;
    }

    public void addAsignatura(Asignatura asignatura) {
        asignaturas.add(asignatura);
        asignatura.setProfesor(this);
    }

    public void removeAsignatura(Asignatura asignatura) {
        asignaturas.remove(asignatura);
        asignatura.setProfesor(null);
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
